/**
 * 
 */
package com.hcl.interviews.berlin_clock.factory;

/**
 * Helps to decide the type of instance needed from the factory using factory
 * design pattern
 * 
 * @author Suresh
 * @version 1.0
 * @since 23-04-2017
 */
public enum FactoryConstants {
	HOUR("Hour"), MINUTE("Minute"), SECOND("Second");

	private final String TIME_UNIT;

	private FactoryConstants(String clock) {
		this.TIME_UNIT = clock;
	}

	public String getTIME_UNIT() {
		return TIME_UNIT;
	}

}
