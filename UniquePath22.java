
public class UniquePath22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{0,0}};
		int ret = uniquePathsWithObstacles(input);
		System.out.println(ret);
	}
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowCnt = obstacleGrid.length;
        int colCnt = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1)return 0;
        int[] dp = new int[colCnt];
        
        dp[0] = 1;
        
        for(int i=0;i<rowCnt;i++)
        {
            for(int j=1;j<colCnt;j++)
            {
                if(obstacleGrid[i][j]==1)dp[j]=0;
                else dp[j]+=dp[j-1];
            }
        }
        return dp[colCnt-1];
        
    }
}
