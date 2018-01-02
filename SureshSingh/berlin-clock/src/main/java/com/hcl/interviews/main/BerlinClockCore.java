/**
 * 
 */
package com.hcl.interviews.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcl.interviews.TimeConverter;
import com.hcl.interviews.berlin_clock.factory.FactoryConstants;
import com.hcl.interviews.berlin_clock.factory.TimeConvertorFactory;
import com.hcl.interviews.utils.BerlinClockUtil;
import com.hcl.interviews.utils.Constants;
import com.hcl.interviews.utils.MessageConstant;

/**
 * Class contain the core logic to interpret the time in the Berlin Clock
 * representation
 * 
 * @author Suresh
 * @version 1.0
 * @since 23-04-2017
 *
 */
public class BerlinClockCore {
	private static final Logger LOG = LoggerFactory
			.getLogger(BerlinClockCore.class);

	/* Singleton Design Pattern using Lazy initialization */
	private static BerlinClockCore coreInstance;

	private BerlinClockCore() {

	}

	/**
	 * The method return the single instance of a class BerlinClockCore
	 * @return an instance of BerlinClockCore
	 */
	public static BerlinClockCore getInstance() {
		if (coreInstance == null) {
			return new BerlinClockCore();
		}
		return coreInstance;
	}

	/**
	 * This method is used to show the time in Berlin clock 
	 * format or representation.
	 * @param time This is the time enter by the user
	 * @return String This return Berlin Clock representation of time so entered.
	 */
	public String showBerlinClockTime(String time) {
		StringBuilder berlinClockBuilder = null;
		String result = null;
		try {
			if (BerlinClockUtil.isValidTimeFormat(time)) {
				
				berlinClockBuilder = new StringBuilder();
				String[] timeUnits = time.split(Constants.DELIMINATOR);
				/*
				 * As we have already put a check of the time format.So,no need to add
				 * condition for index out of bound exception
				 */
				LOG.info("timeUnits[0]" + timeUnits[0] + " timeUnits[1]: "
						+ timeUnits[1] + " timeUnits[2] : " + timeUnits[2]);

				/*
				 * Start:23-04-2017|Retrieving the second object and decide the
				 * Yellow lamp status
				 */
				TimeConverter converter = TimeConvertorFactory
						.getConverter(FactoryConstants.SECOND.getTIME_UNIT());

				berlinClockBuilder.append(converter.convertTime(timeUnits[Constants.SEC_INDEX])) // Passing the
																				// seconds
						.append("\r\n");
				/*
				 * End:23-04-2017|Retrieving the second object and decide the
				 * Yellow lamp status
				 */

				/*
				 * Start:23-04-2017|Retrieving the Hour object and decide the
				 * Red lamp status
				 */
				converter = TimeConvertorFactory
						.getConverter(FactoryConstants.HOUR.getTIME_UNIT());

				berlinClockBuilder.append(converter.convertTime(timeUnits[Constants.HOUR_INDEX]));// Passing the hour
																				// value
				/*
				 * End:23-04-2017|Retrieving the Hour object and decide the Red
				 * lamp status
				 */

				/*
				 * Start:23-04-2017|Retrieving the Minute object and decide the
				 * lamp status
				 */
				converter = TimeConvertorFactory
						.getConverter(FactoryConstants.MINUTE.getTIME_UNIT());

				berlinClockBuilder.append(converter.convertTime(timeUnits[Constants.MIN_INDEX]));//Passing the minute value
				
				/*
				 * End:23-04-2017|Retrieving the Minute object and decide the
				 * lamp status
				 */
				result = berlinClockBuilder.toString();
				// LOG.info("BerlinClock ==> " + berlinClockBuilder.toString());
			}else{
				result = MessageConstant.DESC_01;
			}

		} catch (Exception e) {
			result = MessageConstant.DESC_02;
			e.printStackTrace();
		}
		return result;
	}
}
