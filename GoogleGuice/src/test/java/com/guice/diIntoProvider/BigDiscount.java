package com.guice.diIntoProvider;

public class BigDiscount implements Discountable{

	@Override
	public double getDiscount(){
		return 0.35D;
	}
}
