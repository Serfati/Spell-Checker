import java.util.ArrayList;
import java.util.List;
/**	Word spell checker corrects even the most severe spelling mistakes with unmatched accuracy.
 * this class take each word and check if its correct or not
 * and gives a list of suggestions.
 * @author Avihai Serfati		204520803
 * 				   Moshe Bitan		204073522
 */
public class WordSpellingChecker {
	private StringHashTable  wordTable;

	/**
	 * Constractor
	 * @param wordTable - a string HashTable
	 */
	public WordSpellingChecker(StringHashTable wordTable) {
		if (wordTable != null)
			this.wordTable = wordTable;
	}
	/**
	 * 	Check if a singel word existing In dictionary
	 * @param word 
	 * @return true if word existing In dictionary
	 */
	public boolean isWordExistingInDictionary(String word) {
		if (word == null || !wordTable.search(word.trim()) )
			return false;
		else return true;
	}
	/**
	 * add space to word and Check its a vaild word
	 * @param word - a word to be check (not null)
	 * @return a list of suggestions
	 */
	public List<String> addSpaceCheck(String word) {
		List<String> res = new ArrayList<>();
		if (word == null || word.equalsIgnoreCase("") )
			return res;
		word = word.trim();
		for (int i = 0; i < word.length()+1; i++) {
			StringBuilder bulid = new StringBuilder(word);
			bulid.insert(i, " ");
			String[] curr=bulid.toString().split(" ");
			if (wordTable.search(curr[0]) && wordTable.search(curr[1])
					&& !res.contains(bulid.toString()))
				res.add(bulid.toString());
		}
		return res;
	}
	/**
	 * replace characters in word and Check its a vaild word
	 * @param word - a word to be checked (not null)
	 * @return a list of suggestions
	 */
	public List<String> replaceCharacterCheck(String word) {
		List<String> res = new ArrayList<>();
		if (word == null || word.equalsIgnoreCase(""))
			return res;
		word = word.trim();
		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; j < 26; j++) {
				StringBuilder bulid = new StringBuilder(word);
				char ch = (char) ('a'+j);
				bulid.setCharAt(i, ch);
				if (wordTable.search(bulid.toString()) 
						&& !bulid.toString().equals(word))
					res.add(bulid.toString());
			}
		}
		return res;
	}
	/**
	 * delete character in word and Check its a vaild word
	 * @param word - a word to be checked (not null)
	 * @return a list of suggestions
	 */
	public List<String> deleteCharacterCheck(String word) {
		List<String> res = new ArrayList<>();
		if (word == null || word.length()<2)
			return res;
		word = word.trim();
		for (int i = 0; i < word.length(); i++) {
			StringBuilder bulid = new StringBuilder(word);
			String buffer =bulid.deleteCharAt(i).toString();
			if (wordTable.search(buffer)
					&& !res.contains(bulid.toString()))
				res.add(buffer);
		}
		return res;
	}
	/**
	 * Add character to word and Check its a vaild word
	 * @param word - a word to be checked (not null)
	 * @return a list of suggestions
	 */
	public List<String> addCharacterCheck(String word) {
		List<String> res = new ArrayList<>();	
		if (word == null || word.equalsIgnoreCase(""))
			return res;
		word = word.trim();
		for (int i = 0; i < word.length()+1; i++) {
			for (int j = 0; j < 26; j++) {
				StringBuilder bulid = new StringBuilder(word);
				char ch = (char) ('a'+j);
				bulid.insert(i, ch);
				if (wordTable.search(bulid.toString()) 
						&& !res.contains(bulid.toString()))
					res.add(bulid.toString());
			}
		}
		return res;
	}
	/**
	 * Switch adjacent characters  in word and Check its a vaild word
	 * @param word - a word to be checked (not null)
	 * @return a list of suggestions
	 */
	public List<String> switchAdjacentCharacterCheck(String word) {
		List<String> res = new ArrayList<>();
		if (word == null || word.length()<2)
			return res;
		word = word.trim();
		for (int i = 0; i < word.length()-1; i++) {
			StringBuilder bulid = new StringBuilder(word);
			char ch = word.charAt(i);
			char ch2 = word.charAt(i+1);
			bulid.setCharAt(i, ch2);
			bulid.setCharAt(i+1, ch);
			if (wordTable.search(bulid.toString()) 
					&& !bulid.toString().equals(word)
					&& !res.contains(bulid.toString()))
				res.add(bulid.toString());
		}
		return res;
	}
	/**
	 *  Gives all word suggestions 
	 * @param word - a word to be checked (not null)
	 * @return a list of suggestions build from all other functions
	 */
	public List<String> getWordSuggestions(String word) {
		List<String> res = new ArrayList<>();
		if (word == null || word.equalsIgnoreCase(""))
			return res;
		word = word.trim();
		res.addAll(addSpaceCheck(word)) ;
		res.addAll(replaceCharacterCheck(word)) ;
		res.addAll(deleteCharacterCheck(word)) ;
		res.addAll(addCharacterCheck(word)) ;
		res.addAll(switchAdjacentCharacterCheck(word)) ;
		return res;
	}
}
