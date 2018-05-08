/**
 * @author Avihai Serfati		204520803
 * 				   Moshe Bitan		204073255
 */
public class HashNode {
	String key;
	int value;
	// Reference to next node
	HashNode next;
	// Constructor
	public HashNode(String key, int value){
		this.key = key;
		this.value = value;
	}
}
