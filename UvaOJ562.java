
public class UvaOJ562 {
	public static void main(String args[])
	{
		int[] input1 = new int[]{2,3,5};
		
		int dpsize = 500;
		int[] dp = new int[dpsize];
		
		dp[0] = 1;
		int sum = 0;
		for(int i=0;i<input1.length;i++)
		{
			sum+= input1[i];
			for(int j=dpsize-1;j>=input1[i];j--)
			{
				dp[j] = dp[j-input1[i]];
			}
		}
		
		int mid = sum/2;
		while(dp[mid]==0)
		{
			mid--;
		}
		int result = sum - 2*mid;
		System.out.println(result);
		
		
	}
}
