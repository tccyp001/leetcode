
public class RemoveDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1};
		int ret = removeDuplicates(input);
		System.out.print(ret);
	}
	 public static int removeDuplicates(int[] A) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        if(A.length<=1) return A.length;
	        String str ="aa";

	        int p1 = 1;
	        int p2 = 1;
	        while(p2<A.length)
	        {
	            if(A[p2]==A[p2-1]) p2++;
	            else
	            {
	                 A[p1++] = A[p2++];
	            }
	        }
	        return p1;
	    }
}
