
public class MissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,2,-1,1};
		int ret = firstMissingPositive( A); 
		System.out.println(ret);
	}
    public static int firstMissingPositive(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A.length ==0)return 1;
        for(int i =0;i<A.length;i++)
        {
            if(A[i]-1>=0 && A[i]-1<A.length)
            {
                int tmp = A[i];
                A[i] =A[tmp-1] ;
                A[tmp-1] = tmp;
                if(A[i]-1>=0 && A[i]-1<A.length &&A[i]<tmp)
                     i--;
            }
        }
        for(int i = 0; i<A.length;i++)
        {
            if(A[i]!=(i+1)) return i+1;
        }
        return A.length+1;
    }
}
