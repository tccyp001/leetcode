import java.util.Stack;


public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int len = longestValidParentheses("()(())");
       System.out.println(len);
	}
	 public static int longestValidParentheses(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(s.length()==0) return 0;
	        Stack<Character> stack = new Stack<Character>();
	        Stack<Integer> stack2 = new Stack<Integer>();
	        Stack<Integer> stack3 = new Stack<Integer>();
	        int i = Integer.MAX_VALUE
	        int maxLen = 0;

	        for(int i=0;i<s.length();i++)
	        {
	            if(s.charAt(i) ==')'&&!stack.isEmpty() && stack.peek() =='(')
	            {
	            	stack.pop();
	            	stack2.pop();
	            	int len = 2;
	            	while(!stack2.isEmpty() && stack2.peek() >0)
	            	{
	            		len+=stack2.pop();
	            	}
	            	stack2.push(len);

	            }
	            else
	            {
	                stack.push(s.charAt(i));
		            stack2.push(-1);
	            }
	
	            
	        }
	        while(!stack2.isEmpty())
	        {
	        	int len = stack2.pop();
	        	if(len>maxLen)maxLen = len;
	        }
	        
	        return maxLen;
	    }
}
