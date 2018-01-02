package com.hcl.interviews.utils;

public enum BerlinClockProperties {
	 
	 TIME_SEPERATOR("time_seperator"),
	 NEW_LINE_SEPERATOR("line.separator"),
	 BERLIN_CLOCK_EXCEPTION("berlin_clock_exception"),
	 TIME_FORMAT_ERROR_MESSAGE("time_format_error_message"),
	 TIME_CONVERT_ERROR_MESSAGE("time_conversion_error_message");
	 
	 
	 
	 String propertyName;
	 
	 public String getPropertyName() {
		return propertyName;
	}

	private BerlinClockProperties(String propertyName){
		 this.propertyName = propertyName;
	 }
}
