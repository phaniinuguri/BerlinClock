/**
 * 
 */
package com.hcl.interviews.impl;

import com.hcl.interviews.TimeConverter;
import com.hcl.interviews.utils.BerlinClockUtil;
import com.hcl.interviews.utils.Lamp;

/**
 * Second class convert the second unit of time
 * into the Berlin clock format for second.
 * 
 * @author Suresh
 * @version 1.0
 * @since 23-04-2017
 *
 */
public class Second implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		
		//Find the status of the Yellow lamp which blink on every 2 second
		int secondUnit = BerlinClockUtil.convertStringToInt(aTime);
		if ((secondUnit % 2)==0) {
			return Lamp.YELLOW.getStatus();
		}
		
		return Lamp.OFF.getStatus();
	}

}
