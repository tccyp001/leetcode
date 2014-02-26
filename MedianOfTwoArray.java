
public class MedianOfTwoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int A[] = {1,3,5,7,9};
		//int B[] = {2,4,6,8,10};
		int A[] = {};
		int B[] = {1};
		double median = findMedianSortedArrays(A,B);
		System.out.println(median);
				
	}
	  public static double findMedianSortedArrays(int A[], int B[]) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        int m = A.length;
	        int n = B.length;
	        if(m + n == 0)return 0;
	        if(((m+n) &0x01) == 1)return findKth(A,B,0,0,(m+n)/2+1);
	        else
	        {
	            return (findKth(A,B,0,0,(m+n)/2) + findKth(A,B,0,0,(m+n)/2 +1)) /2;
	        }
	        
	        
	    }
	    public static double findKth(int A[], int B[], int aStart, int bStart, int k)
	    {
	         
	        if(A.length == aStart)return B[bStart + k-1];
	        if(k==1)return Math.min(A[aStart],B[bStart]);
	        
	        
	        if(A.length - aStart > B.length - bStart)
	         return findKth(B,A,bStart,aStart,k);

	        
	        int aLen = A.length - aStart;
	        int pa = Math.min(k/2, aLen);
	        int pb = k - pa;
	        if(A[pa+aStart-1]<B[pb+bStart-1])
	        {
	        	return findKth(A,B, aStart+pa, bStart, k - pa);
	        }
	        else if (A[pa+aStart-1]>B[pb+bStart-1])
	        {
	        	return findKth(A,B, aStart, bStart+pb, k - pb);
	        }
	        else
	        {
	            return A[pa-1];
	        }
	    }
}
