package test.page.ndser.ParsingTests;

import java.util.List;
import org.junit.jupiter.api.Test;

import page.ndser.model.ParsedCsv;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic tests to check invalid CSV behaviour.
 * 
 * @author Nathan Duckett
 *
 */
public class InvalidParseCsvTests {
	
	private final String basicCsv = "NAME,ADDRESS\nNathan,123 Fake Street,8675309";
	
	/**
	 * Test loading in basicCsv and that all data values match the expected number.
	 */
	@Test
	public void testCsvLoad() {
		ParsedCsv parsedCsv = new ParsedCsv(basicCsv);
		
		// Expect two titles NAME, ADDRESS
		assertEquals(2, parsedCsv.getTitles().size());
		
		// Expect one row of data
		assertEquals(1, parsedCsv.getRows().size());
	}
	
	/**
	 * Test loading in basicCsv and that the phone number is present but can't be mapped.
	 */
	@Test
	public void testCsvIgnoredPhone() {
		ParsedCsv parsedCsv = new ParsedCsv(basicCsv);
		
		// Assert phone number is there
		assertEquals(3, parsedCsv.getRows().get(0).size());
		
		try {
			parsedCsv.getRows("PHONE");
			fail("Did not throw error");
		} catch (AssertionError e) {
			assertTrue(true);
		}
	}
}
