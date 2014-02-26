import java.util.ArrayList;
import java.util.List;


public class UOJ111 {

	/**
	 * @param args
	 */
	int[] ansList = {4, 3, 2, 1}; 
	int[] records = {3, 1, 4, 2};
	static int len = 5;
	public int[][] dp = new int[len][len];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		//int[][] dp = new int[5][5];
	//	int[][] dp = {{'1', '2', '3','4'}, {'4', '2', '1','3'}};
		
		UOJ111 uoj = new UOJ111();
		for(int i = 0 ; i<len;i++)
		{
			for(int j = 0 ; j<len;j++)
			{
				uoj.dp[i][j] = 0;
			}
		}
		

		uoj.cal();
        System.out.println(uoj.dp[4][4]);
        
		
	}
	private void Input()
	{
		
	}
	private int Max(int x ,int y)
	{
		return (x>y)?x:y;
	}
	private void cal()
	{
		for(int i = 1 ; i<len;i++)
		{
			for(int j = 1 ; j<len;j++)
			{
				int max1 = dp[i-1][j-1];
				if(ansList[i-1] == records[j-1])
				{
					max1 +=1; 
				}
				int max2 = Max(dp[i-1][j],dp[i][j-1]);
				dp[i][j] = Max(max1, max2);
			}
		}
	}

}
