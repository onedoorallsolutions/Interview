package interview.ds.tree;

import java.util.Stack;

public class PostOrder {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(9, new TreeNode(6, null, new TreeNode(5, null, null)), null),
				new TreeNode(10, new TreeNode(8, null, null), new TreeNode(6, null, null)));

		postOrderRec(root);
		System.out.println();
		postOrderItr(root);
		System.out.println();
	}

	static void postOrderRec(TreeNode root) {
		if (root == null) {
			return;
		}

		postOrderRec(root.left);

		postOrderRec(root.right);
		System.out.print(root.data + " ");
	}

	static void postOrderItr(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		s1.push(root);
		while (!s1.isEmpty()) {
			root = s1.pop();
			s2.push(root.data);
			if (root.left != null) {
				s1.push(root.left);
			}

			if (root.right != null) {
				s1.push(root.right);
			}
		}

		while (!s2.isEmpty()) {
			System.out.print(s2.pop() + " ");
		}

	}
}
