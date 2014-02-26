import java.util.ArrayList;
import java.util.Arrays;


public class phoneNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutputHelper.printArrString(letterCombinations("23"));
	}
	public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> charList = new ArrayList<String>(Arrays.asList("","", "abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"));
        ArrayList<String> ret = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        letterComSub(digits,charList,path,ret);
        return ret;
        
    }
    public static void letterComSub(String digits, ArrayList<String> charList, StringBuilder path, ArrayList<String> ret)
    {
        if(digits.length() ==0)
        {
            ret.add(path.toString());
            return;
        }
        int index = digits.charAt(0) - '0';
        String str = charList.get(index);
        
        for(char c : str.toCharArray())
        {
            path.append(c);
            letterComSub(digits.substring(1),charList,path,ret);
            path.deleteCharAt(path.length() -1);
        }
    }
}
