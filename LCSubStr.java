
public class LCSubStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String input1 = "abcdefb";
        String input2 = "cbdcefbg";
        
        int[][] dp = new int[input1.length()+1][input2.length()+2];
        
        int max = 0;
        int end1 = 0;
        int end2 = 0;
        
        for(int i = 0; i<input1.length();i++)
        {
        	dp[i][0] = 0;
        }
        for(int j = 0; j<input1.length();j++)
        {
        	dp[j][0] = 0;
        }
        
        for(int i=1;i<=input1.length();i++)
        {
        	for(int j =1;j<=input2.length();j++)
        	{
        		if(input1.charAt(i-1) == input2.charAt(j-1))
        		{
        			dp[i][j] = dp[i-1][j-1] +1;
        			
        			if(dp[i][j] >max)
        			{
        				end1 = i;
        				end2 = j;
        				max = dp[i][j];
        			}
        		}
        		else
        		{
        			dp[i][j]=0;
        		}
        	}
        }
        
        System.out.println(end1+"," +end2 +"," + max);
	}

}
