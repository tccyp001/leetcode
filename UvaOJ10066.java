
public class UvaOJ10066 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input1 = new int[]{20,15,10,15,25,20,15};
		int[] input2 = new int[]{15,25,10,20,15,20};
		
		int[][] dp = new int[10][10];
		
		dp[0][0] = 0;

		for(int i =0;i<10;i++)
		{
			for(int j =0;j<10;j++)
			{
				dp[i][j] = 0 ;
			}
		}
		
		for(int i = 1 ;i<= input1.length;i++)
		{
			for(int j = 1 ;j<= input2.length;j++)
			{
				if(input1[i-1] == input2[j-1])
				{
					dp[i][j] = myMax(dp[i-1][j-1]+1, dp[i-1][j],dp[i][j -1]);
				}
				else
				{
					dp[i][j] = myMax(dp[i-1][j],dp[i][j -1]);
				}
				
			}
		}
		System.out.println(dp[7][6]);
		
	}
	private static int myMax(int x, int y)
	{
		int a = x>y?x:y;
		return a;
	}
	private static  int  myMax(int x, int y,int z)
	{
		int a = x>y?x:y;
		a = a>z?a:z;
		return a;
	}
	
}
