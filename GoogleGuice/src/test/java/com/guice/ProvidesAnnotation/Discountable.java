package com.guice.ProvidesAnnotation;

import com.google.inject.ImplementedBy;

@ImplementedBy(EarlyBirdDiscount.class)
public interface Discountable {
	double getDiscount();
}
