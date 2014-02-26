
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2};
		int[] B = {1,1};
        System.out.println(findMedianSortedArrays(A,B));
	}
	public static double findMedianSortedArrays(int A[], int B[]) {
        // IMPORTANT: Please reset any member data you declared, as
        if(A.length == 0 && B.length == 0)return 0;
        
        int m = A.length;
        int n = B.length;
        
        if(((m+n)&0x01) ==1) return findKth(A,B,0,0, (m+n)/2 +1);
        else
        {
            return (findKth(A,B,0,0, (m+n)/2 +1) + findKth(A,B,0,0, (m+n)/2))/2;
        }
	  }
	  public  static double findKth(int A[], int B[], int startA, int startB, int k)
	  {
	      if((A.length-startA) >(B.length-startB))return findKth(B,A,startB,startA,k);
	      
	      if((A.length - startA )==0)return B[k-1];
	      if(k==1)return Math.min(A[startA],B[startB]);
	      
	      int p1 = Math.min(k/2, A.length - startA);
	      int p2 = k - p1;
	      
	      if(A[startA+p1-1]<B[startB+p2-1])
	          return findKth(A,B, startA + p1, startB, k-p1);
	      else if(A[startA+p1-1]>B[startB+p2-1])
	          return findKth(A,B,startA, startB + p2, k-p2);
	      else 
	          return A[startA+p1-1];
	      
	  }
}
