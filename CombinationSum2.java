import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,1};
		ArrayList<ArrayList<Integer>>  ret = combinationSum2(num, 2);
		System.out.println();
	}
	 public static ArrayList<ArrayList<Integer>>  combinationSum2(int[] num, int target) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	         Arrays.sort(num);
	         return combinationSumSub(num,target,0);
	    }
	        public static ArrayList<ArrayList<Integer>> combinationSumSub(int[] candidates, int target, int start) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		        if(target<=0) return ret;
		        
		        for(int i = start;i<candidates.length;i++)
		        {
		        	if(i>start && candidates[i] == candidates[i-1]) continue;
		            if(target<candidates[i])continue;
		            if(target == candidates[i]) 
		            {
		                ArrayList<Integer> ans = new ArrayList<Integer>();
		                ans.add(target);
		                ret.add(ans);
		            }
		            else
		            {
		                ArrayList<ArrayList<Integer>> subret = combinationSumSub(candidates, target - candidates[i], i+1);
		                if(subret.size()>0)
		                {
		                    for(ArrayList<Integer> subans: subret )
		                    {
		                       // if(candidates[i]>=subans.get(subans.size()-1))
		                      //  {
		                            subans.add(0,candidates[i]);
		                            ret.add(subans);
		                     //   }

		                    }
		                }
		            }
		
		        }
	            return ret;
	        }
}
