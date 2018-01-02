package com.hcl.interviews;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BerlinClockTest {

	private static final String NEW_LINE = System.getProperty("line.separator");

	@Test
	public void testMinValidBerlinClock() {
		new BerlinClock().convertTime("00:00:00");
	}

	@Test
	public void testMaxValidBerlinClock() {
		new BerlinClock().convertTime("23:59:59");
	}

	@Test
	public void testValidBerlinClock() {
		String actual = new BerlinClock().convertTime("12:30:30");
		String expected = "Y" + NEW_LINE + "RROO" + NEW_LINE + "RROO"
				+ NEW_LINE + "YYRYYROOOOO" + NEW_LINE + "OOOO";

		assertEquals(expected, actual);
	}

	@Test
	public void testTime1() throws Exception {
		// 16:36:35
		assertEquals("O" + NEW_LINE + "RRRO" + NEW_LINE + "ROOO" + NEW_LINE
				+ "YYRYYRYOOOO" + NEW_LINE + "YOOO",
				new BerlinClock().convertTime("16:36:35"));
	}

	@Test
	public void testTime2() throws Exception {

		// 16:36:36
		assertEquals("Y" + NEW_LINE + "RRRO" + NEW_LINE + "ROOO" + NEW_LINE
				+ "YYRYYRYOOOO" + NEW_LINE + "YOOO",
				new BerlinClock().convertTime("16:36:36"));
	}

	@Test
	public void testTime3() throws Exception {

		// 21:45:15
		assertEquals("O" + NEW_LINE + "RRRR" + NEW_LINE + "ROOO" + NEW_LINE
				+ "YYRYYRYYROO" + NEW_LINE + "OOOO",
				new BerlinClock().convertTime("21:45:15"));
	}

	@Test
	public void testTime4() throws Exception {

		// 24:00:00
		assertEquals("Y" + NEW_LINE + "RRRR" + NEW_LINE + "RRRR" + NEW_LINE
				+ "OOOOOOOOOOO" + NEW_LINE + "OOOO",
				new BerlinClock().convertTime("24:00:00"));
	}

	public void testSeconds() throws Exception {
		// even seconds
		assertEquals("Y" + NEW_LINE + "OOOO" + NEW_LINE + "OOOO" + NEW_LINE
				+ "OOOOOOOOOOO" + NEW_LINE + "OOOO",
				new BerlinClock().convertTime("00:00:00"));

	}

	@Test
	public void testMinutes() throws Exception {
		// zero minutes
		assertEquals("Y" + NEW_LINE + "OOOO" + NEW_LINE + "OOOO" + NEW_LINE
				+ "OOOOOOOOOOO" + NEW_LINE + "OOOO",
				new BerlinClock().convertTime("00:00:00"));
	}

	@Test
	public void testHours() throws Exception {
		// modnight
		assertEquals("Y" + NEW_LINE + "OOOO" + NEW_LINE + "OOOO" + NEW_LINE
				+ "OOOOOOOOOOO" + NEW_LINE + "OOOO",
				new BerlinClock().convertTime("00:00:00"));
	}

	@Test
	public void testUpperInvalidHours() {
		new BerlinClock().convertTime("24:00:00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUpperInvalidMinutes() {
		new BerlinClock().convertTime("00:60:00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUpperInvalidSeconds() {
		new BerlinClock().convertTime("00:00:60");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLowerInvalidHours() {
		new BerlinClock().convertTime("-01:00:00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLowerInvalidMinutes() {
		new BerlinClock().convertTime("00:-01:00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLowerInvalidSeconds() {
		new BerlinClock().convertTime("00:00:-01");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidString() {
		new BerlinClock().convertTime("00:00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullString() {
		new BerlinClock().convertTime(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyString() {
		new BerlinClock().convertTime("");
	}

}