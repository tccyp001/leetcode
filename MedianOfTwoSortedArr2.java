
public class MedianOfTwoSortedArr2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianOfTwoSortedArr2 ins = new MedianOfTwoSortedArr2();
		int[] A = {1,2,3};
		int[] B = {1};
		double ret = ins.findMedianSortedArrays(A, B);
		System.out.println(ret);
	}
    public double findMedianSortedArrays(int A[], int B[]) {
        if(A.length == 0 && B.length == 0)return 0;
	        
	        int m = A.length;
	        int n = B.length;
	        
	        if(((m+n)&0x01) ==1) return findKth(A,0,B,0, (m+n)/2 +1);
	        else
	        {
	            return (findKth(A,0,B,0, (m+n)/2 +1) + findKth(A,0,B,0, (m+n)/2))/2;
	        }
   }
   
   public double findKth(int A[], int astart, int B[], int bstart, int k)
   {
       if(A.length - astart > B.length - bstart) return findKth(B,bstart, A, astart, k);
       if(astart == A.length)
       {
           return B[bstart + k -1];
       }
       if(bstart == B.length)
       {
           return A[astart +k-1];
       }
       if(k==1)return Math.min(A[astart],B[bstart]);
       int alen = A.length - astart;
       int blen = B.length - bstart;
       int p1 = Math.min(alen, k/2);
       
       int p2 = k -p1;
       
       if(A[p1+astart-1] == B[bstart + p2 -1])return A[p1+astart-1];
       if(A[p1+astart-1] < B[bstart + p2 -1])
       {
           return findKth(A, astart + p1, B, bstart, k - p1);
       }
       else
       {
           return findKth(A, astart, B, bstart + p2, k - p2);
       }
   }
}
