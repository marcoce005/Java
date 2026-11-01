package it.polito.oop.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Utility assertion methods
 * 
 * specialized assert methods, make the test easier to read
 */
public class Assertions {

	/**
	 * Assert that a sub string is contained in the actual string
	 * 
	 * @param expectedSubStr the expected sub string
	 * @param actualStr      the actual string
	 */
	public static void assertContained(String expectedSubStr, String actualStr) {
		assertContained(expectedSubStr,actualStr, null);
	}
	
	
	/**
	 * Assert that a sub string is contained in the actual string
	 * 
	 * @param expectedSubStr the expected sub string
	 * @param actualStr      the actual string
	 */
	public static void assertContained(String expectedSubStr, String actualStr, String msg) {
		assertTrue((actualStr != null && actualStr.contains(expectedSubStr)),
				   (msg==null?"":msg+": ") + "expected sub string [" + expectedSubStr + "] is not contained in "+fmt(actualStr)+"");
	}
		
    public static void assertCountLines(String s, int expectedLines, String msg){
        int lines = -1;
		if(s==null) lines = 0;
        else lines = 1 + s.trim().replaceAll("[^\n]", "").length();
        assertEquals(expectedLines, lines, msg);
	}

	private static String fmt(String s) {
		if(s==null) return "'null'";
		else return "[" + s + "]";
	}
}
