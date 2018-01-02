/**
 * 
 */
package com.hcl.interviews.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1>Utility/Support class</h1>
 * <p>
 * Consist of common functionality to be use across the system
 * </p>
 * 
 * @author Suresh
 * @since 23-04-2017
 * @version 1.0
 */
public class BerlinClockUtil {

	private static final Logger LOG = LoggerFactory
			.getLogger(BerlinClockUtil.class);
	
	/* Regular expression allowing HH:MM:SS format */
	private static final String TIME_FORMAT_REGEX = "\\d+:\\d+:\\d+";

	/**
	 * Checks the validity of the input parameter in terms of HH:MM:SS format
	 * with ":" as deliminator .
	 * 
	 * @param input
	 * @return boolean Return true if the parameter is in the HH:MM:SS format
	 *         only otherwise return false
	 */
	public static boolean isValidTimeFormat(String time) {
		LOG.debug("Time pass to isValidDateFormat ==> " + time);
		Pattern pattern = Pattern.compile(TIME_FORMAT_REGEX);
		Matcher matcher = pattern.matcher(time);
		return matcher.matches();
	}

	/**
	 * Convert the String value to integer along with the check of emptiness as
	 * well as null
	 * 
	 * @param arg
	 *            as a string value
	 * @return int Return converted value from string in number format
	 */
	public static int convertStringToInt(String arg) {
		try {
			if (arg != null && !arg.trim().isEmpty()) {
				return Integer.parseInt(arg);
			}

		} catch (Exception e) {
			LOG.error("Fail to convert the given String into number ", e);
		}
		return 0;
	}

	/**
	 * Decide the status of the lamp i.e ON/OFF along with the color of the lamp
	 * to be glow.
	 * 
	 * @param timeBuilder
	 *            Return the result building the Berlin clock minute
	 *            representation.
	 * @param result
	 *            This value help us to know the lamp status i.e ON/OFF
	 * @param column
	 *            This value represent the column in a row of Berlin Clock
	 * @param uniqueColor
	 *            Color of the lamp when it is on;different with other lamp in a
	 *            row.
	 * @param normalColor
	 *            Color of the lamp when it is on
	 */
	public static void getLamps(StringBuilder timeBuilder, int result,
			int column, String uniqueColor, String normalColor) {

		for (int i = 1; i <= column; i++) {
			if (result >= i) {
				switch (i) {
				case 3:
				case 6:
				case 9:
					timeBuilder.append(uniqueColor);
					break;

				default:
					timeBuilder.append(normalColor);
					break;
				}

			} else {
				timeBuilder.append(Lamp.OFF.getStatus());
			}
			// timeBuilder.append("\t");
		}

		/*timeBuilder.append("\r\n");*/

	}

	/**
	 * Decide the status of the lamp i.e ON/OFF along with the color of the lamp
	 * to be glow.
	 * 
	 * @param timeBuilder
	 *            Return the result building the Berlin clock minute
	 *            representation.
	 * @param result
	 *            This value help us to know the lamp status i.e ON/OFF
	 * @param column
	 *            This value represent the column in a row of Berlin Clock
	 * @param normalColor
	 *            Color of the lamp when it is on
	 */
	public static void getLamps(StringBuilder timeBuilder, int result,
			int column, String normalColor) {

		for (int i = 1; i <= column; i++) {
			if (result >= i) {
				timeBuilder.append(normalColor);
			} else {
				timeBuilder.append(Lamp.OFF.getStatus());
			}
			// timeBuilder.append("\t");
		}

		//timeBuilder.append("\r\n");

	}
}
