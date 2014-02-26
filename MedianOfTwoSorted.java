
public class MedianOfTwoSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianOfTwoSorted ins = new MedianOfTwoSorted();
		int[] A = {1,2};
		int[] B = {1,2};
		
		double ret = ins.findMedianSortedArrays(A, B);
	}
    public double findMedianSortedArrays(int A[], int B[]) {
        
        int aLen = A.length;
        int bLen = B.length;
        if(aLen ==0 && bLen ==0)return 0;
        if(((aLen + bLen) &0x01) ==1)
            return findKth(A,0,B,0,(aLen+bLen)/2+1);
        else 
        {
        	double a = findKth(A,0,B,0, (aLen+bLen)/2+1);
        	double b = findKth(A,0,B,0, (aLen+bLen)/2);
        	return (a+b)/2;
        }


    }
    public double findKth(int A[], int aStart, int B[], int bStart, int k)
    {
        if(A.length-aStart > B.length - bStart)return findKth(B,bStart,A,aStart,k);
        if(aStart==A.length)return B[bStart + k - 1];
        
        if(k==1)return Math.min(A[aStart], B[bStart]);
        
        int p1 = Math.min(k/2, A.length - aStart);
        
        int p2 = k - p1;
        
        if(A[p1+aStart -1] == B[p2+bStart-1]) return A[p1+aStart-1];
        else if(A[p1+aStart-1] > B[p2+bStart-1])
            return findKth(A, aStart + p1, B, bStart, k-p1);
        else
            return findKth(A, aStart, B, bStart + p2, k-p2);
        
        
    }
	
}
