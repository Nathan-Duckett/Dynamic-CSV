package page.ndser;

import java.util.List;

import page.ndser.model.CsvRow;
import page.ndser.model.ParsedCsv;

/**
 * CsvPrinter static class to provide functionality to print out prettified CSV
 * to the console.
 * 
 * @author Nathan Duckett
 */
public class CsvPrinter {
	
	/**
	 * Print out the ParsedCsv to system.out in pretty format.
	 * 
	 * @param csv ParsedCSV instance to print.
	 */
	public static void out(ParsedCsv csv) {
		List<String> titles = csv.getTitles();
		List<CsvRow> rows = csv.getRows();
		
		titles.forEach(t -> System.out.print("| " + t + " "));
		// Add new line
		System.out.println("|");
		rows.forEach(r -> {
			r.stream().forEach(v -> System.out.print("| " + v + " "));
			// Add new line
			System.out.println("|");
		});
	}
	
	/**
	 * Print out a specific Attribute from the CSV table into system.out.
	 * 
	 * @param csv ParsedCSV instance to print.
	 * @param attribute Attribute to retrieve from the CSV instance.
	 */
	public static void attrOut(ParsedCsv csv, String attribute) {
		List<String> rows = csv.getRows(attribute);
		System.out.println("| " + attribute + " |");
		
		rows.forEach(r -> System.out.println("| " + r + " |"));
	}
	
	
	/**
	 * Basic main method to test the output of code.
	 * 
	 * @param args Program arguments.
	 */
	public static void main(String[] args) {
		String csv = "NAME,ADDRESS\nNathan,123 Fake Street";
		ParsedCsv parsedCsv = new ParsedCsv(csv);
		out(parsedCsv);
		
		attrOut(parsedCsv, "NAME");
		attrOut(parsedCsv, "ADDRESS");
	}

}
