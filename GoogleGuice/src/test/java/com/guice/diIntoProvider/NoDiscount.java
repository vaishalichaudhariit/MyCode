package com.guice.diIntoProvider;

public class NoDiscount implements Discountable {

	@Override
	public double getDiscount(){
		return 0.0D;
	}
}
