package com.guice.singleImpl;

public class DiscountGuiceModule extends com.google.inject.AbstractModule {
	
	@Override
	protected void configure(){
		bind(Discountable.class).to(NightOwlDiscount.class);
	}

}
