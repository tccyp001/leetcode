import java.util.Arrays;


public class cloest3sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {0,1,2};
		int target = 0;

        int ret = threeSumClosest(num,target);
        System.out.println(ret);
	}
    public static int threeSumClosest(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num.length==0)return 0;
        Arrays.sort(num);
        
        int closet = Integer.MAX_VALUE;
        int delta = Integer.MAX_VALUE;
        for(int i =0;i<num.length-2;i++)
        {
            int start = i +1;
            int end = num.length - 1;
            if(i>0 && num[i]==num[i-1])continue;
            while(start<end)
            {
                if(num[i]+num[start]+num[end]==target) return target;
                
                if(Math.abs(num[i]+num[start]+num[end] - target)<delta)
                {
                    delta = Math.abs(num[i]+num[start]+num[end] - target);
                    closet = num[i]+num[start]+num[end];
                }
                if(num[i]+num[start]+num[end]<target)
                {
                	do
                	{
                		 start++;
                	}
                    while( start<end && num[start]==num[start-1] );
                }
                else
                {
                	do
                	{
                		 end--;
                	}
                    while( start<end && num[end]==num[end+1] );  
                }
                
               
            }
        }
        return closet;
    }
}
