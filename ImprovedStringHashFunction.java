/**This function give you the Sum of the string that you give her 
 * The sum is calculate by the n elements of the create the String that you gave
 * The calculate of this each Element ( Char ) is by the Formula : Sigma(i to n-1) str[i]*31^(n-1-i)
 * @author Avihai Serfati		204520803
 * 				   Moshe Bitan		204073522
 */
public class ImprovedStringHashFunction implements StringHashFunction {
	@Override
	public int hash(String str) {
		int hash = 0;
		if (str.length() > 0) {
			char vals[] = str.toCharArray();
			for (int i = 0; i < str.length(); i++) 
				hash = 31 * hash + vals[i];
		}
		return hash;
	}
}
