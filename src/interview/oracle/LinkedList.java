package interview.oracle;

public class LinkedList {
	Node head =null;
	public boolean add(int value){
		Node node = new Node(value);
		Node curr = head;
		if(curr == null) {
			head = node;
			return true;
		}
		try {
			while(curr.getNext() != null){
				curr = curr.getNext();
			}
			curr.setNext(node);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	public String toString(){
		Node curr = head;
		String retVal = "[";
		while(curr !=null) {
			retVal+=curr.getValue();
			if(curr.getNext()!=null){
				retVal+=", ";
			}
			curr = curr.getNext();
		}
		retVal+="]";
		return retVal;
	}
	
}
