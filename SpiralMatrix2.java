import java.util.ArrayList;


public class SpiralMatrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{1,2},{3,4}};
		SpiralMatrix2 ins = new SpiralMatrix2();
		 ArrayList<Integer> ret = ins.spiralOrder(input);
		
		OutputHelper.printArrInt(ret);
	}
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        int rowCnt = matrix.length;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(rowCnt == 0)return ret;
        
        int colCnt = matrix[0].length;
        int totalLevel = Math.min(colCnt, rowCnt) / 2;
        
        for(int k = 0;k<totalLevel;k++)
        {
            for(int i = k;i<colCnt-k;i++)
                ret.add(matrix[k][i]);
            for(int i = k + 1;i<rowCnt -k; i++)
                ret.add(matrix[i][colCnt -k-1]);
            for(int i = colCnt - k-2;i>=k+1;i--)
                ret.add(matrix[rowCnt-k-1][i]);
            for(int i = rowCnt -k -1;i>=k+1;i--)
                ret.add(matrix[i][k]);
        }
        
        if((Math.min(colCnt, rowCnt) & 0x01) == 1)
        {
           if(colCnt>rowCnt)
           {
               for(int i = totalLevel;i< colCnt;i++)
                ret.add(matrix[totalLevel][i]);
           }
           else
           {
                for(int i = totalLevel;i< rowCnt;i++)
                    ret.add(matrix[i][totalLevel]);
           }
        }
        return ret;
    }
}
