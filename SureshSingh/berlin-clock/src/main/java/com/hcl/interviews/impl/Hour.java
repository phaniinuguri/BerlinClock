/**
 * 
 */
package com.hcl.interviews.impl;

import com.hcl.interviews.TimeConverter;
import com.hcl.interviews.utils.BerlinClockUtil;
import com.hcl.interviews.utils.Constants;
import com.hcl.interviews.utils.Lamp;

/**
 * Responsible for hour representation in the Berlin clock
 * 
 * @author Suresh
 * @version 1.0
 * @since 23-04-2017
 */
public class Hour implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		// Convert the String into integer
		int hourUnit = BerlinClockUtil.convertStringToInt(aTime);
		StringBuilder hourBuilder = new StringBuilder();
		
		//Dividing the hour unit with 5 to find the quotient and remainder
		int remainder = hourUnit % Constants.DIVISOR_FIVE;
		
		int quotient = hourUnit / Constants.DIVISOR_FIVE;

		
		//Find the status(on/off) 5 hr unit lamp
		BerlinClockUtil.getLamps(hourBuilder, quotient, Constants.HOUR_ROW,
				Lamp.RED.getStatus());
		hourBuilder.append("\r\n");
		//Find the status(on/off) 1 hr unit lamp
		BerlinClockUtil.getLamps(hourBuilder, remainder, Constants.HOUR_ROW,
				Lamp.RED.getStatus());

		hourBuilder.append("\r\n");
		return hourBuilder.toString();
	}

}
