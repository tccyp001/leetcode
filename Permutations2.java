import java.util.ArrayList;


public class Permutations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3};
		ArrayList<ArrayList<Integer>> ret =permute(num);
		
		 for(ArrayList<Integer> arr1 : ret)
			{
				for(int i :arr1)
				{
					System.out.print(i+ ",");
					
				}
				System.out.println();
			}
			System.out.println("aa");
	}
	 public static ArrayList<ArrayList<Integer>> permute(int[] num) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        
	            ArrayList<Integer> path = new ArrayList<Integer>();
	            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	            boolean[] used = new boolean[num.length];
	            permuteSub(num, 0,path,ret,used );
	            return ret;
		    }
		    public static  void permuteSub(int[] num, int count, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ret, boolean[] used )
		    {
		        if(count == num.length)
		        {
		            ret.add(new  ArrayList<Integer> (path));
		            return;
		        }
		        for(int i = 0;i<num.length;i++)
		        {
		            if(used[i]==false)
		            {
		                used[i]=true;
		                path.add(num[i]);
		                permuteSub(num, count+1,path,ret,used );
		                path.remove(path.size()-1);
		                used[i]=false;
		            }
		        }

		    }
}
