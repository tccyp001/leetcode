import java.util.Stack;


public class SimplifyPath2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		simplifyPath("/");
	}
	public static String simplifyPath(String path) {
        String[] strs = path.split("/");
        if(strs.length ==0) return "/";
        Stack<String> stack = new Stack<String>();
        
        for(int i =0;i<strs.length;i++)
        {
            if(strs[i].trim().isEmpty())continue;
            else if(strs[i].trim().equals(".."))
            {
                if(!stack.isEmpty())stack.pop();
            }
            else if(strs[i].trim().equals("."))continue;
            else stack.push(strs[i]);
        }
        String ret = "";
        while(!stack.isEmpty())
        {
            ret+="/" + stack.pop();
        }
        if(ret.isEmpty())return "/";
        return ret;
    }
}
