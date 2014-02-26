import java.util.ArrayList;


public class UniqueBinarySearchTrees2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<TreeNode> ret = generateTrees(7);
		System.out.println(ret.size());
	}
	 public static ArrayList<TreeNode> generateTrees(int n) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        return generateTreesSub(0, n+1);
	    }
	    public  static ArrayList<TreeNode> generateTreesSub(int start, int end)
	    {
	        ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
	        if(start==end)
	        {
	            trees.add(null);
	            return trees;
	        }
	        if(start+1==end)
	        {
	             trees.add(new TreeNode(start));
	             return trees;
	        }
	        for(int i=start;i<end;i++)
	        {
	            ArrayList<TreeNode> left = generateTreesSub(start,i);
	            ArrayList<TreeNode> right = generateTreesSub(i+1,end);
	            for(TreeNode n1:left)
	            {
	                for(TreeNode n2:right)
	                {
	                    TreeNode n3  = new TreeNode(i);
	                    n3.left = n1;
	                    n3.right = n2;
	                    trees.add(n3);
	                }
	            }
	        }
	        return trees;
	         
	    }
}
