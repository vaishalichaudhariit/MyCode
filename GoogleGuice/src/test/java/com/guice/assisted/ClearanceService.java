/**
 * 
 */
package com.guice.assisted;

import com.google.inject.Inject;
import com.guice.assisted.ClearanceProber.ClearaceProberFactory;

/**
 * @author Vaishali.Chaudhari
 *
 */
public class ClearanceService {
	 private final ClearaceProberFactory clearaceProberFactory;
	    
	    @Inject
	    public ClearanceService(ClearaceProberFactory clearaceProberFactory) {
	        this.clearaceProberFactory = clearaceProberFactory;
	    }
	    
	    public Clearance requestClearance(String proposedClearance, FlightPlan flightPlan) throws ClearanceException
	    {
	        Clearable clearaceProber = clearaceProberFactory.create(proposedClearance, flightPlan.getFlightID());
	        return clearaceProber.probeClearance();
	    }
	    
	   
}
