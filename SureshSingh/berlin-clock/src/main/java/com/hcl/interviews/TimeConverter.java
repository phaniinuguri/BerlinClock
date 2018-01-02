package com.hcl.interviews;

/**
 * 
 * @author Suresh
 * @version 1.0
 * @since 23-04-2017
 *
 */
public interface TimeConverter{
	/**
	 * Convert time unit like HH/MM/SS into Berlin clock format
	 * @param aTime
	 * @return String
	 */
    String convertTime(String aTime);

}
