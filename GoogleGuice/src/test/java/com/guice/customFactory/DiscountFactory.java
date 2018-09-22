package com.guice.customFactory;

import com.google.inject.ImplementedBy;

@ImplementedBy(CartDiscountFactory.class)
interface DiscountFactory {
        public Discountable getDiscount(ShoppingCart cart);
}