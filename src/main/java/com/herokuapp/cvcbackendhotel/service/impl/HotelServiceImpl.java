package com.herokuapp.cvcbackendhotel.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.herokuapp.cvcbackendhotel.bean.Hotel;
import com.herokuapp.cvcbackendhotel.bean.Room;
import com.herokuapp.cvcbackendhotel.service.HotelService;
import com.herokuapp.cvcbackendhotel.service.util.LocalDateUtil;

@Service
public class HotelServiceImpl implements HotelService {

    @Override
    public Hotel run(Hotel[] hotels, String dateCheckin, String dateCheckout, Long totAdults, Long totChildren) {
        Hotel hotel = hotels[0];
        Long numberOfDays = LocalDateUtil.getTotalDoPeridoDeDias(dateCheckin, dateCheckout);
        BigDecimal accumulatedVal = BigDecimal.ZERO;
        for(Hotel hotelOther : hotels) {
            for(Room room : hotelOther.getRooms()) {
            	
            	if (room.getPrice() != null) {
            		accumulatedVal = accumulatedVal.add(room.calcCommission(numberOfDays, totAdults, totChildren));
            		hotel.getRooms().get(0).setTotalPrice(accumulatedVal);
            	}
            }
        }
        return hotel;
    }


}
