package com.guice.explicitProvider;


public class DiscountGuiceModule extends com.google.inject.AbstractModule {
	
	@Override
	protected void configure(){
		bind(Discountable.class).toProvider(DiscountProvider.class);
	}
	
}
