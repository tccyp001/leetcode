
public class UvaOJ147 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input1 = new int[]{1,5,10,20,50,100,200};
		
		
		int input2 = 1;
		int[] dp = new int[input2];
		dp[0] =1;
		for(int i =0;i<input1.length;i++)
		{
			int cur = input1[i];
			for(int j = cur; j<input2;j++)
			{
				
				dp[j] += dp[j - cur];
			}
		}
		System.out.println(dp[input2-1]);
	}

}
