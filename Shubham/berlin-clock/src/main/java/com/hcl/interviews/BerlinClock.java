package com.hcl.interviews;

import java.util.Arrays;
import java.util.stream.Stream;

public class BerlinClock implements TimeConverter {
	private static final String NEW_LINE = System.getProperty("line.separator");
	
	public BerlinClock() {

	}

	/**
	 * converts the time into the Berlin Clock format. 
	 * This method returns an string with combination of Strings representing the lamp's state O (off), Y (yellow) and R (red).
	 * @param aTime The time to transform in the format HH:mm:ss
	 * @return The time in the Berlin Clock format.
	 * @throws  
	 */
	public String convertTime(String aTime) {
		BerlinClockPropertyHandler propertyHandler =BerlinClockPropertyHandler.getInstance();
		try {
			// retrieve hours , minutes , seconds from aTime String.
			String timeSaparator =propertyHandler.getValue("time_seperator");
			int[] timeComponents=Stream.of(aTime.split(timeSaparator, 3)).mapToInt(Integer::parseInt).toArray();
			int hours = timeComponents[0];
			int minutes = timeComponents[1];
			int seconds = timeComponents[2];
			// verify the format and validate the time string.
			verifyFormat(aTime, hours, minutes, seconds);
			return getLamps(hours, minutes, seconds);
		} catch (Exception e) {
			throw new IllegalArgumentException(propertyHandler.getValue("berlin_clock_exception"));
		}
	}
	
	/**
	 * @param hours The time to transform in the format HH
	 * @param minutes The time to transform in the format mm
	 * @param seconds The time to transform in the format ss
	 * @return The time in the Berlin Clock format.
	 */
	private String getLamps(int hours, int minutes, int seconds) {
		String secLamp = getSecondsLamp(seconds);
		String firstRowOfHours = populateLitLamps(4, hours / 5, BerlinClockLampsEnum.RED_LAMP.getLamp());
		String secondRowOfHours = populateLitLamps(4, hours % 5, BerlinClockLampsEnum.RED_LAMP.getLamp());
		String firstRowOfMinutes = populateLitLamps(11, minutes / 5, BerlinClockLampsEnum.YELLOW_LAMP.getLamp());
		String secondRowOfMinute = populateLitLamps(4,  minutes % 5, BerlinClockLampsEnum.YELLOW_LAMP.getLamp());
		return String.join(NEW_LINE, Arrays.asList(secLamp, firstRowOfHours,
				secondRowOfHours, firstRowOfMinutes, secondRowOfMinute));

	}
	
	/**
	 * verify format of input time.
	 * This method to validate and parse the input time.
	 * @param aTime The time to transform in the format HH:mm:ss
	 * @return void
	 */
	private void verifyFormat(String time, int hours, int minutes, int seconds) {
		BerlinClockPropertyHandler propertyHandler =BerlinClockPropertyHandler.getInstance();
		if (time == null || hours < 0 || (minutes < 0 || minutes > 59)
				|| (seconds < 0 || seconds > 59)) {
			throw new IllegalArgumentException(propertyHandler.getValue("berlin_clock_exception"));
		}

	}

	/*
	 * if second timing is even then light will be ON with yellow color
	 * otherwise off.
	 * @param seconds 
	 * @return A string representing a second row of the clock.
	 */
	private String getSecondsLamp(int seconds) {
		if (seconds % 2 == 0) {
			return BerlinClockLampsEnum.YELLOW_LAMP.getLamp();
		}
		return BerlinClockLampsEnum.OFF_LAMP.getLamp();
	}
	
	/**
	 * @param totalCount initialize the string with "Off" lights
	 * @param litLights number of lit lights and need to replace off light by color variable.
	 * @param color color of lamps.
	 * @return String of specific row lamps of Berlin clock.
	 */
	private String populateLitLamps(int totalCount, int litLights, String color) {
		String s = new String(new char[totalCount]).replace('\0',BerlinClockLampsEnum.OFF_LAMP.getLamp().charAt(0));
		boolean firstRowOfMinutesInd = (totalCount == 11);
		char[] chars = s.toCharArray();
		for (int i = 0; i < litLights; i++) {
			if (firstRowOfMinutesInd && ((i + 1) % 3 == 0)) {
				chars[i] = BerlinClockLampsEnum.RED_LAMP.getLamp().charAt(0);
			} else {
				chars[i] = color.charAt(0);
			}

		}
		return String.valueOf(chars);

	}
}