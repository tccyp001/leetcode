
public class UvaOJ116 {

	

	public static void main(String[] args) {
		int col =6;
		int row = 5;
		// TODO Auto-generated method stub
		int[][] input = new int[][]{{3, 4, 1, 2, 8, 6},{6, 1, 8, 2, 7, 4},{5, 9, 3, 9, 9, 5},{8, 4, 1, 3, 2, 6},{3, 7, 2, 1, 2, 3}};
		int[][] dp = new int[5][6];
		
		for(int i = 0; i<row;i++)
		{
			for(int j = 0; j<col;j++) 
			{
				dp[i][j] = 0;
			}
		}
		
		for(int i = 0 ; i< row; i++)
		{
			dp[i][5] = input[i][5];
		}
		
		for(int i = 1; i<col; i++)
		{
			for(int j = 0; j<row;j++)
			{
				dp[j][col - i -1] = myMin(dp[j][col-i],dp[(j-1 + row) % row][col-i],dp[(j+1) % row][col-i]) + input[j][col - i -1];
			}
		}
		
		
		for(int i = 0 ; i< row; i++)
		{
			System.out.println(dp[i][0]);
		}
		
		
	}
	private static  int  myMin(int x, int y,int z)
	{
		int a = x<y?x:y;
		a = a<z?a:z;
		return a;
	}
	
}
