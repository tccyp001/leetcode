import java.util.ArrayList;
import java.util.Queue;


public class BSTPreorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		t1.val = 1;
      ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
     arr.add(t1);
     TreeNode t2 = arr.get(0);
     t2.val =2;
     System.out.println(t1.val);
	
	
	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> levelarr = new ArrayList<Integer>();
	
	levelarr.add(1);
	ret.add(levelarr);
	printArr(ret);
	System.out.println("===");
	//levelarr.clear();
	printArr(ret);
	
	
	}
	public static void printArr(ArrayList<ArrayList<Integer>> arrlistlist)
	{
		for(ArrayList<Integer> arrlist: arrlistlist)
		{
			for(Integer i :arrlist)
			{
				System.out.println(i);;
			}
		}
		
	}
}
