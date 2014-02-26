import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;


public class Subset2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] input = {1,1,2,2,2};
		ArrayList<ArrayList<Integer>> ret = subsetsWithDup(input);
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
	 public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	        // Note: The Solution object is instantiated only once and is reused byArrayList<E>t case.
		
		 ArrayList<ArrayList<Integer>> ret = subsetSub(num,0);
       
	    return ret;     
	        
	 }
	 public static ArrayList<ArrayList<Integer>> subsetSub(int[] num, int start)
	 {
		 Arrays.sort(num);
		 
		 ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		 if(num.length==0)
        {
        	ArrayList<Integer> sub = new ArrayList<Integer>();
        	ret.add(sub);
        	return ret;
        }
		 if(start == num.length-1)
		 {
		        ArrayList<Integer> sub2 = new ArrayList<Integer>();
		        ret.add(sub2);
			 ArrayList<Integer> sub1 = new ArrayList<Integer>();
			 sub1.add(0,num[start]);
	        ret.add(sub1);

	        return ret;
		 }
		 
		 ArrayList<ArrayList<Integer>> subret = subsetSub(num, start +1);
	//	 if(num[start] == num[start+1])
		// {
			// ArrayList<Integer> sub2 = new ArrayList<Integer>();
			 //ret.add(sub2);
		 //}
		 for(ArrayList<Integer> sub: subret)
		 {
			 ArrayList<Integer> sub1 = new ArrayList<Integer>(sub);
			 sub1.add(0,num[start]);

			 if(num[start] != num[start+1] || sub.size() ==0 || num[start] != sub.get(0))
			 {
				 ret.add(sub);
			 }
			 ret.add(sub1);
		 }

		 return ret;
		 
	 }
	 
}
