package com.guice.customFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class BasicApplication {

		private final CheckoutService checkoutService;
		
		@Inject
		public BasicApplication(CheckoutService checkoutService){
			this.checkoutService = checkoutService;
		}
		
		void start(){
			while(true){
			checkoutService.checkout(getNewUserCheckout());
			}
		}
		
		public static void main(String[] args) {
			Injector guice = Guice.createInjector(new DiscountGuiceModule());
			BasicApplication application = guice.getInstance(BasicApplication.class);
			application.start();
		}
		
		/***************************************************************************/
		/************************** Our GUI Simulator ******************************/
		/***************************************************************************/
		
		ShoppingCart getNewUserCheckout(){
			
			ShoppingCart cart = new ShoppingCart();
			cart.setCartTotal(getTotalFromInput());
			cart.setTimeOfCheckout(getCheckoutTimeFromInput());
			return cart;
		}
		
		private double getTotalFromInput(){
			String total = null;
			System.out.println("Enter cart total: ");
			try{
				BufferedReader bufferRead = new BufferedReader (new InputStreamReader(System.in));
				total = bufferRead.readLine();
			}catch (IOException e){
			}
			return Double.valueOf(total);
			}
		
		private  LocalTime getCheckoutTimeFromInput(){
			String hour = null;
			System.out.println("Enter Checkout hour: ");
			try{
				BufferedReader bufferRead = new BufferedReader (new InputStreamReader(System.in));
				hour = bufferRead.readLine();
			}catch (IOException e){
			}
			 return LocalTime.of(Integer.valueOf(hour), 0);
		}
}
