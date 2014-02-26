import java.util.ArrayList;
import java.util.Arrays;


public class subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {4,1,0};
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
	        getSubsetsSub(S,0,path,ret);
	        return ret;
	    }
	    public static void getSubsetsSub(int[] S, int start,ArrayList<Integer> path,  ArrayList<ArrayList<Integer>> ret)
	    {
	        if(start == S.length) 
	        {
	        	ret.add(new ArrayList<Integer>(path));
	        	return;
	        }
	        getSubsetsSub(S, start+1,path, ret);
	        path.add(S[start]);
	        getSubsetsSub(S, start+1,path, ret);
	        path.remove(path.size()-1);
	        
	    }
}
