package interview.ds.linkedlist;

public class LinkedListDemo {

	public static void main(String[] args) {
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null))))));

		System.out.println(head);
		Node reversedHead = reverseListItr(head);
		System.out.println(reversedHead);
		System.out.println(reverseListInPairRecurr(reversedHead));
	}

	private static Node reverseListInPairRecurr(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node newHead = head.next;
		Node remaining = head.next.next;
		head.next.next = head;
		head.next = reverseListInPairRecurr(remaining);
		return newHead;
	}

	private static Node reverseListRecurr(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node next = reverseListRecurr(head.next);
		head.next.next = head;
		head.next = null;
		return next;

	}

	private static Node reverseListItr(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node current = head;
		Node prev = null;
		while (current != null) {
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	private static Node reverseListInPairItr(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node p = head;
		Node newHead = p.next;

		while (true) {
			Node q = p.next;
			Node temp = q.next;
			q.next = p;

			if (temp != null && temp.next != null) {
				p.next = temp.next;
			} else if (temp != null) {
				p.next = temp;
				break;
			} else {
				p.next = null;
				break;
			}

			p = temp;
		}
		return newHead;
	}
}

class Node {
	int data;
	Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

}
