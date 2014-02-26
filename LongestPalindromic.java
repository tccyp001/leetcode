
public class LongestPalindromic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("ccc"));
	}
	 public static String longestPalindrome(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int max = Integer.MIN_VALUE;
	        int len = 0;
	        if(s.length()<2)return s;
	        String retStr = "";
	        for(int i =0;i<s.length()-1;i++)
	        {
	            len = longestPalindromeSub(s, i, i);
	            if(len>max)
	            {
	                retStr = s.substring(i-len/2, i+len/2 +1);
	            }
	            len = longestPalindromeSub(s, i, i+1);
	            if(len>max)
	            {
	                retStr = s.substring(i+len/2 -1, i+len/2 +1);
	            }
	        }
	        return retStr;
	        
	        
	    }
	     public static int longestPalindromeSub(String s, int left, int right) {
	      while( s.charAt(left) == s.charAt(right))
	      {

	          left--;
	          right++;
	          if(left<0 || right> s.length()-1)break;
	      }
	        return right - left - 1;
	        
	    }
}
