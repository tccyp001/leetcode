
public class FindMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public double findMedianSortedArrays(int A[], int B[]) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        int lA = 0;
	        int rA = A.length + 1;
	        int lB = 0;
	        int rB = B.length + 1;
	        int amid = 0;
	        int bmid = 0;
	        while(lA<rA)
	        {
	            amid = lA + (rA - lA) /2;
	            bmid = lB + (rB - lB) /2;
	            
	            if(A[amid] == B[bmid]) return A[amid];
	            
	            if(A[amid] > B[bmid])
	            {
	                lA = amid + 1;
	                rB = bmid;
	            }
	            else
	            {
	                rA = amid;
	                lB = bmid  + 1;
	            }
	        }
	        return A[lA] + ((double)B[lB] - (double)A[lA])/2;
	    }
}
