
public class RecontructTree {

	
	/*
	 * 
	 *                10
	 *            9       7
	 *         8     6  5    4
	 *        1 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {10, 9, 8, 1, 6, 7 ,5, 4};
		int[] inorder = {1, 8, 9, 6, 10, 5, 7, 4};
		
		TreeNode rootNode = buildTree(preorder, inorder,0,0,preorder.length);
		printTree(rootNode,8);
		
		
		TreeNode node1 = findTreeNodeByValue(1, rootNode);
		TreeNode node2 = findTreeNodeByValue(6, rootNode);
		
		
		TreeNode commonNode = LSANode(rootNode, node1, node2);
		
		System.out.println();
		System.out.println();
		System.out.println(commonNode.val);
	}
	
	public static TreeNode findTreeNodeByValue(int value, TreeNode root)
	{
		if(root ==null) return null;
		if(root.val == value) return root;
		TreeNode node = findTreeNodeByValue(value, root.left);
		if(node!=null) return node;
		node = findTreeNodeByValue(value, root.right);
		if(node!=null) return node;
		return null;
			
	}
	public static TreeNode LSANode(TreeNode root, TreeNode node1, TreeNode node2)
	{
		
		RetInfo retInfo = isInTree(root, node1, node2);
		return retInfo.node;
		
	}
	public static RetInfo isInTree(TreeNode root, TreeNode node1, TreeNode node2)
	{
		RetInfo retInfo = new RetInfo();
		if(root==null) return retInfo;

		

		RetInfo lretInfo = isInTree(root.left, node1, node2);
		RetInfo rretInfo = isInTree(root.right, node1, node2);
		if(lretInfo.node!=null)
		{
			retInfo.node = lretInfo.node;
			return retInfo;
		}
			
		
		if(rretInfo.node!=null)
		{
			retInfo.node = rretInfo.node;
			return retInfo;
		}

		if(lretInfo.isNode1Found || rretInfo.isNode1Found)
			retInfo.isNode1Found = true;
		
		if(lretInfo.isNode2Found || rretInfo.isNode2Found)
			retInfo.isNode2Found = true;
		
		if(root== node1)
			retInfo.isNode1Found= true;
		if(root== node2)
			retInfo.isNode2Found= true;
		
		if(retInfo.isNode1Found && retInfo.isNode2Found)
		{
			retInfo.node = root;
		}

		return retInfo;

	}
	public static void printTree(TreeNode root, int indent)
	{
		
		if(root.left!=null)
			printTree(root.left, indent/2);
		if(root.right!=null)
			printTree(root.right, indent+2);
		if(root.left!=null || root.right!=null)
		System.out.println();
		for(int i =0;i<indent ;i++)
		{
			System.out.print("  ");
		}
		System.out.print(root.val);
	}
	
	
	private static TreeNode buildTree(int[] preorder, int[] inorder, int preorderStart, int inorderStart, int nodeNumber){
		
		if(nodeNumber<=0) return null; // we might not need this
		if(nodeNumber == 1) 
		{
			TreeNode node = new TreeNode(preorder[preorderStart]);
			//node.Data = ;
			return node;
		}
		
		int rootValue = preorder[preorderStart];
		int index = FindIndex(inorder, rootValue, inorderStart);
		
		if(index == -1) return null;//throw exception... 
		
		int leftTreeNodeNumber = index - inorderStart;
		int rightTreeNodeNumber = nodeNumber - leftTreeNodeNumber -1;
		
		TreeNode leftTree = buildTree(preorder, inorder, preorderStart +1, inorderStart, leftTreeNodeNumber);
		TreeNode rightTree = buildTree(preorder, inorder, preorderStart + leftTreeNodeNumber +1, index+1, rightTreeNodeNumber);
		
		TreeNode node = new TreeNode(rootValue);

		node.left = leftTree;
		node.right = rightTree;
		
		return node;
	}
	
	private static int FindIndex(int[] arr, int key,int start)
	{
		for(int i = start; i< arr.length;i++)
		{
			if(arr[i] == key)return i;
		}
		return -1;
	}

}
