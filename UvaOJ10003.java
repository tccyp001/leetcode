
public class UvaOJ10003 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = new int[]{0,4,5,7,8,10};
		int[][] dp = new int[101][101];
		for(int i = 0;i<101;i++)
			for(int j = 0;j<101;j++)
			   dp[i][j] = 0;
		
 
		 int n = 6;

		
			for(int j = 2; j< n;j++)
			{
				for(int i=0;i< n-j;i++)
				{
					int min = 1000;
					for(int k=1;k<j;k++)
					{
						int curValue = dp[input[i]][input[i+k]] +  dp[input[i+k]][input[i+j]];
						if(min>curValue)
						{
						 	min = curValue;
						}
					}
					dp[input[i]][input[i+j]] = min + input[i+j] - input[i];
					
					
				}
			}
		
		System.out.println(dp[0][10]);
	}
}
