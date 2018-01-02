package com.hcl.interviews;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import com.hcl.interviews.utils.BerlinClockProperties;
import com.hcl.interviews.utils.BerlinClockPropertyHandler;
import com.hcl.interviews.utils.BerlinClockUtils;
import com.hcl.interviews.utils.TimeValidator;

public class BerlinClock implements TimeConverter {
	
	public BerlinClock() {

	}
	private static Logger logger = Logger.getLogger(BerlinClock.class.getName());

	/**
	 * @throws BerlinClockException 
	 * converts the time into the Berlin Clock format. 
	 * This method returns an string with combination of Strings representing the lamp's state O (off), Y (yellow) and R (red).
	 * @param aTime The time to transform in the format HH:mm:ss
	 * @return The time in the Berlin Clock format.
	 * @throws  
	 */
	public String convertTime(String aTime) throws BerlinClockException {
		String lamps = "";
		BerlinClockPropertyHandler propertyHandler = BerlinClockPropertyHandler.getInstance();
		try {
			// retrieve hours , minutes , seconds from aTime String.
			String timeSeparator = propertyHandler.getValue(BerlinClockProperties.TIME_SEPERATOR.getPropertyName());
			int[] timeComponents = Stream.of(aTime.split(timeSeparator, 3)).mapToInt(Integer::parseInt).toArray();
			int hours = timeComponents[0];
			int minutes = timeComponents[1];
			int seconds = timeComponents[2];
			// verify the format and validate the time string.
			lamps = BerlinClockUtils.getLamps(hours, minutes, seconds);
			TimeValidator.verifyFormat(aTime, hours, minutes, seconds);
			return lamps;
		} catch (Exception e) {
			logger.log(Level.SEVERE, propertyHandler.getValue(BerlinClockProperties.TIME_CONVERT_ERROR_MESSAGE.getPropertyName()), e);
			throw new BerlinClockException(propertyHandler.getValue(BerlinClockProperties.BERLIN_CLOCK_EXCEPTION.getPropertyName()));
		}
	}
		
	
}