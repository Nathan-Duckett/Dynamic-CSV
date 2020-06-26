package test.page.ndser.ParsingTests;

import java.util.List;
import org.junit.jupiter.api.Test;

import page.ndser.model.ParsedCsv;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic tests to verify CSV parsing works as expected.
 * 
 * @author Nathan Duckett
 */
public class ParseCsvTests {
	
	private final String basicCsv = "NAME,ADDRESS\nNathan,123 Fake Street";
	
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
	 * Test loading in basicCsv and that getting the attribute will match the expectation.
	 */
	@Test
	public void testCsvGetNameAttribute() {
		ParsedCsv parsedCsv = new ParsedCsv(basicCsv);

		List<String> attrList = parsedCsv.getRows("NAME");
		
		// Expect one data entry when getting attribute
		assertEquals(1, attrList.size());
		assertEquals("Nathan", attrList.get(0));
	}
	
	/**
	 * Test loading in basicCsv and that getting the attribute will match the expectation.
	 */
	@Test
	public void testCsvGetAddressAttribute() {
		ParsedCsv parsedCsv = new ParsedCsv(basicCsv);

		List<String> attrList = parsedCsv.getRows("ADDRESS");
		
		// Expect one data entry when getting attribute
		assertEquals(1, attrList.size());
		assertEquals("123 Fake Street", attrList.get(0));
	}

}
