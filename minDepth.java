import java.util.LinkedList;
import java.util.Queue;


public class minDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		System.out.println(minDepth1(node1));

	}
    public static int minDepth1(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null)return 0;
        Queue<TreeNode> queueParent = new LinkedList<TreeNode>();
        Queue<TreeNode> queueChild = new LinkedList<TreeNode>();
        
        queueParent.add(root);
        TreeNode curNode = null;
        int depth = 1;
        if(root.left == null&& root.right == null)return 1;
        while(!queueParent.isEmpty() || !queueChild.isEmpty())
        {
            curNode = queueParent.remove();
            if(curNode.left==null&&curNode.right==null)return depth;
            if(curNode.left!=null )
            {
                queueChild.add(curNode.left);
            }
            if(curNode.right!=null)
            {
                queueChild.add(curNode.right);
            }

            if(queueParent.isEmpty())
            {
                Queue<TreeNode> tmpque = queueParent;
                queueParent = queueChild;
                queueChild = tmpque;
                queueChild.clear();
                depth++;
            }
        }
        return depth;
    }
}
