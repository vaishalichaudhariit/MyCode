package com.guice.ProvidedByAnnotation;

import com.google.inject.ProvidedBy;

@ProvidedBy(DiscountProvider.class)
public interface Discountable {
	double getDiscount();
}
