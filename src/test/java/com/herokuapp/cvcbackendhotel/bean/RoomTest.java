package com.herokuapp.cvcbackendhotel.bean;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class RoomTest {

    @Test
    public void deveCalcularAComissao() {
        Price price = new Price();
        price.setAdult(BigDecimal.valueOf(100));
        price.setChild(BigDecimal.valueOf(50));

        Room room = new Room();
        room.setPrice(price);
        BigDecimal total = room.calcCommission(5L, 2L, 1L);
        Assert.assertEquals(BigDecimal.valueOf(1785L), total);
    }

    @Test
    public void naoDeveCalcularAComissao() {
        Room room = new Room();
        BigDecimal total = room.calcCommission(5L, 2L, 1L);
        Assert.assertNull(total);
    }

}
