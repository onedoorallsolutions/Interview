package interview.oracle;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
 /* 
    
    class TNode 
       int data;
       Node left;
       Node right;
   */
   void LevelOrder(TNode root)
    {
      java.util.LinkedList<TNode> lst = new java.util.LinkedList<TNode>();
       lst.addFirst(root);
       System.out.print(lst.getFirst().data+" ");
       TNode curr = root;
       while(!lst.isEmpty()) {
           if(curr.left!=null) {
                lst.addLast(curr.left);
           }
           if(curr.right!=null) {
               lst.addLast(curr.right);
           }
           lst.removeFirst();
           curr = lst.getFirst();
           System.out.print(lst.getFirst().data+" ");           
       }
      
    }

}
