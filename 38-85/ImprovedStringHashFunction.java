/**
 * @author Avihai Serfati		204520803
 * 				   Moshe Bitan		204073255
 */
public class ImprovedStringHashFunction implements StringHashFunction {
	@Override
	public int hash(String str) {
		int hash = 0;
		if (str.length() > 0) {
			char val[] = str.toCharArray();
			for (int i = 0; i < str.length(); i++) 
				hash = 31 * hash + val[i];
		}
		return hash;
	}
}
