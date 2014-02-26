import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class Subset22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {1,2,2,2};
		ArrayList<ArrayList<Integer>> ret = subsets(S);
		for(ArrayList<Integer> list:ret)
		{
			for(int i:list)
			{
				System.out.print(i);
			}
			System.out.println();
		}
	}
	 public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
		    Arrays.sort(S);
	        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> empty = new ArrayList<Integer>();
	        //ret.add(empty);
	        ArrayList<Integer> path = new ArrayList<Integer>();
	        //getSubsetsSub(S,0,path,ret);
	        getSubsetsSub2(S,0,ret);
	        return ret;
	    }
	    public static void getSubsetsSub(int[] S, int start,ArrayList<Integer> path,  ArrayList<ArrayList<Integer>> ret)
	    {

	        ret.add(new ArrayList<Integer>(path));
	        for(int i = start;i<S.length;i++)
	        {
	        	if(i!=start && S[i]==S[i-1])continue;
	        	path.add(S[i]);
	        	getSubsetsSub(S,i+1,path,ret);
	        	path.remove(path.size()-1);
	        }
	    }
	    public static void getSubsetsSub2(int[] S, int start,  ArrayList<ArrayList<Integer>> ret)
	    {
	    	int n = 1<<S.length;
	    	int total  = 1 << S.length;
	    	Set<ArrayList<Integer>> set= new TreeSet<ArrayList<Integer>>();
	    	ArrayList<Integer> path = new ArrayList<Integer>();
	    	for(int i=0;i<total;i++)
	    	{
	    		for(int j = 0;j<n;j++)
	    		{
	    			if((i&(1<<j)) >0)  path.add(S[j]);
	    		}
	    		set.add(new ArrayList<Integer>(path));
	    		
	    		path.clear();
	    	}
	    	
	    }
}
