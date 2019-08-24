package com.herokuapp.cvcbackendhotel.service;

import com.herokuapp.cvcbackendhotel.bean.Hotel;

public interface HotelService {

    Hotel run(Hotel[] hotels, String dateCheckin, String dateCheckout, Long totAdults, Long totChildren);

}
