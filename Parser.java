import java.io.*;
/** This function read from file all the lines and insert the hash table the value of the string 
 * ( Key calculate by function and then enter to index of the table)
 * @author Avihai Serfati		204520803
 * 				   Moshe Bitan		204073522
 */
public class Parser {
	/**
	 *  This take dictionary from the filePath directory and insert to  hashtable 
	 * @param filePath - the path of the dictionary
	 * @param table - a string hash table 
	 * @return true if success to read all words from file
	 */
	public static boolean parseWordsToTable(String filePath, StringHashTable table)   {
		if (filePath == null || table == null)
			return false;
		File file = new File(filePath); 
		if(!file.canRead() || !file.exists() )
			return false;
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null)
				table.insert(st.trim());
			br.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
}
