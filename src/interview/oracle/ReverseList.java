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
		System.out.println(lst);
		lst.head = reverseListRecur(lst.head);
		System.out.println(lst);
	}

	private static Node reverseListInPairRecur(Node head) {
		
		
		if(head==null || head.next==null){
			return head;
			
		}
		
		
		Node remaining= head.next.next;
		
		Node newHead=head.next;
		
		head.next.next=head;
		
		head.next=reverseListInPairItr(remaining);
		
		return newHead;
		
	}
	
	
	private static Node reverseListInPairItr(Node head) {
		
		if(head ==null || head.next==null){
			return head;
		}
		
		Node p=head;
		Node newHead=p.next;
		
		while(true){
			Node q=p.next;
			Node temp=q.next;
			q.next=p;
			if(temp==null || temp.next==null){
				p.next=temp;
				return newHead;
			}
			
			p.next=temp.next;
			p=temp;
		}
		
	}
	
	private static Node reverseListItr(Node head){
		Node curr=head;
		Node prev=null;
		while(curr!=null){
			Node next = curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}
	
	private static Node reverseListRecur(Node head){
		
		if(head==null || head.next==null){
			return head;
		}
		
		Node next=reverseListRecur(head.next);
		
		head.next.next=head;
		head.next=null;
		return next;
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
