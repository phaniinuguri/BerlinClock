	/**
 * 
 */
package com.hcl.interviews.utils;

/**
 * Define the color of the lamp in the Berlin Clock
 * @author Suresh
 * @version 1.0
 * @since 23-04-2017
 *
 */
public enum Lamp {
	RED("R"),
	YELLOW("Y"),
	OFF("O");
	
	private final String status;
	
	private Lamp(String status){
		this.status = status;
	}
	
	public String getStatus(){
		return this.status;
	}

}
