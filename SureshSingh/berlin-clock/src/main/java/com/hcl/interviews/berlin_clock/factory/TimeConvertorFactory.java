/**
 * 
 */
package com.hcl.interviews.berlin_clock.factory;

import com.hcl.interviews.TimeConverter;
import com.hcl.interviews.impl.Hour;
import com.hcl.interviews.impl.Minute;
import com.hcl.interviews.impl.Second;

/**
 * Class return the instances of the pass type
 * @author Suresh
 * @version 1.0
 * @since 23-04-2017
 *
 */
public class TimeConvertorFactory {

	/**
	 * Factory to create an instance of the type passed as an argument
	 * @param timeUnit This argument define the type of instance creation required.
	 * @return TimeConverter an instances of the pass type
	 */
	public static TimeConverter getConverter(String timeUnit){
		if(timeUnit == null){
			return null;
		}
		if(timeUnit.equalsIgnoreCase(FactoryConstants.HOUR.getTIME_UNIT())){
			return new Hour();
		}
		if(timeUnit.equalsIgnoreCase(FactoryConstants.MINUTE.getTIME_UNIT())){
			return new Minute();
		}
		if(timeUnit.equalsIgnoreCase(FactoryConstants.SECOND.getTIME_UNIT())){
			return new Second();
		}
	
		return null;
	}
	
}
