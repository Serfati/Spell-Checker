/**This hash function return always a constant  number in our case 3
 * @author Avihai Serfati		204520803
 * 				   Moshe Bitan		204073522
 */
public class ConstantStringHashFunction implements StringHashFunction {
	@Override
	public int hash(String str) {
		return 3;
	}
}
