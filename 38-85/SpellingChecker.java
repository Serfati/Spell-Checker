import java.util.ArrayList;
import java.util.List;
/**
 * @author Avihai Serfati		204520803
 * 				   Moshe Bitan		204073255
 */
public class SpellingChecker {
	private StringHashTable  wordTable;
	public SpellingChecker(StringHashTable wordTable) {
		this.wordTable = wordTable;
	}
	/**
	 * 
	 * @param text - a string text to be checked
	 * @return List of spelling suggestion 
	 */
	public List<SpellingSuggestion> spellingCheck(String text) {
		List<SpellingSuggestion> res = new ArrayList<>();
		if (text == null || text.equalsIgnoreCase(""))
			return res;
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
