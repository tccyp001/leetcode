import java.util.ArrayList;
import java.util.Arrays;


public class CombanationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] c = {2,3,6,7};
		ArrayList<ArrayList<Integer>> ret = combinationSum(c,7);
		System.out.println();
	}

	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target){
	         Arrays.sort(candidates);
	         return combinationSumSub(candidates,target);
	 }
	public static ArrayList<ArrayList<Integer>> combinationSumSub(int[] candidates, int target) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	        if(target<=0) return ret;
	        
	        for(int i = 0;i<candidates.length;i++)
	        {
	            if(target<candidates[i])continue;
	            if(target == candidates[i]) 
	            {
	                ArrayList<Integer> ans = new ArrayList<Integer>();
	                ans.add(target);
	                ret.add(ans);
	            }
	            else
	            {
	                ArrayList<ArrayList<Integer>> subret = combinationSumSub(candidates, target - candidates[i]);
	                if(subret.size()>0)
	                {
	                    for(ArrayList<Integer> subans: subret )
	                    {
	                        if(candidates[i]>=subans.get(subans.size()-1))
	                        {
	                            subans.add(candidates[i]);
	                            ret.add(subans);
	                        }

	                    }
	                }
	            }
	
	        }
            return ret;
	    }

}
