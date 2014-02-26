import java.util.Stack;


public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/..") );
	}
	public static String simplifyPath(String path) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String s : strs)
        {
        	if(s.isEmpty())continue;
        	if(s.equals("."))continue;
        	if(s.equals("..")&&!stack.isEmpty())stack.pop();
        	else stack.push(s);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
        	sb.insert(0, stack.pop());
        	sb.insert(0, "/");
        }
        String retStr =  sb.toString();
        if(retStr.isEmpty())return "/";
        else return retStr;
    }
}
