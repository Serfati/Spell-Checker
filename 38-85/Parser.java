import java.io.*;
/**
 * @author Avihai Serfati		204520803
 * 				   Moshe Bitan		204073255
 */
public class Parser {
	/**
	 * 
	 * @param filePath
	 * @param table
	 * @return
	 */
	public static boolean parseWordsToTable(String filePath, StringHashTable table)   {
		if(filePath == null || table == null )
			return false;
		try{
		File file = new File(filePath); 
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null)
			table.insert(st);
		br.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
}
