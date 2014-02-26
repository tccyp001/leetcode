import java.util.Stack;


public class evalRPN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"3","-4","+"};
		evalRPN(input);
	}
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for(String s : tokens)
        {
            if(s.equals("+"))
            {
                if(stack.size()<2)return 0;
                int val2 = stack.pop();
                int val1 = stack.pop();
                int ret = val1+val2;
                stack.push(ret);
            }
            else if(s.equals("-"))
            {
                if(stack.size()<2)return 0;
                int val2 = stack.pop();
                int val1 = stack.pop();
                int ret = val1-val2;
                stack.push(ret);
            }
            else if(s.equals("*"))
            {
                if(stack.size()<2)return 0;
                int val2 = stack.pop();
                int val1 = stack.pop();
                int ret = val1*val2;
                stack.push(ret);
            }
            else if(s.equals("/"))
            {
                if(stack.size()<2)return 0;
                int val2 = stack.pop();
                int val1 = stack.pop();
                int ret = val1/val2;
                stack.push(ret);
            }
            else
            {
                int val = Integer.parseInt(s);
                stack.push(val);
            }
        }
        if(!stack.isEmpty())return stack.pop();
        return 0;
    }
}
