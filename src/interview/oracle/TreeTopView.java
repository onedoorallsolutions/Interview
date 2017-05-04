package interview.oracle;
import java.util.*;

class TNode {
	int data;
	TNode left;
	TNode right; 
}
public class TreeTopView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	   class TTNode 
	       int data;
	       TNode left;
	       TNode right;
	*/
	void top_view(TNode root)
	{
	  TNode temp1 = root;
	  TNode temp2 = root;
	  java.util.LinkedList<Integer> l = new java.util.LinkedList<Integer>();
	  l.addFirst(root.data);
	  while(temp1.left != null || temp2.right != null) {
	      temp1 = temp1.left;
	      temp2 = temp2.right;
	      if(temp1 != null)
	      l.addFirst(temp1.data);
	      if(temp2 != null)
	      l.addLast(temp2.data);
	  }
	  java.util.Iterator<Integer> itr = l.iterator();
	  while(itr.hasNext()) {
	      System.out.print(itr.next()+" ");
	  }
	}


}
