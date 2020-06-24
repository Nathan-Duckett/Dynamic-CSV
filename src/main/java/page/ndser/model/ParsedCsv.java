package page.ndser.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import page.ndser.util.CsvSettings;

/**
 * Model of a Parsed CSV instance. This stores a settings for this parsedCsv and a list of rows
 * which store the contents retrieved from the CSV.
 * 
 * @author Nathan Duckett
 */
public class ParsedCsv {
	private final CsvSettings settings;
	private List<CsvRow> rows;
	
	/**
	 * Parse the rawCsv file into a ParsedCsv object.
	 * 
	 * @param rawCsv String representation of the CSV content.
	 */
	public ParsedCsv(String rawCsv) {
		String[] rows = rawCsv.split(CsvSettings.ROW_DELIM);
		this.settings = new CsvSettings(parseTitles(rows[0]));
		this.rows = new ArrayList<>();
		parseContents(rows);
	}
	
	/**
	 * Parse the titles from this row into a list of Strings.
	 * 
	 * @param row String format of the CSV row containing titles/headers.
	 * @return List of strings containing the headers in order to their index.
	 */
	private List<String> parseTitles(String row) {
		List<String> mapping = new ArrayList<>();
		
		String[] cols = row.split(CsvSettings.COL_DELIM);
		for (int i = 0; i < cols.length; i++) {
			mapping.add(cols[i]);
		}
		
		return mapping;
	}
	
	/**
	 * Parse all of the rows content into the list of CSV rows.
	 * 
	 * @param rows String array of all CSV rows split.
	 */
	private void parseContents(String[] rows) {
		for (int i = 1; i < rows.length; i++) {
			this.rows.add(new CsvRow(rows[i]));
		}
	}
	
	/**
	 * Get a string list of titles for printing.
	 * 
	 * @return List of String titles.
	 */
	public List<String> getTitles() {
		return settings.getTitles();
	}
	
	/**
	 * Get a list of all the CsvRow objects this CSV contains.
	 * 
	 * @return List of CsvRow objects contained within this CSV.
	 */
	public List<CsvRow> getRows() {
		return Collections.unmodifiableList(rows);
	}
	
	/**
	 * Get a list of all the contents from the CSV table which match the request attribute.
	 * 
	 * @param attribute String attribute which matches one stored in the settings of the CSV.
	 * @return List of strings containing each rows' value of this attribute.
	 */
	public List<String> getRows(String attribute) {
		int index = settings.getCsvIndexOf(attribute);
		return rows.stream().map(r -> (String) r.getAttribute(index)).collect(Collectors.toList());
	}

}
