package interview.oracle;

import java.util.Random;

public class ReverseLinkedListInPair {

	  private Node head;
	public Node revesePair(Node head)
	{
		Node prev=null;
		Node cur=head;
		Node next=null;
		
		while(cur!=null){
			
			next=cur.next.next;
			cur.next.next=prev;
			prev=cur;
			cur=next;
		}
		head=prev;		
		return head;
	}
	public void push(int element)
	{
		Node new_node=new Node(element);
		new_node.next=head;
		head=new_node;
	}
	public void printNode()
	{
		 Node temp = head;
	        while (temp != null)
	        {
	           System.out.print(temp.getValue()+" ");
	           temp = temp.next;
	        }  
	        System.out.println();
	}
	public static void main(String[] args) {
		
		Random random= new Random();
		
		ReverseLinkedListInPair rllp=new ReverseLinkedListInPair();
		for(int i=0;i<10;i++){
			rllp.push(random.nextInt(100));
			
		}
		System.out.println("Before Reverse!!!");
		rllp.printNode();
		rllp.head=rllp.revesePair(rllp.head);
		System.out.println("After Reverse!!!s");
		rllp.printNode();
	}

}
