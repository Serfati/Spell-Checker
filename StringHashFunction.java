/**
 * 
 * @author Yael Mathov
 * Interface for String hash functions.
 */
public interface StringHashFunction {

	/**
	 * String hash function
	 * @param str - String different from Null
	 * @return hash value in the range [Integer.MIN_INT,Integer.MAX_INT]
	 */
	public int hash(String str);
}
