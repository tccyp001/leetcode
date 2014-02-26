
public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d[][] = generateMatrix(5);
		
		
		for(int i = 0;i<5;i++)
		{
			for(int j = 0;j<5;j++)
			{
				System.out.print(d[i][j]);
				System.out.print("  ");
			}
			System.out.println();
		}
	}
	 public static int[][] generateMatrix(int n) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int d[][] = new int[n][n];
	        
	        int index = 1;
	        for(int i=0;i<n/2;i++)
	        {
	        	for(int j =i;j<n-i;j++)
	        	{
	        		d[i][j] = index++;
	        	}
	        	for(int j =i+1;j<n-i-1;j++)
	        	{
	        		d[j][n-1-i] = index++;
	        	}
	        	for(int j =n-i-1;j>i;j--)
	        	{
	        		d[n-i-1][j] = index++;
	        	}
	        	for(int j =n-i-1;j>i;j--)
	        	{
	        		d[j][i] = index++;
	        	}
	        }
	        if(n%2==1)
	        {
	        	d[n/2][n/2] = index;
	        }
	        return d;
	    }

}
