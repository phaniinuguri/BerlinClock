package com.hcl.interviews;

import static com.hcl.interviews.Constants.HOURS_FIRST_ROW_LAMP_COUNT;
import static com.hcl.interviews.Constants.HOURS_SECOND_ROW_LAMP_COUNT;
import static com.hcl.interviews.Constants.MINUTES_FIRST_ROW_LAMP_COUNT;
import static com.hcl.interviews.Constants.MINUTES_REPLACE_FROM;
import static com.hcl.interviews.Constants.MINUTES_REPLACE_TO;
import static com.hcl.interviews.Constants.MINUTES_SECOND_ROW_LAMP_COUNT;
import static com.hcl.interviews.Constants.NEW_LINE;
import static com.hcl.interviews.Constants.OFF_LAMP;
import static com.hcl.interviews.Constants.ON_LAMP_RED;
import static com.hcl.interviews.Constants.ON_LAMP_YELLOW;
import static com.hcl.interviews.Constants.TIME_DELIMITER;
import static com.hcl.interviews.Constants.TIME_FORMAT_NOT_CORRECT;

import java.util.stream.Stream;

public class BerlinClock implements TimeConverter {

	public String convertTime(String time) throws IllegalArgumentException{

		//if input is null throw exception
		if(time == null){
			throw new IllegalArgumentException(TIME_FORMAT_NOT_CORRECT);
		}
		String tokens [] = time.split(TIME_DELIMITER);
		try{
			//get stream of tokens and convert each entry from String to int and get results as int array
			int timeTokens [] = Stream.of(tokens).mapToInt(s -> Integer.parseInt(s)).toArray();

			// valid hours between 0 and 24
			if(!checkBoundries(timeTokens[0], 0, 24)){
				throw new IllegalArgumentException(TIME_FORMAT_NOT_CORRECT);
			}
			
			// valid minutes between 0 and 59
			if(!checkBoundries(timeTokens[1], 0, 59)){
				throw new IllegalArgumentException(TIME_FORMAT_NOT_CORRECT);
			}
			
			// valid seconds between 0 and 59
			if(!checkBoundries(timeTokens[2], 0, 59)){
				throw new IllegalArgumentException(TIME_FORMAT_NOT_CORRECT);
			}
			
			// if hours = 24 then both minutes and seconds should be 0
			if(timeTokens[0] == 24 && timeTokens[1] != 0 && timeTokens[2] != 0){
				throw new IllegalArgumentException(TIME_FORMAT_NOT_CORRECT);
			}
				
			return(getSeconds(timeTokens[2])
					+ NEW_LINE
					+ getFirstRowHours(timeTokens[0])
					+ NEW_LINE
					+ getSecondRowHours(timeTokens[0])
					+ NEW_LINE
					+ getFirstRowMinutes(timeTokens[1])
					+ NEW_LINE
					+ getSecondRowMinutes(timeTokens[1]));
		
		} catch(Exception e){
			//if provided string does not contain 2 ":" or 
			//while converting tokens to int if any error due to number format
			throw new IllegalArgumentException(TIME_FORMAT_NOT_CORRECT);
		}
	}

	//On the top of the clock there is a yellow lamp that blinks on/off every two seconds
	protected char getSeconds(int ss){
		return ss % 2 == 0 ? ON_LAMP_YELLOW : OFF_LAMP;
	}

	//The top two rows of lamps are red. These indicate the hours of a day. 
	//In the top row there are 4 red lamps. Every lamp represents 5 hours. 
	protected String getFirstRowHours(int hh){
		return getOnLamps(hh/5, HOURS_FIRST_ROW_LAMP_COUNT, ON_LAMP_RED);
	}

	//In the lower row of red lamps every lamp represents 1 hour
	protected String getSecondRowHours(int hh){
		return getOnLamps(hh%5, HOURS_SECOND_ROW_LAMP_COUNT, ON_LAMP_RED);
	}

	//The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps. 
	//In the first row every lamp represents 5 minutes
	protected String getFirstRowMinutes(int mm){
		// the 3rd, 6th and 9th lamp are red and indicate the first
		// quarter, half and last quarter of an hour
		return getOnLamps(mm/5, MINUTES_FIRST_ROW_LAMP_COUNT, ON_LAMP_YELLOW)
				.replaceAll(MINUTES_REPLACE_FROM, MINUTES_REPLACE_TO);
	}

	
	//In the lower row of yellow lamps every lamp represents 1 minute
	protected String getSecondRowMinutes(int mm){
		return getOnLamps(mm%5, MINUTES_SECOND_ROW_LAMP_COUNT, ON_LAMP_YELLOW);
	}


	private String getOnLamps(int onLampCount, int totalLampCount, char lightColour){
		
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < onLampCount; i++){
			builder.append(lightColour);
		}
		for(int i = onLampCount; i < totalLampCount; i++){
			builder.append(OFF_LAMP);
		}
		
		return builder.toString();
	}
	
	private boolean checkBoundries(int value, int minValue, int maxValue){
		
		if(value < minValue || value > maxValue){
			return false;
		}
		
		return true;
	}
	
}