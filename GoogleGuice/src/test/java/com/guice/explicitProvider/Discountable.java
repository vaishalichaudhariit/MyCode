package com.guice.explicitProvider;

import com.google.inject.ImplementedBy;

@ImplementedBy(EarlyBirdDiscount.class)
public interface Discountable {
	double getDiscount();
}
