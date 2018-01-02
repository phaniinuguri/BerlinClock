package com.hcl.interviews.utils;



import java.util.logging.Level;
import java.util.logging.Logger;

import com.hcl.interviews.BerlinClockException;


public class TimeValidator {
	
	private static Logger logger = Logger.getLogger(TimeValidator.class.getName());
	/*
	 * verify format of input time.
	 * This method to validate and parse the input time.
	 * @param aTime The time to transform in the format HH:mm:ss
	 * @return void
	 */
	public static void verifyFormat(String time, int hours, int minutes, int seconds) throws BerlinClockException {
		BerlinClockPropertyHandler propertyHandler = BerlinClockPropertyHandler.getInstance();
		if (time == null || (hours < 0 || hours > 24)  || (minutes < 0 || minutes > 59)
				|| (seconds < 0 || seconds > 59)) {
			logger.log(Level.SEVERE, propertyHandler.getValue(BerlinClockProperties.TIME_FORMAT_ERROR_MESSAGE.getPropertyName()));
			throw new BerlinClockException(propertyHandler.getValue(BerlinClockProperties.BERLIN_CLOCK_EXCEPTION.getPropertyName()));
		}

	}
	
}
