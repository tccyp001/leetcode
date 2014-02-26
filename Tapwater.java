
public class Tapwater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,0,2};
		int ret = trap(input);
		System.out.println(ret);
	}
	 public static int trap(int[] A) {
	        if(A.length == 0)return 0;
	        
	        int[] leftMax = new int[A.length];
	        int[] rightMax = new int[A.length];
	        leftMax[0] = 0;
	        rightMax[A.length-1] =0;
	        int curLeftMax = 0;
	        int curRightMax = 0;
	        for(int i = 0;i<A.length;i++)
	        {
	            leftMax[i] = curLeftMax;
	            rightMax[A.length - i -1] = curRightMax;
	            curLeftMax = Math.max(curLeftMax, A[i]);
	            curRightMax = Math.max(curRightMax, A[A.length - i -1]);
	        }
	        
	        
	        int sum = 0;
	        for(int i =0;i<A.length;i++)
	        {
	        	if(Math.min(leftMax[i],rightMax[i]) - A[i]>0)
	            sum+= Math.min(leftMax[i],rightMax[i]) - A[i];
	        }
	        return sum;
	        
	    }
}
