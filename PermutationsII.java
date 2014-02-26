import java.util.ArrayList;
import java.util.Arrays;


public class PermutationsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] input = {1,1,3};
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
        
        Arrays.sort(num);
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        boolean[] used = new boolean[num.length];
        permuteSub(num, 0,path,ret,used );
        return ret;
    }
    public static void permuteSub(int[] num, int count, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ret, boolean[] used )
    {
        if(count == num.length)
        {
            ret.add(new  ArrayList<Integer> (path));
            return;
        }
        ArrayList<Integer> unusedList = new ArrayList<Integer>();
        
        for(int j = 0;j<num.length;j++)
        {
        	 if(used[j]==false)
             {
        		 unusedList.add(j);
             }
        }
        for(int i = 0;i<unusedList.size();i++)
        {
            if(i==0 || num[unusedList.get(i)]!=num[unusedList.get(i-1)])
            {
                used[unusedList.get(i)]=true;
                path.add(num[unusedList.get(i)]);
                permuteSub(num, count+1,path,ret,used );
                path.remove(path.size()-1);
                used[unusedList.get(i)]=false;
            }
        }

    }
}
