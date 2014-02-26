import java.util.ArrayList;


public class Triagnle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> s = new ArrayList<Integer>();
		s.add(1);
		ArrayList<Integer> s1 = new ArrayList<Integer>();
		s1.add(2);
		s1.add(3);
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		input.add(s);
		input.add(s1);
		
		minimumTotal2(input);
		
	}
	  public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(triangle.size()==0) return 0;
	        if(triangle.size()==1)return triangle.get(0).get(0);
	        for(int i = triangle.size()-2; i>=0; i--)
	        {
	            for(int j = 0;j<i+1;j++)
	            {
	                triangle.get(i).set(j, Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
	            }
	        }
	        return triangle.get(0).get(0);
	    }
	  public  static int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
	        int rowCnt = triangle.size();
	        if(rowCnt == 0)return 0;
	        int colCnt = triangle.get(0).size();
	        
	        int[][] f = new int[rowCnt][rowCnt];
	        
	        for(int i = rowCnt-1;i>=0;i--)
	        {
	            for(int j = 0 ;j<=i;j++ )
	            {
	                f[i][j] = triangle.get(i).get(j);
	                if(i != rowCnt -1) f[i][j] += Math.min(f[i+1][j], f[i+1][j+1]);
	            }
	        }
	        return f[0][0];
	    }
}
