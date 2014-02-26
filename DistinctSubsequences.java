
public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDistinct("abc","acd"));
	}
	  public static int numDistinct(String S, String T) {
	        if(S.isEmpty())return 0;
			if(T.isEmpty())return 1;
			int[][] dp = new int[S.length()+1][T.length()+1];
			
			for(int i = 0; i<S.length()+1;i++)
			{
				dp[i][0] = 1;
			}
			
			for(int i = 0;i<S.length();i++)
			{
				for(int j = 0; j<T.length();j++)
				{
					if(S.charAt(i)==T.charAt(j))
					{
						dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
					}
					else
					{
						dp[i+1][j+1] = dp[i][j+1];
					}
				}
			}
			
			return dp[S.length()][T.length()];
	    }
}
