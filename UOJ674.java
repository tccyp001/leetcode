//Coin Change 
public class UOJ674 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 26;
		int dp[] = new int[n];
		int[] changes = new int[]{1,5,10,25,50};  

		
		for(int i = 0; i<n; i++)
		{
			dp[i] = 0;
		}
		dp[0] = 1;
		
		for(int i =0;i<5;i++)
		{
			for(int j = changes[i] ; j< n; j++)
			{
				dp[j] += dp[j- changes[i]];
			}
		}
		
		System.out.println(dp[n-1]);
	}
}
