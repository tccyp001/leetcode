
public class JumbGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,9,6,9,6,1,7,9,0,1,2,9,0,3};
		System.out.println(jump(A));
	}
	 public static int jump(int[] A) {
		 int result = 0;
		 int last = 0;
		 int n = A.length;
		 int cur = 0;
		 for (int i = 0; i < n; ++i) {
			 if (i > last) {
			 last = cur;
			 ++result;
			 }
			 cur = Math.max(cur, i + A[i]);
			 }
			 return result;
	    }
}
