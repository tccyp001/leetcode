
public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(2,2));
       System.out.println(numTrees(11));
	}
    public static long numTrees(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    	long dp[] = new long[n+1];
        dp[0] =1;
        dp[1] =1;
        for(int i = 2;i<n+1;i++)
        {
            for(int j =0;j<i;j++)
            {
                dp[i] +=(dp[j] *dp[i-j-1]);

            }
        }
        return dp[n];
    }
    public static int uniquePaths(int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
          // the same Solution instance will be reused for each test case.
        
    	  m--;
          n--;
          if(m<0||n<0)return 0;
          if(m==0||n==0)return 1;
  
        if(n>m) 
        {
            int tmp = n;
            n = m;
            m = tmp;
        }
        
        int dp[][] = new int[m+n+1][m+n+1];
        for(int i = 0;i<m+n+1;i++)
        {
            dp[i][0] =1;
            dp[i][i] =1;
            dp[0][i] =0;
        }
        for(int i = 2;i<m+n+1;i++)
        {
            for(int j = 1;j<i;j++)
            {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        return dp[m+n][n];
    }
}
