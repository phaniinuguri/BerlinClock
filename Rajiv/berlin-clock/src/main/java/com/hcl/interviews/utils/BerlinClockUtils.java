package com.hcl.interviews.utils;

import java.util.Arrays;

public class BerlinClockUtils {
	
	private static final String NEW_LINE = System.getProperty(BerlinClockProperties.NEW_LINE_SEPERATOR.getPropertyName());
	
	
	/**
	 * @param totalCount initialize the string with "Off" lights
	 * @param litLights number of lit lights and need to replace off light by color variable.
	 * @param color color of lamps.
	 * @return String of specific row lamps of Berlin clock.
	 */
	public static String populateLitLamps(int totalCount, int litLights, String color) {
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
	
	/**
	 * @param hours The time to transform in the format HH
	 * @param minutes The time to transform in the format mm
	 * @param seconds The time to transform in the format ss
	 * @return The time in the Berlin Clock format.
	 */
	public static String getLamps(int hours, int minutes, int seconds) {
		String secondsLamp = getSecondsLamp(seconds);
		int timeSlice = 5;
		String firstRowOfHours =  BerlinClockUtils.populateLitLamps(4, hours / timeSlice, BerlinClockLampsEnum.RED_LAMP.getLamp());
		String secondRowOfHours = BerlinClockUtils.populateLitLamps(4, hours % timeSlice, BerlinClockLampsEnum.RED_LAMP.getLamp());
		String firstRowOfMinutes = BerlinClockUtils.populateLitLamps(11, minutes / timeSlice, BerlinClockLampsEnum.YELLOW_LAMP.getLamp());
		String secondRowOfMinutes = BerlinClockUtils.populateLitLamps(4,  minutes % timeSlice, BerlinClockLampsEnum.YELLOW_LAMP.getLamp());
		return String.join(NEW_LINE, Arrays.asList(secondsLamp, firstRowOfHours,
				secondRowOfHours, firstRowOfMinutes, secondRowOfMinutes));

	}
	
	
	/*
	 * If second timing is even then light will be ON with yellow color
	 * otherwise off.
	 * @param seconds 
	 * @return A string representing a second row of the clock.
	 */
	private static String getSecondsLamp(int seconds) {
		if (seconds % 2 == 0) {
			return BerlinClockLampsEnum.YELLOW_LAMP.getLamp();
		}
		return BerlinClockLampsEnum.OFF_LAMP.getLamp();
	}
	
}
