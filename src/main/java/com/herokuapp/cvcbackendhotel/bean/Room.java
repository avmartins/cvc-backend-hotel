package com.herokuapp.cvcbackendhotel.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Room implements Serializable {
	
	private static final long serialVersionUID = -4900406299322507852L;
	

    private Long roomID;
    private String categoryName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Price price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal totalPrice;

    private PriceDetail priceDetail;

	public Long getRoomID() {
		return roomID;
	}

	public void setRoomID(Long roomID) {
		this.roomID = roomID;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal calcCommission(Long numberOfDays, Long totAdults, Long totChildren) {
        if(this.price == null) {
            return null;
        }

        BigDecimal valAdult = this.price.calcAdultVal(numberOfDays, totAdults);
        BigDecimal valChild = this.price.calcChildVal(numberOfDays, totChildren);

        this.priceDetail = new PriceDetail(valAdult, valChild);

        BigDecimal valCommissionAdult = this.priceDetail.getPricePerDayAdult().divide(
                BigDecimal.valueOf(0.7), BigDecimal.ROUND_FLOOR);
        BigDecimal valCommissionChild = this.priceDetail.getPricePerDayChild().divide(
                BigDecimal.valueOf(0.7), BigDecimal.ROUND_FLOOR);

        return valCommissionAdult.add(valCommissionChild);
    }

	public PriceDetail getPriceDetail() {
		return priceDetail;
	}

	public void setPriceDetail(PriceDetail priceDetail) {
		this.priceDetail = priceDetail;
	}
	
	
    
}
