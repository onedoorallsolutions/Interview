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
		lst.add(8);
		lst.add(9);
		lst.add(10);
		lst.add(11);
		lst.add(12);
		System.out.println("------Reverse in Group of K-------");
		System.out.println(lst);
		lst.head = reverseListInGroupOfK(lst.head,3);
		System.out.println(lst);
		
		System.out.println("------Pallindrome Check -------");
		Node pallin=new Node(9,new Node(8,new Node(5,new Node(8,new Node(9,new Node(9,null))))));
		System.out.println(new LinkedList(pallin) +" Is Pallindrome :"+isPallindrome(pallin));
		
		Node pallin2=new Node(9,new Node(8,new Node(5,new Node(5,new Node(8,new Node(9,null))))));
		
		System.out.println(new LinkedList(pallin2) +" Is Pallindrome :"+isPallindrome(pallin2));
		
		Node pallin3=new Node(5,new Node(8,new Node(5,new Node(8,new Node(5,null)))));
		
		System.out.println(new LinkedList(pallin3) +" Is Pallindrome :"+isPallindrome(pallin3));
		
		System.out.println("------Adding two List-------");
		
		Node fistList = new Node(9,new Node(8,new Node(5,new Node(8,new Node(9,null)))));
		
		System.out.println("First List : "+new LinkedList(fistList));
		
		Node secondList=new Node(9,new Node(8,new Node(7,null)));
		System.out.println("Second List : "+new LinkedList(secondList));
		
		System.out.println("Sum :"+new LinkedList(addLinkedList(fistList,secondList)));
		
	}
	
	
	
	private static boolean isPallindrome(Node head){
		if(head==null || head.next==null){
			return true;
		}
		
		Node firstHalf=head;
		

		Node temp=null;
		
		Node slowPtr=head;
		Node fastPtr=head;
		
		
		while(fastPtr!=null && fastPtr.next!=null){
			fastPtr=fastPtr.next.next;
			slowPtr=slowPtr.next;
		}
		
		if(fastPtr==null){
			temp = slowPtr;
		}else if(fastPtr.next==null){
			temp = slowPtr.next;
		}
		
		Node secondHalf= reverseListItr(temp);
		
		while(secondHalf !=null){
			if(firstHalf.value !=secondHalf.value){
				return false;
			}
			firstHalf=firstHalf.next;
			secondHalf=secondHalf.next;
		}
			
		
		return true;
	}
	
	
	private static Node addLinkedList(Node firstList, Node secondList) {
		
		int firstLen = lengthOfList(firstList);
		int secondLen= lengthOfList(secondList);
	
		if(firstLen < secondLen){
			
			while(firstLen!=secondLen){
				Node zeroNode = new Node(0,null);
				zeroNode.next=firstList;
				firstList=zeroNode;
				firstLen++;
			}
			
			
		}else if(secondLen  < firstLen){

			while(secondLen!=firstLen){
				Node zeroNode = new Node(0,null);
				zeroNode.next=secondList;
				secondList=zeroNode;
				secondLen++;
			}
			
			
		}
		
		
		Node firstRev =  reverseListItr(firstList);
		
		Node secondRev = reverseListItr(secondList);
		int c=0;
		Node sumNode = null;
		Node result =null;
		while(firstRev !=null && secondRev !=null){
			
			int d1 =  firstRev.value;
			int d2 = secondRev.value;
			
			int d = d1+d2+c;
			c=0;
			int newValue =d;
			if(d>=10){
				newValue = d%10;
				c = (d /10);	
			}
			Node n = new Node(newValue);
			if(sumNode ==null){
				sumNode=n;
				result = sumNode;
				
			}else{
				sumNode.next=n;
				sumNode=n;
			}
			
			firstRev=firstRev.next;
			secondRev=secondRev.next;
			
		}
		
		if(c !=0){
			Node n = new Node(c);
			sumNode.next=n;
			sumNode=n;
			
		}
		
		return reverseListItr(result);
	}


	private static int lengthOfList(Node head){
		int length = 0;
		
		while(head!=null){
			head=head.next;
			length++;
		}
		return length;
	}
	
	
	private static Node reverseListInGroupOfK(Node head,int k){
		Node p= head;
		int cnt =0;
		
		while(cnt !=k-1){
			if(p==null){
				return head;
			}
			p=p.next;
			cnt++;
		}
		
		Node q = p;
		Node newHead= p;
		
		while(true){
			p = head;
			Node temp = q.next;
			if(temp==null){
				reverseListItr(p);
				p.next=temp;
				return newHead;
			}
			
			q.next=null;
			q=temp;
			head= temp;
			
			cnt=0;
			while(cnt!=k-1){
				if(temp.next==null){
					reverseListItr(p);
					p.next=q;
					return newHead;
				}
				temp=temp.next;
				cnt++;
			}
			
			reverseListItr(p);
			p.next=temp;
			q=temp;
		}
		
		
	}

	private static Node reverseListInPairRecur(Node head) {
		
		
		if(head==null || head.next==null){
			return head;
			
		}
		
		
		Node remaining= head.next.next;
		
		Node newHead=head.next;
		
		head.next.next=head;
		
		head.next=reverseListInPairRecur(remaining);
		
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
