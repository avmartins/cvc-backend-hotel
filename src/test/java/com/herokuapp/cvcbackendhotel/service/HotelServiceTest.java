package com.herokuapp.cvcbackendhotel.service;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.herokuapp.cvcbackendhotel.bean.Hotel;
import com.herokuapp.cvcbackendhotel.bean.Price;
import com.herokuapp.cvcbackendhotel.bean.Room;
import com.herokuapp.cvcbackendhotel.service.impl.HotelServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelServiceTest {

    @InjectMocks
    private HotelServiceImpl service;

    @Test
    public void deveCalcularOValorTotalDaComissao() {
        Price price = new Price();
        price.setAdult(BigDecimal.valueOf(100));
        price.setChild(BigDecimal.valueOf(50));

        Room room = new Room();
        room.setPrice(price);

        Price price1 = new Price();
        price1.setAdult(BigDecimal.valueOf(200));
        price1.setChild(BigDecimal.valueOf(100));

        Room room1 = new Room();
        room1.setPrice(price1);

        Price price2 = new Price();
        price2.setAdult(BigDecimal.valueOf(300));
        price2.setChild(BigDecimal.valueOf(200));

        Room room2 = new Room();
        room2.setPrice(price2);

        Hotel hotel = new Hotel();
        hotel.setRooms(Arrays.asList(room, room1, room2));

        Hotel hotel1 = new Hotel();
        hotel1.setRooms(Arrays.asList(room, room2));

        Hotel[] hotels = {hotel, hotel1};

        Hotel hotelAtual = service.run(hotels, "24-08-2019", "29-08-2019",
                2L, 1L);

        Assert.assertEquals(BigDecimal.valueOf(18567), hotelAtual.getRooms().get(0).getTotalPrice());
        Assert.assertEquals(BigDecimal.valueOf(1000), hotelAtual.getRooms().get(0).getPriceDetail().getPricePerDayAdult());
        Assert.assertEquals(BigDecimal.valueOf(250), hotelAtual.getRooms().get(0).getPriceDetail().getPricePerDayChild());

    }

}
