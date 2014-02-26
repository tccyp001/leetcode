import java.util.ArrayList;
import java.util.Stack;


public class PhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Character> s = new Stack<Character>();
		
		String input = "23";
		ArrayList<String> ret = letterCombinations(input);
		for(String str: ret)
		{
			System.out.println(str);
		}
	}
	public static ArrayList<String> letterCombinations(String digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		
		ArrayList<String> ret = new ArrayList<String>();
		if(digits.length()==0)
		{
			ret.add("");
			return ret;
		}

		ArrayList<String> subret =  letterCombinations(digits.substring(1));
    	int num = digits.charAt(0) - '0';
    	if(num <=1)return ret; 
    	int length = 3;
    	int start = (num -2) *3;
    	if(num>=8) start ++;
    	if(num==7 || num ==9)length++;
    	
    	for(String str :subret)
    	{
    		for(int i = 0;i<length;i++)
        	{
    		
        		char c = (char) (start + i + 'a');
        		String tmp = c + str ;
        		ret.add(tmp);
        	}
    	}
        return ret; 	
        
    }
}
