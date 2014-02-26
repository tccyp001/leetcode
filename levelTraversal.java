import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class levelTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null)return ret;
        
        Queue<TreeNode> parent = new LinkedList<TreeNode>();
        Queue<TreeNode> child = new LinkedList<TreeNode>();
        ArrayList<Integer> sublist = new ArrayList<Integer>();
        parent.offer(root);
        while(parent.size()>0)
        {
            TreeNode cur = parent.remove();
            sublist.add(cur.val);
            if(cur.left!=null)child.offer(cur.left);
            if(cur.right!=null)child.offer(cur.right);
            if(parent.size()==0)
            {
                ret.add(new ArrayList<Integer>(sublist));
                sublist.clear();
                Queue<TreeNode> tmp = parent;
                parent = child;
                child = tmp;
                child.clear();
            }
        }
        return ret;
   }
}
