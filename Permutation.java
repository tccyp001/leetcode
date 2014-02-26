import java.util.ArrayList;


public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] input = {1,2,3};
        ArrayList<ArrayList<Integer>> ret = permuteUnique(input);
        for(ArrayList<Integer> sub:ret)
        {
        	for(int i: sub)
        	{
        		System.out.print(i);
        	}
        	System.out.println();
        }
	}
	 public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
	        
	        return permuteSub(num,0);
	    }
	    public static ArrayList<ArrayList<Integer>> permuteSub(int[] num, int start)
	    {
	        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	        if(start ==num.length-1)
	        {
	            ArrayList<Integer> sub = new ArrayList<Integer>();
	            sub.add(num[start]);
	            ret.add(sub);
	            return ret;
	        }
	        ArrayList<ArrayList<Integer>> subret = permuteSub(num, start+1);
	        
	        int cur = num[start];
	        for(ArrayList<Integer> arr: subret)
	        {
	             ArrayList<Integer> newList = new ArrayList<Integer>(arr);
                 newList.add(0,cur);
                 ret.add(newList);
	            for(int i =1;i<arr.size()+1;i++)
	            {
	                if(arr.get(i-1)!=cur)
	                {
	                    ArrayList<Integer> newList1 = new ArrayList<Integer>(arr);
	                    newList1.add(i,cur);
	                    ret.add(newList1);
	                }
	                else
	                {
	                	break;
	                }
	               
	            }
	
	        }
	        return ret;

	    }
}
