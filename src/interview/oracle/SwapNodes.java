package interview.oracle;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SwapNodes {

    static java.util.LinkedList<TNode> l = new java.util.LinkedList<TNode>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeCount = Integer.parseInt(sc.nextLine());
        TNode root = new TNode();
        root.data = 1;
        root.left = null;
        root.right = null;
        TNode curr = root;
        l.add(root);
        for(int i=0;i<nodeCount;i++) {
            String[] row = sc.nextLine().split(" ");
            int a = Integer.parseInt(row[0]);
            int b = Integer.parseInt(row[1]);
            TNode left = new TNode();
            TNode right = new TNode();
            left.data = a;
            left.left=null;
            left.right=null;
            if(a!=-1) {
            	l.addLast(left);
            }
            
            right.data = b;
            right.left=null;
            right.right=null;
            if(b!=-1) {
            	l.addLast(right);
            }
            if(curr.data != -1){
                curr.left =left;
                curr.right = right;
            }
            l.removeFirst();
            if(!l.isEmpty()) {
            	curr = l.getFirst();
            }
        }
        //levelOrderTravesal(root);
        int k = Integer.parseInt(sc.nextLine());
        for(int j=0;j<k;j++) {
            int h = Integer.parseInt(sc.nextLine());
            swapAtH(root,h);  
            //levelOrderTravesal(root);
            inOrderTraversal(root);
            System.out.println();
        }
    }
    static void swapAtH(TNode root, int h) {
        TNode curr =root;
        java.util.LinkedList<TNode> l1 = new java.util.LinkedList<TNode>();
        l1.addFirst(root);
        l1.add(null);
        int currHeight = 1;
        while(!l1.isEmpty() && l1.getFirst()!=null) {
            if(curr.left.data != -1)
                l1.addLast(curr.left);
            if( curr.right.data != -1) {
                l1.addLast(curr.right);
            }
            TNode swapChild = l1.removeFirst();
            //System.out.println("before"+swapChild.data+" and "+swapChild.left.data+" and "+swapChild.right.data);
            if(!l1.isEmpty()) {
                if(currHeight%h==0)
                {
                    TNode temp = swapChild.left;
                    swapChild.left = swapChild.right;
                    swapChild.right = temp;
                }
                if(l1.getFirst()==null){
                    l1.addLast(null);
                    l1.removeFirst();
                    currHeight++; 
                }
                //System.out.println("after"+swapChild.data+" and "+swapChild.left.data+" and "+swapChild.right.data);
                curr = l1.getFirst();
            }
        }
    }
    
    public static void levelOrderTravesal(TNode root) {
        TNode curr = root;
        java.util.LinkedList<TNode> l1 = new java.util.LinkedList<TNode>();
        l1.addFirst(root);
        while(!l1.isEmpty()) {
            System.out.println(curr.data);
            if(curr.left.data != -1) {
                l1.addLast(curr.left);
            }
            if( curr.right.data != -1) {
                l1.addLast(curr.right);
            }
            l1.removeFirst();
            if(!l1.isEmpty())
            curr = l1.getFirst();
        }
    }
    public static void inOrderTraversal(TNode root) {
        if(root.data == -1){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
        
    }
}
