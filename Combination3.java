import java.util.ArrayList;


public class Combination3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> ret = combine(4,2);
		for(ArrayList<Integer> list:ret)
		{
			for(int i:list)
			{
				System.out.print(i);
			}
			System.out.println();
		}
	}
	 public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
		 ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		 ArrayList<Integer> path = new ArrayList<Integer>();
	     combineSub(n,k,1, path, ret);
	     return ret;
	        
	    }
	 public static void combineSub(int n, int k, int start, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result)
	 {
		// if(start>n)return;
		 if(k==0)
		 {
			 result.add(new ArrayList<Integer>(path));
			 return;
		 }
		 for(int i = start;i<=n;i++)
		 {
			 path.add(i);
			 combineSub(n, k-1, i+1, path, result);
			 path.remove(path.size()-1);
		 }
	 }
}
