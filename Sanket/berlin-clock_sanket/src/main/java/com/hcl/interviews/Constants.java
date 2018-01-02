package com.hcl.interviews;

public interface Constants {

	String TIME_DELIMITER = ":";
	String TIME_FORMAT_NOT_CORRECT = "Specified Timeformat is incorrect, provide valid time in hh:mm:ss format.";
	int HOURS_FIRST_ROW_LAMP_COUNT = 4;
	int HOURS_SECOND_ROW_LAMP_COUNT = 4;
	int MINUTES_FIRST_ROW_LAMP_COUNT = 11;
	int MINUTES_SECOND_ROW_LAMP_COUNT = 4;
	char ON_LAMP_RED = 'R';
	char ON_LAMP_YELLOW = 'Y';	
	char OFF_LAMP = 'O';
	String NEW_LINE = System.getProperty("line.separator");
	String MINUTES_REPLACE_FROM = "YYY";
	String MINUTES_REPLACE_TO = "YYR";
}
