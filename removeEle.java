
public class removeEle {
	public static void main(String[] args) {
	   int[] input = {4,5};
	   int ret = removeElement(input,4);
	   System.out.println(ret);
	
	}
	 public static int removeElement(int[] A, int elem) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        String str="";
	        for(char c:str.toCharArray())
	        {
	        	
	        }
	        int index1 = A.length-1;
	        for(int i = 0;i<=index1;i++)
	        {
	            if(A[i]==elem)
	            {
	                int tmp = A[i];
	                A[i] = A[index1];
	                A[index1] = tmp;
	                i--;
	                index1--;
	                if(index1<0)break;
	            }

	        }
	        return index1+1;
	    }
}
