/**
 * 
 */
package com.hcl.interviews.utils;

/**
 * <h1>System level constant</h1>
 * <p>
 * Hold's a system level constants
 * </p>
 * 
 * @author Suresh
 * @version 1.0
 * @since 23-04-2017
 */
public class Constants {

	public static final String DELIMINATOR = ":";
	/*No. of lamps from the top within the first two row.Representing Hour*/
	public static final int HOUR_ROW = 4; 
	/*No.of lamps within the first row from the bottom.Representing 5 minutes*/
	public static final int MIN_FIRST_ROW = 11; 
	/*No. of lamp in the last row.Representing a minute*/
	public static final int MIN_SECOND_ROW = 4;
	
	//Constant value that represent the index with in an array or list
	public static final int HOUR_INDEX = 0;
	public static final int MIN_INDEX = 1;
	public static final int SEC_INDEX = 2;
	
	//Divisor constant
	public static final int DIVISOR_FIVE = 5;
}
