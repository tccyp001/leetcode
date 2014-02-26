import java.util.Arrays;
import java.util.HashMap;


public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] input = {217,231,523,52,547,243,648,509,415,149,689,710,265,187,370,56,977,182,400,329,471,805,955,989,255,766,38,566,79,843,295,229,988,108,781,619,704,542,335,307,359,907,727,959,161,699,123,650,147,459,657,188,304,268,405,685,620,721,351,570,899,60,388,771,24,659,425,440,508,373,32,645,409,272,356,175,533,740,370,152,34,510,745,251,227,494,258,527,817,773,178,194,860,387,627,851,449,736,15,212,529,950,316,28,65,484,968,63,4,643,795,669,203,677,139,636,289,555,430,849,150,493,301,377,240,873,965,441,230,349,447,470};
		int[] input = {5,25,75};

		
		int[] ret = twoSum2(input, 100);
	}
	public static int[] twoSum2(int[] numbers, int target)
	{
		 int[] ret = new int[2];
	        ret[0] = -1;
	        ret[1] = -1;
	        
	        if(numbers.length<1)return ret;
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        
	        for(int i = 0; i<numbers.length;i++)
	        {
	            map.put(numbers[i],i+1);
	        }
	        for(int i = 0; i<numbers.length;i++)
	        {
	            if(map.containsKey(target - numbers[i]))
	            {
	                 int pos2 =  map.get(target-numbers[i]);
	                 if(pos2 == i+1)continue;
	                 ret[0] = i+1;
	                 ret[1] = pos2;
	                 
	                 return ret;
	            }

	        }
	        return ret;
	        
	}
	 public static int[] twoSum(int[] numbers, int target) {
	       
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	        int start = 0;
	        int end = numbers.length-1;
	        int[] ret = new int[2];
	        int[] ret1 = new int[2];
	        ret[0] = -1;
	        ret[1] = -1;
	        
	        if(numbers.length<1)return ret;
	        int[] input = numbers.clone();
	        Arrays.sort(numbers);
	        while(start < end)
	        {
	            if((numbers[start]+numbers[end])>target)end--;
	            else if((numbers[start]+numbers[end])<target)start++;
	            else {
	                ret[0] = numbers[start];
	                ret[1] = numbers[end];
	                break;
	            }
	        }
	        boolean first = true;
	        for(int i =0;i<input.length;i++)
	        {
	            if(first &&input[i]==ret[0])
	            {
	            	ret1[0]=i+1;
	                first = false;
	                continue;
	            }
	           if((!first ||ret[0]!=ret[1]) && input[i]==ret[1])
	            {
	        	   ret1[1]=i+1;
	            }
	        }
	        if(ret1[0]>ret1[1])
	        {
	            int tmp = ret1[0];
	            ret1[0] = ret1[1];
	            ret1[1] = tmp;
	        }
	        return ret1;
	    }

}
