/**
 * @author Avihai Serfati		204520803
 * 				   Moshe Bitan		204073255
 */
public class AccumulateStringHashFunction implements StringHashFunction {
	@Override
	public int hash(String str) {
		int hash=0;
		for ( int i = 0; i < str.length(); i++ ) {
			char c = str.charAt( i );
			hash += (int) c;
		}
		return hash;
	}
}
