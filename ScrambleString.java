import java.util.Arrays;


public class ScrambleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "abcd";
		String s2 = "bdac";
		boolean ret = isScramble(s1, s2);
		
		System.out.println(ret);
	}
	public static boolean isScramble(String s1, String s2) 
	{
		
		if(s1.equals(s2))return true;
		if(s1.length()!=s2.length())return false;
		if(!sortStr(s1).equals(sortStr(s2)))return false;
		
		for(int i = 0; i < s1.length() -1; i++)
		{
			String substr1Left = new String(s1.substring(0,i+1));
			String substr2Left = new String(s2.substring(0,i+1));
			String substr1Right = new String(s1.substring(i+1));
			String substr2Right = new String(s2.substring(i+1));
			
			String substr22Left = new String(s2.substring(0,s1.length() - i -1));
			String substr22Right = new String(s2.substring(s1.length() - i -1));
			
			if(isScramble(substr1Left,substr2Left) && isScramble(substr1Right, substr2Right))
				return true;
			
			if(isScramble(substr1Left,substr2Right) && isScramble(substr1Right, substr2Left))
				return true;
			
			if(isScramble(substr1Left,substr22Right) && isScramble(substr1Right, substr22Left))
				return true;
		}
		return false;
	}
	
	public static String sortStr(String str)
	{
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}

}
