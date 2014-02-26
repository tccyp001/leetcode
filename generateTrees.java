import java.util.ArrayList;


public class generateTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateTrees instance = new generateTrees();
		ArrayList<TreeNode> ret = instance.generateTrees(2);
	}
	   public ArrayList<TreeNode> generateTrees(int n) {
	        return buildTreesSub(1, n+1);
	    }
	    public ArrayList<TreeNode> buildTreesSub(int start, int end)
	    {
	        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
	        if(start == end) 
	        {
	            ret.add(null);
	            return ret;
	        }
	        if(start == end -1)
	        {
	            TreeNode node = new TreeNode(start);
	            ret.add(node);
	            return ret;
	        }
	        else 
	        {
	            for(int i = start;i<end;i++)
	            {
	                ArrayList<TreeNode> leftRet = buildTreesSub(start, i);
	                ArrayList<TreeNode> rightRet = buildTreesSub(i+1, end);
	                for(TreeNode left:leftRet)
	                {
	                    for(TreeNode right:rightRet)
	                    {
	                        TreeNode root = new TreeNode(i);
	                        root.left = copyTree(left);
	                        root.right = copyTree(right);
	                        ret.add(root);
	                    }
	                }
	                
	            }
	        }
	        return ret;
	    }
	    public TreeNode copyTree(TreeNode root)
	    {
	        if(root == null)return null;
	        TreeNode newNode = new TreeNode(root.val);
	        newNode.left = copyTree(root.left);
	        newNode.right = copyTree(root.right);
	        
	        return newNode;
	        
	    }
}
