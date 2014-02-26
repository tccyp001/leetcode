
public class Spiral22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spiral22 ins = new Spiral22();
		int[][] ret = ins.generateMatrix(3);
		OutputHelper.printArrArrInt(ret);
	}
	 public int[][] generateMatrix(int n) {
	        
	        int totalLevel = n/2;
	        int[][] arr = new int[n][n];
	        int index = 1;
	        for(int i = 0;i<totalLevel;i++)
	        {
	           for(int j = i;j<n-i;j++)
	                arr[i][j] = index++;
	           
	           for(int j = i+1;j<n-i;j++)
	               arr[j][n-i-1] = index++;
	           
	           for(int j = n-i-2;j>=i;j--)
	                arr[n-i-1][j] = index++;
	                
	           for(int j = n-i-2;j>i;j--)
	                arr[j][i] = index++;     
	        }
	        if(n%2==1) arr[n/2][n/2] = index;
	        return arr;
	    }
}
