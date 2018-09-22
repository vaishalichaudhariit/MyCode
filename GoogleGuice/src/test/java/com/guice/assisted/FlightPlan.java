/**
 * 
 */
package com.guice.assisted;

/**
 * @author Vaishali.Chaudhari
 *
 */
public class FlightPlan {
	 private final Long flightID ;
	    private String acid;

	    public FlightPlan(Long flightID) {
	        this.flightID = flightID;
	    }

	    public Long getFlightID() {
	        return flightID;
	    }

	    public String getAcid() {
	        return acid;
	    }
	    
	    public FlightPlan setAcid(String acid){
	        this.acid = acid;
	        return this;
	    }
}
