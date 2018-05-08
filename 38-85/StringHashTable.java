import java.util.ArrayList;
/**
 * @author Avihai Serfati		204520803
 * 				   Moshe Bitan		204073255
 * Implements with ArrayList
 * Java program to demonstrate implementation of our
 * own hash table with chaining for collision detection
 */
public class StringHashTable {
	private int tableSize;
	private StringHashFunction hashFunction;
	private static int totElements;
	private ArrayList <HashNode> map;
	/**
	 * Constractor
	 * @param tableSize
	 * @param hashFunction
	 */
	public StringHashTable(int tableSize, StringHashFunction hashFunction) {
		this.tableSize = tableSize;
		this.hashFunction = hashFunction;
		map = new ArrayList<>();
		// create roots for every bucket	
		for(int i=0; i<tableSize; i++)
			map.add(null);
	}
	/**
	 *     This implements hash function to find index for a key
	 * @return index for a key
	 */
	private int getBucketIndex(String str){
		int key=hashFunction.hash(str);
		return Math.abs(key%tableSize);
	}
	/**
	 * Returns the number of elements in this set
	 * @return 	the number of elements in this set (its cardinality)
	 */
	public int numOfElementsInTable(){
		return totElements;
	}
	/**
	 * Adds the specified element to this set if it is not already present.
	 *  More formally, 
	 *  adds the specified element e to this set if this set contains no element e2 such that (e==null ? e2==null : e.equals(e2)). 
	 *  If this set already contains the element, 
	 * the call leaves the set unchanged and returns false.
	 * @param str - element to be added to this set
	 * @return true if this set did not already contain the specified element
	 */
	public boolean insert(String str) {
		if(str == null || search(str))
			return false;
		boolean ans = false;
		//creating hash code using value given as a string
		int value=hashFunction.hash(str);
		int index=getBucketIndex(str);
		HashNode head= map.get(index);
		HashNode toAdd=new HashNode(str, value);
		if(head==null){
			map.set(index, toAdd);
			totElements++;
			ans = true;
		}else{
			while(head!=null){
				if(head.key.equals(str)){
					head.value=value;
					totElements++;
					ans = true;
					break;
				}
				head=head.next;

			} if(head==null) {
				head=map.get(index);
				toAdd.next=head;
				map.set(index, toAdd);
				totElements++;
				ans = true;
			}
		}
		return ans;
	}
	/**
	 * Removes the specified element from this set if it is present. 
	 * More formally,
		removes an element e such that (o==null ? e==null : o.equals(e)),
		 if this set contains such an element. 
		 Returns true if this set contained the element (or equivalently, 
		 if this set changed as a result of the call).
	 *  (This set will not contain the element once the call returns.)
	 * @param str -  object to be removed from this set, if present
	 * @return true if the set contained the specified element
	 */
	public boolean delete(String str) {
		if(str == null || !search(str))
			return false;
		// Apply hash function to find index for given key
		int bucketIndex = getBucketIndex(str);
		// Get head of chain
		HashNode head = map.get(bucketIndex);
		// Search for key in its chain
		HashNode prev = null;
		while (head != null){
			// If Key found
			if(head.key.equals(str))
				break;
			// Else keep moving in chain
			prev = head;
			head = head.next;
		}
		// If key was not there
		if (head == null)
			return false;
		// Reduce size
		totElements--;
		// Remove key
		if (prev != null)
			prev.next = head.next;
		else
			map.set(bucketIndex, head.next);
		return true;
	}	
	/**
	 * Returns true if this set contains the specified element. 
	 * More formally, 
	 * returns true if and only if this set contains an 
	 * element e such that (o==null ? e==null : o.equals(e)).	
	 * @param str	element whose presence in this set is to be tested
	 * @return	true if this set contains the specified element
	 */
	public boolean search(String str){
		// Find head of chain for given key
		if(str == null )
			return false;
		int index=getBucketIndex(str);
		HashNode head = map.get(index);
		// Search key in chain
		while (head != null){
			if(head.key.equals(str))
				return true;
			head = head.next;
		}
		// If key not found
		return false;
	}
}

