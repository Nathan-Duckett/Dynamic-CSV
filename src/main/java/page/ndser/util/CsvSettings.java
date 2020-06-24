package page.ndser.util;

import java.util.Collections;
import java.util.List;

/**
 * Storage class to define the standard CSV settings within the CSV instances.
 * Defines the mappings of indexes to attributes and the delimiters for the CSV files.
 * 
 * @author Nathan Duckett
 */
public class CsvSettings {
	public static String ROW_DELIM = "\n";
	public static String COL_DELIM = ",";
	
	private List<String> csvMapping;
	
	/**
	 * Create a new Settings instance with the provided mapping between indexes and attributes.
	 * 
	 * @param mapping List of headings each representing their place in the CSV structure.
	 */
	public CsvSettings(List<String> mapping) {
		this.csvMapping = mapping;
	}
	
	/**
	 * Get the index of the provided property to retrieve from the CSV.
	 * 
	 * @param property Attribute to find the position of.
	 * @return Integer representing the position of the attribute in the CSV columns.
	 */
	public int getCsvIndexOf(String property) {
		assert csvMapping.contains(property);
		
		return csvMapping.indexOf(property);
	}
	
	/**
	 * Get a list of the titles/headings for this CSV settings instance.
	 * 
	 * @return List of strings representing the CSV column titles.
	 */
	public List<String> getTitles() {
		return Collections.unmodifiableList(csvMapping);
	}
}
