import java.util.*;
/**	This tool enables you to correct the most cumbersome mistakes, 
 * with a high degree of accuracy and speed, and to improve your written English.
 * @author Avihai Serfati		204520803
 * 				   Moshe Bitan		204073522
 */
public class SpellingChecker {
	private StringHashTable  wordTable;
	/**
	 * Constractor
	 * @param wordTable - a string HashTable
	 */
	public SpellingChecker(StringHashTable wordTable) {
		this.wordTable = wordTable;
	}
	/**
	 * Spell Checker corrects even the most severe spelling mistakes with unmatched accuracy.
	 * @param text - a string text to be checked
	 * @return List of spelling suggestion 
	 */
	public List<SpellingSuggestion> spellingCheck(String text) {
		List<SpellingSuggestion> res = new ArrayList<>();
		if (text == null || text.equalsIgnoreCase(""))
			return res;
		if(!text.equalsIgnoreCase(" "))
			text= text.trim();
		WordSpellingChecker checker = new WordSpellingChecker(wordTable);
		StringBuilder bulid = new StringBuilder(text);
		String [] currs=bulid.toString().split(" ");
		for (String orgWord : currs) { //foreach
			if (!wordTable.search(orgWord)){
				SpellingSuggestion sugges = new 
						SpellingSuggestion(orgWord, checker.getWordSuggestions(orgWord));
				if (!res.contains(sugges))
					res.add(sugges);
			}
			//do something
		}
		return res;
	}
}
