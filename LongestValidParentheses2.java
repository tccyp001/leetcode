import java.util.Stack;


public class LongestValidParentheses2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int ret = longestValidParentheses2("()(())");
		int ret = longestValidParentheses2("())");
		System.out.println(ret);
	}
    public static int longestValidParentheses(String s) {
    	int[] dp = new int[s.length() +1];
        
        dp[0]=0;
        int max = 0;
        for(int i = 1;i<s.length()+1;i++)
        {
            int j = i - dp[i-1] -1;
            if(s.charAt(i-1) == ')' && j>0 && s.charAt(j-1) == '(')
            {
                dp[i] = dp[i-1]+2;
                if(j-2>0) dp[i]+=dp[j-1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
        
    }
    public static int longestValidParentheses2(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        
        
        for(int i = 0;i<s.length();i++)
        {
            if(s.charAt(i) == '(') stack.push(-1);
            else if(s.charAt(i) == ')')
            {
            	int len = 0;
            	while(!stack.isEmpty() && stack.peek() >=2)len +=stack.pop();
                if(!stack.isEmpty() && stack.peek()==-1)
                {
                    len += 2;
                    stack.pop();
                    while(!stack.isEmpty() && stack.peek() >=2)len +=stack.pop();
                    stack.push(len);
                }
                else 
                {
                	if(len>0)stack.push(len);
                	stack.push(-2);
                }
            }
        }
        int max = 0;
        while(!stack.isEmpty()) max = Math.max(max, stack.pop());
        return max;
        
    }
}
