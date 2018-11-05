package structure;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ParseHeadersCSV  implements ParseHeaders{

	private String headers[];
	
	@Override
	public String[] parseheader(String path) {
		Reader reader;
		try {
			reader = Files.newBufferedReader(Paths.get(path));
			 CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL.withFirstRecordAsHeader());
			 headers=new String[csvParser.getHeaderMap().keySet().size()];
			csvParser.getHeaderMap().keySet().toArray(headers);
			csvParser.getHeaderMap().keySet().toArray(headers);
			headers=csvParser.getHeaderMap().keySet().toArray(headers)[0].split(";");
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return headers;
	}

}
