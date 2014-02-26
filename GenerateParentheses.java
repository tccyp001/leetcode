import java.util.ArrayList;


public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<String> ret = generateParenthesis(4);
        
        for(String str : ret)
        {
            System.out.println(str);
        }

	}
	public static ArrayList<String> generateParenthesis(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return generateParenthesisHelper(n, n,"");
        
    }
    public static ArrayList<String> generateParenthesisHelper(int leftPar, int rightPar, String current)
    {
        
        ArrayList<String> ret = new ArrayList<String>();
        if(leftPar == 0 && rightPar == 0) 
        {
        	 ret.add(current);
        	 return ret;
        }
        if(leftPar == 0)
        {
            ret = generateParenthesisHelper(leftPar, rightPar -1, current + ")");
            return ret;
        }
        
        
        
        
        ret = generateParenthesisHelper(leftPar -1, rightPar, current + "(");
        
        if(leftPar < rightPar)
        {
            ArrayList<String> ret2 = generateParenthesisHelper(leftPar, rightPar -1, current + ")");
            ret.addAll(ret2);
        }

        
        return ret;

    }
}
