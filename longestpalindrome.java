import java.util.ArrayList;


public class longestpalindrome {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ccc";
		String ret = longestPalindrome(str);
		System.out.println(ret);

	}
	 public static String longestPalindrome(String s) {
	        int max = 0;
	        String strMax = "";
	        for(int i=0;i<s.length()-1;i++)
	        {
	            if(max<getLen(s,i,i))
	            {
	                max = getLen(s,i,i);
	                strMax = s.substring(i-max/2, i + max/2+1);
	            }
	            if(max<getLen(s,i,i+1))
	            {
	                max = getLen(s,i,i+1);
	                strMax = s.substring(i-max/2 +1, i +max/2+1);
	            }
	        }
	        return strMax;
	    }
	    public static int getLen(String s, int lstart, int rstart)
	    {
	        while(lstart>=0 && rstart<s.length())
	        {
	            if(s.charAt(lstart) == s.charAt(rstart))
	            {
	                lstart--;
	                rstart++;
	            }
	            else break;
	        }
	        return rstart - lstart -1;
	    }
}
