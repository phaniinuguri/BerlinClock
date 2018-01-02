/**
 * 
 */
package com.hcl.interviews.main;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcl.interviews.utils.BerlinClockUtil;

/**
 * @author Suresh
 * @version 1.0
 * @since 23-04-2017
 * 
 */
public class BerlinClockMain {

	private static final Logger LOG = LoggerFactory
			.getLogger(BerlinClockUtil.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner readInput = new Scanner(System.in);
		String output = null;
		try {
			System.out
					.println("Want to know the time in Berlin Clock format (Yes/No)? ");
			String input = (readInput.next()).trim().toLowerCase();
			//System.out.println("Input : " + input);
			
			switch (input) {
			case "yes":
			case "y":
				System.out
						.println("Enter the time in 24 hour format(HH:MM:SS) : ");
				input = (readInput.next().trim());
				BerlinClockCore coreInstance = BerlinClockCore.getInstance();
				output = coreInstance.showBerlinClockTime(input);
				break;

			case "no":
			case "n":
				System.out
						.println("As you are not interested,we are exiting the code!!");
				break;

			default:
				System.out.println("Invalid answer!!!");
				System.out.println("Exiting....");

				break;
			}

		} catch (Exception e) {
			LOG.error("Exiting the main program due to : ", e);
		} finally {
			if (readInput != null) {
				readInput.close();
			}
		}
		System.out.println(output);
	}

}
