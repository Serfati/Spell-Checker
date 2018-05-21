public class tester {
	public static void main(String[] args)  {
		AccumulateStringHashFunction hash = new AccumulateStringHashFunction();
		StringHashTable map = new StringHashTable(7, hash);
		SpellingChecker sc = new SpellingChecker(map);
		WordSpellingChecker wc  = new WordSpellingChecker(map);
		Parser.parseWordsToTable("C:/Users/Serfati/workspace/HW4/src/dictionary.txt", map);		
		String text = "iam afraid youare about To become "
				+ "teh immexdiate pst president iam of teh eing alive iam club ha ha iam glados";
		;
	}
}