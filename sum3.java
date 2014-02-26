import java.util.ArrayList;
import java.util.Arrays;


public class sum3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1,0,1,2,-1,-4};
		ArrayList<ArrayList<Integer>> ret = threeSum(arr);
		
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
	
	public static ArrayList<ArrayList<Integer>> ts(int[] num)
	{
	    ArrayList<ArrayList<Integer>> resSet = new ArrayList<ArrayList<Integer>>();  
	     if (num.length < 3) return resSet;  
	     Arrays.sort(num);  
	     for (int i=0; i<num.length-2 && num[i]<=0; ++i) {  
	       // remove duplicates  
	       if (i>0 && num[i]==num[i-1]) continue;  
	       // use two pointer to find b+c = -a  
	       int start=i+1, end=num.length-1;  
	        while (start<end) {  
	          int sum = num[i] + num[start] + num[end];  
	          if (sum < 0) {  
	            start++;  
	          } else if (sum > 0) {  
	            end--;  
	          } else { // find one  
	            ArrayList<Integer> res = new ArrayList<Integer>(3);  
	            res.add(num[i]);  
	            res.add(num[start]);  
	            res.add(num[end]);  
	            resSet.add(res);  
	            // move the left pointer to right and skip duplicates;  
	            do { start++; } while (start<end && num[start]==num[start-1]);  
	            // move the right pointer to left and skip duplicates  
	            do { end--; } while (start<end && num[end]==num[end+1]);  
	          }  
	        }  
	      }  
	      return resSet;  
	}
	
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num.length==0)return ret;
        Arrays.sort(num);
        for(int i=0;i<num.length;i++)
        {
            if(i>0 && num[i] ==num[i-1])continue;
            int target = 0 -  num[i];
            int start = i+1;
            int end = num.length-1;
            while(start<end)
            {
                if(num[start] + num[end]==target)
                {
                    ArrayList<Integer> arr = new ArrayList<Integer>();
                    arr.add(num[i]);
                    arr.add(num[start]);
                    arr.add(num[end]);
                    ret.add(arr);
                
                    do { start++; } while (start<end && num[start]==num[start-1]);  
                    // move the right pointer to left and skip duplicates  
                    do { end--; } while (start<end && num[end]==num[end+1]);
                }
                else if(num[start] + num[end]>target)
                {
                    end--;
                }
                else
                {
                    start++;
                }
               // do { start++; } while (start<end && num[start]==num[start-1]);  
                        // move the right pointer to left and skip duplicates  
                       //   do { end--; } while (start<end && num[end]==num[end+1]); 
            }
        }
        return ret;
        
    }

}
