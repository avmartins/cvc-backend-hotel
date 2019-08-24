package com.herokuapp.cvcbackendhotel.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonView;
import com.herokuapp.cvcbackendhotel.web.jsonview.Views;

public class PriceDetail implements Serializable {

	private static final long serialVersionUID = 1812814657116430764L;

	@JsonView(Views.Public.class)
	private BigDecimal pricePerDayAdult;

	@JsonView(Views.Public.class)
	private BigDecimal pricePerDayChild;

	public BigDecimal getPricePerDayAdult() {
		return pricePerDayAdult;
	}

	public void setPricePerDayAdult(BigDecimal pricePerDayAdult) {
		this.pricePerDayAdult = pricePerDayAdult;
	}

	public BigDecimal getPricePerDayChild() {
		return pricePerDayChild;
	}

	public void setPricePerDayChild(BigDecimal pricePerDayChild) {
		this.pricePerDayChild = pricePerDayChild;
	}

	public PriceDetail(BigDecimal pricePerDayAdult, BigDecimal pricePerDayChild) {
		this.pricePerDayAdult = pricePerDayAdult;
		this.pricePerDayChild = pricePerDayChild;
	}

}
