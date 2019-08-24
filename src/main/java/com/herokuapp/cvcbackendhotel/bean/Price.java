package com.herokuapp.cvcbackendhotel.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Price implements Serializable {

	private static final long serialVersionUID = -2165395372496882220L;

	private BigDecimal adult;

	private BigDecimal child;

	public BigDecimal calcAdultVal(Long qtdDays, Long totAdults) {
		if (this.adult == null) {
			return null;
		}
		BigDecimal valorPorAdulto = adult.multiply(BigDecimal.valueOf(totAdults));
		return valorPorAdulto.multiply(BigDecimal.valueOf(qtdDays));
	}

	public BigDecimal calcChildVal(Long numberOfDays, Long totChildren) {
		if (this.child == null) {
			return null;
		}
		BigDecimal valueByChild = child.multiply(BigDecimal.valueOf(totChildren));
		return valueByChild.multiply(BigDecimal.valueOf(numberOfDays));
	}

	public Price(BigDecimal adult, BigDecimal child) {
		super();
		this.adult = adult;
		this.child = child;
	}

	public Price() {
	}

	public BigDecimal getAdult() {
		return adult;
	}

	public void setAdult(BigDecimal adult) {
		this.adult = adult;
	}

	public BigDecimal getChild() {
		return child;
	}

	public void setChild(BigDecimal child) {
		this.child = child;
	}

}
