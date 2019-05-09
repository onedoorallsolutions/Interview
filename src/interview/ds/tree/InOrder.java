package interview.ds.tree;

import java.util.Stack;

public class InOrder {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1, new TreeNode(9, new TreeNode(6, null, new TreeNode(5, null, null)), null),
				new TreeNode(10, new TreeNode(8, null, null), new TreeNode(6, null, null)));
		
		TreeNode r = new TreeNode(1 , new TreeNode(11,null,null) , new TreeNode(9,null,new TreeNode(2,null,null)));
		
		
		inorderRec(root);
		System.out.println();
		inorderItr(root);
		System.out.println();
		findPathWithSumK(r,12);
		System.out.println();
	}

	static void inorderRec(TreeNode root) {
		if(root ==null) {
			return;
		}
		
		inorderRec(root.left);
		System.out.print(root.data +" ");
		inorderRec(root.right);
	}
	
	static void inorderItr(TreeNode root) {
		if(root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		
		while(true) {
			while(root !=null) {
				stack.add(root);
				root = root.left;
			}
			
			if(stack.isEmpty()) {
				break;
			}
			root = stack.pop();
			System.out.print(root.data +" ");
			root = root.right;
		}
	}
	
	static int sum =0;
	static int count;
	static Stack<Integer> stack = new Stack<>();
	static void findPathWithSumK(TreeNode root, int k) {
		
		if(root ==null) {
			return;
		}
		sum = sum + root.data;
		stack.add(root.data);
		if(root.left ==null && root.right ==null && sum ==k) {
			count++;
			printStack(stack);
			System.out.println();
		}
		findPathWithSumK(root.left, k);
		findPathWithSumK(root.right, k);
		sum = sum - root.data;
		stack.pop();
	}

	private static void printStack(Stack<Integer> stack) {
		stack.forEach( e -> System.out.print(e +" "));
	}
}
