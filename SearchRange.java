
public class SearchRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A ={5, 7, 7, 8, 8, 10};
		int[] ret = searchRange(A, 8);
		
		
		
	}
	public static int[] searchRange(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        
        if(A.length <=0) return ret;
        
        int start = 0;
        int end = A.length;
        int targetPos = -1;
        
        while(start<end)
        {
            int mid = start + (end - start)/2;
            if(A[mid] == target) {
                targetPos = mid;
                break;
            }
            if(A[mid] < target)
                start = mid +1;        
            else 
                end = mid;
        }
        if(targetPos == -1)return ret;
        start = 0;
        end = targetPos + 1;
        while(start<end)
        {
            int mid = start + (end - start)/2;
            if(A[mid] == target && (mid ==0 ||  A[mid-1] != target))
            {
                ret[0] =mid;
                break;
            }
            if(A[mid] == target && A[mid-1] == target)
            {
                end = mid;
            }
            else if(A[mid] != target)
            {
                start = mid +1;
            }
        }
        
        end = A.length;
        start = targetPos;
        while(start<end)
        {
            int mid = start + (end - start)/2;
            if(A[mid] == target && (mid == A.length -1||  A[mid+1] != target))
            {
                ret[1] =mid;
                break;
            }
            if(A[mid] == target && A[mid+1] == target)
            {
                start = mid +1;
            }
            else if(A[mid] != target)
            {
                end = mid;
            }
        }
        return ret;

    }
}
