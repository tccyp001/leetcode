
public class SearchInsertPos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] input = {2,4,6,8,10};
        System.out.println(searchInsert(input,9));
	}
	 public static int searchInsert(int[] A, int target) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        if(A.length==0)return 0;
	        
	        int start = 0;
	        int end = A.length-1;
	        
	        while(start<=end)
	        {
	            int mid = start + (end -start)/2;
	            if(A[mid] == target) return mid;
	            if(A[mid]<target) 
	            {
	                start = mid+1;
	            }
	            else
	            {
	                end = mid-1;
	            }
	        }
	        return start;

	    }
}
