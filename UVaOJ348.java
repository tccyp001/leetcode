
public class UVaOJ348 {
	public static void main(String[] args) {
	
		int[] dj = {1,5,20};
		int[] dh = {5, 20,1};
		int length = 3;
		int[][] dp = new int[length][length];
		
		for(int i =0;i<length;i++)
		{
			
			for(int j =0;j<length;j++)
			{
				dp[i][j] = Integer.MAX_VALUE;
			}
			dp[i][i]=0;
			
		}
		
		
		for(int i = 1 ; i< length ; i++)
		{
			for(int j=0;j< length -i ;j++)
			{
				
				for(int k =0;k<i;k++)
				{
					if(dp[j][j+i] > dp[j][j+k] + dp[j+k+1][j+i] + dj[k]*dh[k]*dh[k+1])
					{
						dp[j][j+i] = dp[j][j+k] + dp[j+k+1][j+i]+ dj[k]*dh[k]*dh[k+1];
					}
				}

			}
		}
		System.out.println(dp[0][2]);
		
	}
}
