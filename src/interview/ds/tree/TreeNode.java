package interview.ds.tree;

public class TreeNode {

	public int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data, TreeNode left, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public TreeNode() {
		
	}
	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
}
