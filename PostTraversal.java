import java.util.ArrayList;
import java.util.Stack;


public class PostTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(1);
		//n1.right = n3;
		n1.left = n2;
		//n3.left = n4;
		postorderTraversal(n1);
	}
public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        
	 ArrayList<Integer> ret = new ArrayList<Integer>();
     if(root == null)return ret;
     Stack<TreeNode> stack = new Stack<TreeNode>();
     TreeNode pre = null;
     stack.push(root);
     TreeNode cur = null; 
     while(!stack.isEmpty())
     {
         cur = stack.peek();
         if((cur.left==null && cur.right ==null) || (cur.right !=null && cur.right == pre)
        		 || (cur.right == null && cur.left == pre) )
         {
             ret.add(cur.val);
             stack.pop();
             pre = cur;
         }
         else if(cur.left==null || (cur.left==pre && cur.right!=null))
             stack.push(cur.right);
         else
             stack.push(cur.left);
     }
     return ret;
    }
}
