package com.hcl.interviews.utils;

public enum BerlinClockLampsEnum {

	RED_LAMP("R"), YELLOW_LAMP("Y"),  OFF_LAMP("O");

	String lamp;

	public String getLamp() {
		return lamp;
	}

	private BerlinClockLampsEnum(String lamp) {
		this.lamp = lamp;
	}

}
