package com.herokuapp.cvcbackendhotel.bean;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class PriceTest {

    @Test
    public void deveCalcularOPrecoPelaQuantidadeDeDiasPorAdulto() {
        Price price = new Price();
        price.setAdult(BigDecimal.valueOf(100));
        BigDecimal total = price.calcAdultVal(5L, 2L);
        Assert.assertEquals(BigDecimal.valueOf(1000L), total);
    }

    @Test
    public void deveCalcularOPrecoPelaQuantidadeDeDiasPorCrianca() {
        Price price = new Price();
        price.setChild(BigDecimal.valueOf(50));
        BigDecimal total = price.calcChildVal(5L, 1L);
        Assert.assertEquals(BigDecimal.valueOf(250L), total);
    }

    @Test
    public void naoDeveCalcularOPrecoPelaQuantidadeDeDiasPorAdulto() {
        Price price = new Price();
        BigDecimal total = price.calcAdultVal(5L, 1L);
        Assert.assertNull(total);
    }

    @Test
    public void naoDeveCalcularOPrecoPelaQuantidadeDeDiasPorCrianca() {
        Price price = new Price();
        BigDecimal total = price.calcChildVal(5L, 1L);
        Assert.assertNull(total);
    }

}
