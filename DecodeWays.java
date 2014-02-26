import java.util.HashMap;


public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int num = numDecodings("230");
       System.out.println(num);
	}
    public static int numDecodings(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	  // Note: The Solution object is instantiated only once and is reused by each test case.
    	  int len = s.length();
    
          if(len==0 || s.charAt(0) == '0')return 0;
          int[] arr = new int[len];
          int[] dp = new int[len+1];
          for(int i =0; i<len;i++)
          {
              arr[i] = s.charAt(i) - '0';
          }
          dp[0] = 1;
          dp[1] =1;
          for(int i =2;i<len+1;i++ )
          {  

               if(arr[i-2]*10+arr[i-1] ==0) return 0;
               else if(arr[i-1] ==0 )
               {
            	   if(arr[i-2]<3) dp[i] = dp[i-2]; 
            	   else return 0;
               }
            	  
            	  
               else if(arr[i-2]==0) dp[i] = dp[i-1]; 
               else if(arr[i-2]*10+arr[i-1] <=26) 
               {
                   dp[i] = dp[i-1] + dp[i-2];
               }
               else
               {
                   dp[i] = dp[i-1]; 
               }
          }
          return dp[len];
    }

}
