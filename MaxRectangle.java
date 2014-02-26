import java.util.Arrays;


public class MaxRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] matrix = {  {1,0,0,0,0},
			        		{0,0,1,1,0},
			        		{1,1,1,1,1},
			        		{1,0,0,1,0},
			        		{1,0,1,1,0}};
        int ret = maximalRectangle(matrix);
        System.out.println(ret);
	}
    static int  maximalRectangle(int[][] matrix) {
		if (matrix.length==0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] H = new int[n];
		int[] L = new int[n];
		int[] R = new int[n];
		Arrays.fill(R, n);
		int ret = 0;
		for (int i = 0; i < m; ++i) {
			int left = 0, right = n;
			// calculate L(i, j) from left to right
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == 1) {
					++H[j];
					L[j] = Math.max(L[j], left);
				} else {
					left = j+1;
					H[j] = 0; L[j] = 0; R[j] = n;
				}
			}
		// calculate R(i, j) from right to left
			for (int j = n-1; j >= 0; --j) {
				if (matrix[i][j] == 1) {
					R[j] = Math.min(R[j], right);
					ret = Math.max(ret, H[j]*(R[j]-L[j]));
				} 
				else {
					right = j;
				}
			}
		}
		return ret;
	}

}
