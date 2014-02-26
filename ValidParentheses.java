import java.util.Stack;


public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isValid("]");
	}
	 public static boolean isValid(String s) {
		 Stack<Character> stack = new Stack<Character>(); 
		 for(int i =0;i<s.length();i++)
	        {
	        	char c = s.charAt(i);
	        	if(c=='('||c=='{'||c=='[')
	        	{
	        		stack.push(c);
	        	}
	        	if(c==')')
	        	{
	        		if(stack.empty() ||stack.peek()!='(')
	        		return false ;
	        		else stack.pop();
	        	}
	        	if(c=='}')
	        	{
	        		if(stack.empty() ||stack.peek()!='{')
	        		return false ;
	        		else stack.pop();
	        	}
	        	if(c==']')
	        	{
	        		if(stack.empty() ||stack.peek()!='[')
	        		return false ;
	        		else stack.pop();
	        	}

	        }
	        if(!stack.empty())return false;
	        return true;
	        		
	    }
}
