import java.util.Stack;


public class LargestRectangleinHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input ={2,1,5,6,2,3};
		//int[] input ={0};
		int ret = largestRectangleArea(input);
		
		System.out.println(ret);
	}
    public static int largestRectangleArea(int[] height) {
        if(height.length ==0)return 0;
        
        int[] input = new int[height.length+1];
        for(int i = 0;i<height.length;i++) input[i] = height[i]; // add 0 to the end
        int curMax = Integer.MIN_VALUE;
        
        Stack<Integer> stack = new Stack<Integer>();
        int posLast = 0;
        for(int i = 0;i<input.length;i++)
        {
            if(stack.isEmpty() ||input[stack.peek()]<input[i]) stack.push(i);
            
            else {
                while(!stack.isEmpty() && input[stack.peek()]>=input[i]) 
                {
                    posLast = stack.pop();
                    int stackPeekPos = stack.isEmpty()?-1:stack.peek();
                    curMax = Math.max((i-stackPeekPos-1)* input[posLast],curMax);
                }
                stack.push(i);
            }
        }
        return curMax;
    }
}
