
public class removeDup2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,1,1};
		System.out.println(removeDuplicates(input));
		System.out.println("aa");
	}
    public static int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A.length<=2)return A.length;
        int p1 = 2;
        int p2 = 2;
        while(p2<A.length)
        {
            A[p1++] = A[p2++];
            if(A[p1-1] == A[p1-2] && A[p1-2] == A[p1-3])
            {
                p1--;
            }
           

        }
        return p1;
    }
}
