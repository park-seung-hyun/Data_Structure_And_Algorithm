// 트리 

public class Tree{
	public static void main(String[] args) {
		LinkedTree<Integer> lt = new LinkedTree<Integer>();
		TreeNode t4 = lt.makeTree(null, null, 4);
		TreeNode t3 = lt.makeTree(t4, null, 3);
		TreeNode t2 = lt.makeTree(null, null, 2);
		TreeNode t1 = lt.makeTree(t3, t2, 1);
		System.out.println("In-Order");
		lt.inOrder(t1);
		System.out.println("Post-Order");
		lt.postOrder(t1);
		System.out.println("Pre-Order");
		lt.preOrder(t1);
	}
}
class LinkedTree<T> {
	private TreeNode root;
	public TreeNode makeTree(TreeNode lb,TreeNode rb, T data) {
		TreeNode<T> root = new TreeNode<T>(data);
		root.left = lb;
		root.right = rb;
		return root;
	}
	// 전위 순회 
	public void preOrder(TreeNode root) {
		if(root != null) {
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	// 중위 순회 
	public void inOrder(TreeNode root) {
		if(root != null) {
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}
	// 후위 순회 
	public void postOrder(TreeNode root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
		}
	}
}
class TreeNode<T>{
	T data;
	TreeNode left;
	TreeNode right;
	public TreeNode(T data) {
		this.data=data;
		this.left = null;
		this.right = null;
	}
}