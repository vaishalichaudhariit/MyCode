package com.guice.singleImpl;

public class EarlyBirdDiscount implements Discountable{
	
	@Override
	public double getDiscount(){
		return 0.25;
	}

}
