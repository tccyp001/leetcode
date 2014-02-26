
public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("ab","*a"));
		System.out.println(isMatch("cabab","*ab"));
		System.out.println(isMatch("aa","aa"));
		System.out.println(isMatch("aaa","aa"));
		System.out.println(isMatch("aa","*"));
		System.out.println(isMatch("aa","a*"));
		System.out.println(isMatch("ab","?*"));
		System.out.println(isMatch("aab","c*a*b"));
		
	}

	 public static boolean isMatch(String s, String p) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		 
		 
		    int sPos = 0;
		    int pPos = 0;
		    int lastSPos = -1;
		    int lastPPos = -1;
		    while(sPos<s.length())
		    {
		    	if(pPos<p.length())
		    	{
			    	if(s.charAt(sPos) == p.charAt(pPos)||p.charAt(pPos) == '?'){sPos++;pPos++; continue;}
			    	if(p.charAt(pPos) =='*'){lastSPos= sPos;lastPPos = pPos++; continue;}
		    	}

		    	

			    if(lastPPos>=0){ pPos = lastPPos+1; sPos = ++lastSPos;continue;}
			    return false;

		    }

		    while(pPos<p.length())
		    {
		    	if(p.charAt(pPos)!='*')return false;
		    	pPos++;
		    			
		    }

	        return true;
	        

	    }
}
