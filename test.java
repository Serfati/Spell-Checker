
public class testerRon {
	private static boolean testPassed = true;
	private static int testNum = 0;

	public static void main(String[] args) {
	//	ConstantStringHashFunction();
	//	AccumulateStringHashFunction();
		//ImprovedStringHashFunction();	
		//StringHashTable();
		//Parser();
		//WordSpellingChecker();
		SpellingChecker();

		if (testPassed) {
			System.out.println("All " + testNum + " tests passed!");
		}
	}
	private static void test(boolean exp, String msg) {
		testNum++;
		if (!exp) {
			testPassed = false;
			System.out.println("Test " + testNum + " failed: "  + msg);
		}
	}

	private static void ConstantStringHashFunction() {
		ConstantStringHashFunction const1 = new ConstantStringHashFunction();
		test((const1.hash("My hash") == 3), "The answer should be -3."); //1
	}

	private static void AccumulateStringHashFunction() {
		AccumulateStringHashFunction acc1 = new AccumulateStringHashFunction();
		test((acc1.hash("My hash")== 650 ), "The answer should be 650."); //2
	}

	private static void ImprovedStringHashFunction() {
		ImprovedStringHashFunction shf1 = new ImprovedStringHashFunction();
		String st1="My hash";
		test((shf1.hash(st1) == st1.hashCode()), "The answer should be "+st1.hashCode()+"."); //3
		String st2="";
		test((shf1.hash(st2) == st2.hashCode()), "The answer should be "+st2.hashCode()+"."); //4
		String st3="popcorn";
		test((shf1.hash(st3) == st3.hashCode()), "The answer should be "+st3.hashCode()+"."); //5
		String st4="AaBbCcDd";
		test((shf1.hash(st4) == st4.hashCode()), "The answer should be "+st4.hashCode()+"."); //6
		String st5="off";
		test((shf1.hash(st5) == st5.hashCode()), "The answer should be "+st4.hashCode()+"."); //7
	}

	private static void StringHashTable() {
		AccumulateStringHashFunction acc2 = new AccumulateStringHashFunction();
		StringHashTable stht1 = new StringHashTable(10,acc2);
		test((stht1.insert(null) == false ), "The answer should be false."); //8
		test((stht1.numOfElementsInTable() == 0), "The answer should be 0."); //9
		test((stht1.insert("ron") == true ), "The answer should be true."); //10
		test((stht1.numOfElementsInTable() == 1), "The answer should be 1."); //11
		test((stht1.insert("ron") == false ), "The answer should be false."); //12
		test((stht1.numOfElementsInTable() == 1), "The answer should be 1."); //13
		test((stht1.insert("My hash") == true ), "The answer should be true."); //14
		test((stht1.numOfElementsInTable() == 2), "The answer should be 2."); //15
		test((stht1.insert("qoo") == true ), "The answer should be true."); //16
		test((stht1.numOfElementsInTable() == 3), "The answer should be 3."); //17

		test((stht1.search(null) == false), "The answer should be false."); //18
		test((stht1.search("ron") == true), "The answer should be true."); //19
		test((stht1.search("My hash") == true), "The answer should be true."); //20
		test((stht1.search("qoo") == true), "The answer should be true."); //21

		test((stht1.delete(null) == false), "The answer should be false."); //22
		test((stht1.delete("ron") == true), "The answer should be true."); //23
		test((stht1.numOfElementsInTable() == 2), "The answer should be 2."); //24
		test((stht1.delete("ron") == false), "The answer should be false."); //25
		test((stht1.delete("My hash") == true), "The answer should be true."); //26
		test((stht1.numOfElementsInTable() == 1), "The answer should be 1."); //27
		test((stht1.delete("qoo") == true), "The answer should be true."); //28
		test((stht1.numOfElementsInTable() == 0), "The answer should be 0."); //29

		test((stht1.search("ron") == false), "The answer should be false."); //30
		test((stht1.search("My hash") == false), "The answer should be false."); //31
		test((stht1.search("qoo") == false), "The answer should be false."); //32
	}	

	private static void Parser() {
		AccumulateStringHashFunction acc3 = new AccumulateStringHashFunction();
		StringHashTable stht2 = new StringHashTable(10,acc3);

		test((Parser.parseWordsToTable("test.txt", stht2) == false), "The answer should be false."); //33
		test((Parser.parseWordsToTable(null, stht2) == false), "The answer should be false."); //34
		test((Parser.parseWordsToTable("C:/Users/Serfati/workspace/HW4/src/dictionary.txt", null) == false), "The answer should be false."); //35
		test((Parser.parseWordsToTable("C:/Users/Serfati/workspace/HW4/src/dictionary.txt", stht2) == true), "The answer should be true."); //36
		test((stht2.search("accept") == true), "The answer should be true."); //37
		test((stht2.insert("accept") == false ), "The answer should be false."); //38
		test((stht2.numOfElementsInTable() == 3004), "The answer should be 3000."); //39
	}

	private static void WordSpellingChecker() {
		AccumulateStringHashFunction acc4 = new AccumulateStringHashFunction();
		StringHashTable stht3 = new StringHashTable(10,acc4);
		Parser.parseWordsToTable("C:/Users/Serfati/workspace/HW4/src/dictionary.txt", stht3);
		WordSpellingChecker wsc=new WordSpellingChecker(stht3);

		test((wsc.isWordExistingInDictionary(null) == false), "The answer should be false."); //40
		test((wsc.isWordExistingInDictionary("beer") == true), "The answer should be true."); //41
		test((wsc.isWordExistingInDictionary("beel") == false), "The answer should be false."); //42
		test((wsc.isWordExistingInDictionary("") == false), "The answer should be false."); //43
		test((wsc.isWordExistingInDictionary(" ") == false), "The answer should be false."); //44

		test((wsc.addSpaceCheck("idealer").toString().equals("[i dealer, ideal er]")), "The answer should be [i dealer, ideal er]."); //45
		test((wsc.addSpaceCheck(null).toString().equals("[]")), "The answer should be []."); //46
		test((wsc.addSpaceCheck("aaim").toString().equals("[a aim]")), "The answer should be [a aim]."); //47
		test((wsc.addSpaceCheck("aima").toString().equals("[aim a]")), "The answer should be [aim a]."); //48

		test((wsc.replaceCharacterCheck("").toString().equals("[]")), "The answer should be []."); //49
		test((wsc.replaceCharacterCheck(null).toString().equals("[]")), "The answer should be []."); //50
		test((wsc.replaceCharacterCheck("bake").toString().equals("[cake, lake, make, sake, take, wake, bike, base]")), "The answer should be [cake, lake, make, sake, take, wake, bike, base]."); //51
		test((wsc.replaceCharacterCheck("mrn").toString().equals("[man, mrs]")), "The answer should be [man, mrs]."); //52
		test((wsc.replaceCharacterCheck("maa").toString().equals("[mad, man, map, may]")), "The answer should be [mad, man, map, may]."); //53
		test((wsc.replaceCharacterCheck("aan").toString().equals("[ban, can, fan, man, pan]")), "The answer should be [ban, can, fan, man, pan]."); //54

		test((wsc.deleteCharacterCheck("").toString().equals("[]")), "The answer should be []."); //55
		test((wsc.deleteCharacterCheck(null).toString().equals("[]")), "The answer should be []."); //56
		test((wsc.deleteCharacterCheck("contesxt").toString().equals("[context, contest]")), "The answer should be [context, contest]."); //57
		test((wsc.deleteCharacterCheck("aman").toString().equals("[man]")), "The answer should be [man]."); //58
		test((wsc.deleteCharacterCheck("mban").toString().equals("[ban, man]")), "The answer should be [ban, man]."); //59
		test((wsc.deleteCharacterCheck("mabn").toString().equals("[man]")), "The answer should be [man]."); //60
		test((wsc.deleteCharacterCheck("manb").toString().equals("[man]")), "The answer should be [man].");	//61

		test((wsc.addCharacterCheck("").toString().equals("[]")), "The answer should be []."); //62
		test((wsc.addCharacterCheck(null).toString().equals("[]")), "The answer should be []."); //63
		test((wsc.addCharacterCheck("son").toString().equals("[soon, song]") ), "The answer should be [soon, song]."); //64
		test((wsc.addCharacterCheck("an").toString().equals("[ban, can, fan, man, pan, and, any]")), "The answer should be [ban, can, fan, man, pan, and, any]."); //65
		test((wsc.addCharacterCheck("mn").toString().equals("[man]")), "The answer should be [man]."); //66
		test((wsc.addCharacterCheck("ma").toString().equals("[mad, man, map, may]")), "The answer should be [mad, man, map, may]."); //67

		test((wsc.switchAdjacentCharacterCheck("").toString().equals("[]")), "The answer should be []."); //68
		test((wsc.switchAdjacentCharacterCheck(null).toString().equals("[]")), "The answer should be []."); //69
		test((wsc.switchAdjacentCharacterCheck("ksis").toString().equals("[kiss]")), "The answer should be [kiss]."); //70
		test((wsc.switchAdjacentCharacterCheck("amn").toString().equals("[man]")), "The answer should be [man]."); //71
		test((wsc.switchAdjacentCharacterCheck("mna").toString().equals("[man]")), "The answer should be [man]."); //72

		test((wsc.getWordSuggestions("").toString().equals("[]")), "The answer should be []."); //73
		test((wsc.getWordSuggestions(null).toString().equals("[]")), "The answer should be []."); //74
		test((wsc.getWordSuggestions("soun").toString().equals("[soon, soul, soup, sun, son, sound]")), "The answer should be [soon, soul, soup, sun, son, sound]."); //75
	}

	private static void SpellingChecker() {
		AccumulateStringHashFunction hash = new AccumulateStringHashFunction();
		StringHashTable map = new StringHashTable(7, hash);
		SpellingChecker sc = new SpellingChecker(map);
		Parser.parseWordsToTable("C:/Users/Serfati/workspace/HW4/src/dictionary.txt", map);
		test((sc.spellingCheck("").toString().equals("[]")), "The answer should be ."); //76
		test((sc.spellingCheck(" ").toString().equals("[]")), "The answer should be ."); //77
		test((sc.spellingCheck("love").toString().equals("[]")), "The answer should be ."); //78
		String text = "iam afraid youare about to become teh f iam immexdiate pst president of teh f eing alive club ha ha glados iam afraid youare about to become teh immexdiate pst president of teh eing alive club ha ha glados";		
		System.out.println(sc.spellingCheck(text));
		System.out.println("áãå÷ ùääãôñä äàçøåðä úåàîú ìôìè áãôé äòáåãä");
		
	}
}
