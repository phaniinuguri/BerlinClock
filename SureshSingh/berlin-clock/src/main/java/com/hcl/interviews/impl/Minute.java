/**
 * 
 */
package com.hcl.interviews.impl;

import com.hcl.interviews.TimeConverter;
import com.hcl.interviews.utils.BerlinClockUtil;
import com.hcl.interviews.utils.Constants;
import com.hcl.interviews.utils.Lamp;

/**
 * Responsible for minute representation in the Berlin clock
 * 
 * @author Suresh
 * @version 1.0
 * @since 23-04-2017
 *
 */
public class Minute implements TimeConverter {

	@Override
	public String convertTime(String aTime) {

		int minUnit = BerlinClockUtil.convertStringToInt(aTime);
		StringBuilder timeBuilder = new StringBuilder();

		// Finding the quotient and the remainder by dividing the minUnit by 5
		int quotient = minUnit / Constants.DIVISOR_FIVE;
		int remainder = minUnit % Constants.DIVISOR_FIVE;

		// Find the status(on/off) of 5 minute unit lamp along with the color
		// within the row of the lamp
		BerlinClockUtil.getLamps(timeBuilder, quotient,
				Constants.MIN_FIRST_ROW, Lamp.RED.getStatus(),
				Lamp.YELLOW.getStatus());
		timeBuilder.append("\r\n"); //Appending the carriage return and new line
		
		// Find the status(on/off) of 1 minute unit lamp within the row of the
		// lamp
		BerlinClockUtil.getLamps(timeBuilder, remainder,
				Constants.MIN_SECOND_ROW, Lamp.YELLOW.getStatus());
		
		return timeBuilder.toString();
	}

}
