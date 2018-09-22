package com.guice.explicitProvider;

public class EarlyBirdDiscount implements Discountable{
	
	@Override
	public double getDiscount(){
		return 0.25D;
	}

}
