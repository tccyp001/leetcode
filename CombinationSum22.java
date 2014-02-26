import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,1};
		combinationSum2(num,1);
	}
	 public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	        
	       ArrayList<Integer> path  = new ArrayList<Integer>();
	        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	        Arrays.sort(num);
	        combinationSumSub(num, 0, target, path, ret);
	        
	        OutputHelper.printArrArrInt(ret);
	        return ret;
	    }
	    public static void combinationSumSub(int[] candidates, int start, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ret)
	    {
	        if(target == 0)
	        {
	            ret.add(new ArrayList<Integer>(path));
	            return;
	        }
	        for(int i= start;i<candidates.length;i++)
	        {
	            if(candidates[i]>target)return;
	            if(i!=start && candidates[i] == candidates[i-1])continue;
	            path.add(candidates[i]);
	            combinationSumSub(candidates, i+1, target - candidates[i], path, ret);
	            path.remove(path.size()-1);
	        }
	    }
}
