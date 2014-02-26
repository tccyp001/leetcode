
public class RegExpression2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isMatch("ab",".*c"));
	}
    public static boolean isMatch(String s, String p) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        return isMatchSub(s,p,0,0);
        
    }
     public static boolean isMatchSub(String s, String p, int index1, int index2)
     {
         if(index1 == s.length() && index2 == p.length()) return true;
             
         if(index1<s.length() && index2 == p.length()) return false;
         
     	 if(s.substring(index1).equals(p.substring(index2)))return true;
     	 
     	 if(index1<s.length()&&index2<p.length()&&s.charAt(index1) == p.charAt(index2)) 
 		 {
     		 if(index2<p.length()-1 && p.charAt(index2 +1) =='*')
     			 return isMatchSub(s,p, index1+1, index2+2) || isMatchSub(s,p, index1+1, index2);
     		 else
     			return isMatchSub(s,p, index1+1, index2+1);
 		 }
     	 
     	 if(p.charAt(index2) == '.' && index2<p.length()-1 && p.charAt(index2 +1) =='*')
     	    return isMatchSub(s,p, index1+1, index2+2) ||isMatchSub(s,p, index1+1, index2);
     	 else if(p.charAt(index2) == '.')
     	    return isMatchSub(s,p, index1+1, index2+1);
     	 else 
     	    return false;
    	 
     }
}
