import java.util.ArrayList;


public class Combination2 {

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
	       return combineSub(n,k,1);
	        
	    }
	    public static  ArrayList<ArrayList<Integer>> combineSub(int n, int k, int start)
	    {
	        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	        if(start>n)return ret;
	        if(k==1) 
	        {
	            
	            for(int i=start;i<=n;i++)
	            {
	                ArrayList<Integer> subret = new ArrayList<Integer>();
	                subret.add(i);
	                ret.add(subret);
	            }
	        }
	        else
	        {
	            ret = combineSub(n,k-1,start+1);
	            for(ArrayList<Integer> subret: ret)
	            {
	                subret.add(0,start);
	            }
	            ArrayList<ArrayList<Integer>> ret2 = combineSub(n,k,start+1);
	            ret.addAll(ret2); 
	        }
	        return ret;
	        
	    }
}
