
public class SearchSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {7,8,1,2,3,4,5,6};
		search(input,2);
	}
	public static int search(int[] A, int target) {
        int start = 0;
        int end = A.length;
        int mid = 0;
        while(start<end)
        {
            mid = start + (end - start)/2;
            if(A[mid] == target) return mid;
            if((A[mid] > A[start] && A[mid] > target && A[start]<=target) ||
               (A[mid]<A[start] && A[start]<=target)) end = mid;
            else start = mid +1;
            
        }
        return -1;
    }
}
