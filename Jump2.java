
public class Jump2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {0,0,1,1,1};
		System.out.println(jump2(input));
	}
    public static  int jump(int[] A) {
        if(A.length<=1)return 0;
        
        int lastMaxRight = A[0];
        int step = 1;
        
        int index = 1;
        int maxRight = A[0];
        while(index<=maxRight)
        {
           
            maxRight = Math.max(maxRight, index + A[index]);
            if(maxRight>=A.length -1)return step+1;
            if(index == lastMaxRight)
            {
                lastMaxRight = maxRight;
                step++;
            }
            index++;
 
            
        }
        return -1;
        
    }
    public static int jump2(int[] A) {
        
        if(A.length <=1)return 0;
        int curLevelRight =0;
        int lastRight = 0;
        int steps = 0;
	       for(int i =0;i<A.length;i++)
	       {
	           if(i>lastRight)
	           {
	               steps++;
	               lastRight = curLevelRight;
	           }
	           curLevelRight = Math.max(curLevelRight, i+A[i]);
	           
	       }
	       return steps;
 }
}
