package page.ndser.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import page.ndser.util.CsvSettings;

/**
 * Model to represent a row in the CSV document.
 * 
 * @author Nathan Duckett
 */
public class CsvRow {
	private final List<Object> values;

	/**
	 * Create a new CSV row from the provided data.
	 * 
	 * @param rowContents Raw CSV data to be parsed into a row.
	 */
	public CsvRow(String rowContents) {
		this.values = parse(rowContents);
	}
	
	/**
	 * Helper function to parse the raw CSV and convert it into a list of objects.
	 * 
	 * @param rowContents Raw CSV data to be parsed into a row.
	 * @return List of Objects represented within each column of the CSV row.
	 */
	private List<Object> parse(String rowContents) {
		String[] contents = rowContents.split(CsvSettings.COL_DELIM);
		
		return Stream.of(contents).collect(Collectors.toList());
	}
	
	/**
	 * Get a specific attribute from this CSV row.
	 * 
	 * @param attributeIndex Index of the attribute to receive (between 0 and row.length)
	 * @return Object retrieved from the list of values in this row.
	 */
	public Object getAttribute(int attributeIndex) {
		return values.get(attributeIndex);
	}
	
	/**
	 * Get a stream of the values in this row.
	 * 
	 * @return Stream of objects from the column values.
	 */
	public Stream<Object> stream() {
		return values.stream();
	}
}
