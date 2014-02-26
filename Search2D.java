
public class Search2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}
		
		};
		int[][] matrix2 = {{1,1}};
		boolean ret = searchMatrix2(matrix2,2);
		System.out.println(ret);
	}
	public  static boolean searchMatrix2(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int rowCnt = matrix.length;
        if(rowCnt == 0) return false;
        int colCnt = matrix[0].length;
        
        int start = 0;
        int end = rowCnt *colCnt;
        while(start<end)
        {
            int mid = start + (end - start)/2;
            if(matrix[mid/colCnt][mid%colCnt]==target) return true;
            if(matrix[mid/colCnt][mid%colCnt]>target) end = mid;
            else start = mid+1;
        }
        return false;
      }
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int rowCnt = matrix.length;
        if(rowCnt == 0) return false;
        int colCnt = matrix[0].length;
        
        
        int rowStart = 0;
        int rowEnd = rowCnt -1;
        while(rowStart<=rowEnd)
        {
        	int midrow = rowStart + (rowEnd - rowStart) /2;
        	if(matrix[midrow][0]==target) return true;
        	if(matrix[midrow][0]<target)
        	{
        		rowStart = midrow+1;
        	}
        	else
        	{
        		rowEnd = midrow-1;
        	}
        }
        if(rowStart==0)return false;
        rowStart--;
        
        int colStart = 0;
        int colEnd = colCnt -1;
        while(colStart<=colEnd)
        {
        	int midcol = colStart + (colEnd - colStart) /2;
        	if(matrix[rowStart][midcol]==target) return true;
        	if(matrix[rowStart][midcol]<target)
        	{
        		colStart = midcol+1;
        	}
        	else
        	{
        		colEnd = midcol-1;
        	}
        }
        
        return false;
        
    }
}
