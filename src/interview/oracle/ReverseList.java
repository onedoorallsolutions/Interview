package interview.oracle;

public class ReverseList {
	public static void main(String a[]) {
		LinkedList lst = new LinkedList();
		lst.add(1);
		lst.add(2);
		lst.add(3);
		lst.add(4);
		lst.add(5);
		lst.add(6);
		lst.add(7);
		reverseListInPair(lst);
		//reverseList(lst);
		System.out.println(lst);
	}
	private static void reverseList(LinkedList lst){
		Node head = lst.head;
		Node revNext = null;
		while(head.getNext()!=null) {
			Node temp = head.getNext();
			head.setNext(revNext);
			revNext = head;
			head = temp;
		}
		head.setNext(revNext);
		lst.head = head ;
	}
	private static void reverseListInPair(LinkedList lst) {
		Node head = lst.head;
		Node revNext = null;
		while(head.getNext()!=null && head.getNext().getNext()!=null) {
			Node temp = head.getNext();
			Node tempHead = temp.getNext();
			temp.setNext(revNext);
			revNext = head;
			head = tempHead;		
		}
		if(head.getNext()==null) {
			head.setNext(revNext);
		}
		else if(head.getNext().getNext()==null){
			head.getNext().setNext(revNext);
		}
		lst.head = head ;
	}

}
