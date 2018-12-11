import java.util.List;
/**
 * Class of misspelled word and list of suggestions.
 * @author 
 *
 */
public class SpellingSuggestion {
	private String originalWord;
	private List<String> suggestionList;
	/**
	 * 
	 * @param original - the original misspelled word. Not null!
	 * @param suggestionList - a list of suggestions for the misspeled word. Not null!
	 */
	public SpellingSuggestion(String original, List<String> suggestionList){
		this.originalWord = original;
		this.suggestionList = suggestionList;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof SpellingSuggestion)) {
			return false;
		}
		SpellingSuggestion other = (SpellingSuggestion) obj;
		if (originalWord.equals(other.originalWord)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		// Returns empty string if the one or more of the fields are null.
		if (this.originalWord == null || this.suggestionList == null) {
			return "";
		}

		StringBuilder builder = new StringBuilder();
		builder.append("The word \"");
		builder.append(this.originalWord);
		builder.append("\" was misspelled. ");

		if (this.suggestionList.isEmpty()) { // Empty list
			builder.append("No suggestions found for this word.\n");
		}
		else {
			builder.append("Did you mean:\n");

			// For-each loop that iterates the suggestion list.
			for (String word : this.suggestionList) {
				builder.append("\t");
				builder.append(word);
				builder.append("\n");
			
			}
		}
		return builder.toString();
	}
}
