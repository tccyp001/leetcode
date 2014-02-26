import java.util.Arrays;


public class minCut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int minCut(String s) {
	    boolean p[][] = new boolean[s.length()+1][s.length()+1];
	   
	    int dp[] = new int[s.length()+1];
	    Arrays.fill(dp, s.length());
	    dp[s.length()] = -1;
	    for(int i = s.length()-1;i>=0;i--)
	    {
	        for(int j = i;j<s.length();j++)
	        {
	            if(s.charAt(i) == s.charAt(j) &&(j-i<2 || p[i+1][j-1]))
	            {
	                p[i][j] = true;
	                dp[i] = Math.min(dp[i], dp[j+1]+1);
	            }
	        }
	    }
	    return dp[0];
    }
}
