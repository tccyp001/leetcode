import java.util.HashMap;


public class PalindromePartitioningII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min = minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp");
		System.out.println(min);
	}
    public static int minCut(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int len = s.length();
        int[][] dp  = new int[len+1][len+1];
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 1; i<len+1 ;i++)
        {
            for(int j = 0; j<len+1-i; j++)
            {
            	 String substr = s.substring(j,j+i);
            	 if(map.containsKey(substr))
            	 {
                     dp[j][i] = map.get(substr);
                  }
                  else
                  {
                      if(isPalindrome(substr))
                      {
                      	dp[j][i] = 0;
                      }
                      else
                      {
                          int min = len;
                          for(int k = 1; k<i; k++)
                          {
                             if((dp[j][k] + dp[j+k][i-k] + 1)<min)
                             {
                          	   min = dp[j][k] + dp[j+k][i-k] + 1;
                             }
                          }
                          dp[j][i] = min;
                      }
                      map.put(substr, dp[j][i]);
                    }

            }
        }
        
        return dp[0][len];

    }
    public static boolean isPalindrome(String s)
    {
    	if(s.equals(new StringBuilder(s).reverse().toString()))return true;
    	return false;
    }

}
