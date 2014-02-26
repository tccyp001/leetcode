
public class restoreBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);

		//n1.right = n3;
		n1.left = n2;
		//n3.left = n4;
		recoverTree(n1);
	}
	 public static void recoverTree2(TreeNode root) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	       TreeNode[] nodes = new TreeNode[3];
	       nodes[0] = null;
	       nodes[1] = null;
	       nodes[2] = null;
	       recoverTreeSub(root, nodes);
	       
	       if(nodes[1]!=null && nodes[2]!=null)
	       {
	           int tmp = nodes[1].val;
	           nodes[1].val = nodes[2].val;
	           nodes[2].val = tmp;
	       }

	        
	    }
	    public static void recoverTreeSub(TreeNode root, TreeNode[] nodes)
	    {
	        if(root == null) return;
	        if(root.left!=null)recoverTreeSub(root.left, nodes);
	        if(nodes[0]!=null && nodes[0].val>root.val)
	        {
	            if(nodes[1] == null) nodes[1] = nodes[0];
	            nodes[2] = root;

	        }
	        nodes[0] = root;
	        if(root.right!=null)recoverTreeSub(root.right, nodes);
	        
	    }
	public static void recoverTree(TreeNode root) {
        if(root == null) return;
        TreeNode[] nodes = new TreeNode[3];
        inOrder(nodes, root);
        if(nodes[0]!= null && nodes[1] !=null)
        {
            int tmp = nodes[0].val;
            nodes[0].val = nodes[1].val;
            nodes[1].val = tmp;
        }
    }
    public static void inOrder(TreeNode[] nodes,TreeNode cur)
    {
       
        if(cur.left!=null) inOrder(nodes,cur.left);
        if(nodes[2]!=null && cur.val<nodes[2].val)
        {
            if(nodes[0] == null) nodes[0] = nodes[2];
            nodes[1] = cur;
        }
        nodes[2] = cur;
        if(cur.right!=null)inOrder(nodes,cur.right);
    }
}
