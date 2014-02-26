
public class regMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "ab";
        String p = "*.c";
        System.out.println(isMatch2(s,p));
	}
	public static boolean isMatch(String s, String p) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        return isMatchSub(s,p,0,0);
        
    }
     public static boolean isMatchSub(String s, String p, int index1, int index2)
     {
    	 if(index1==s.length() )
    		 {
    		 if(index2 == p.length())
    			 return true; 
    		 else
    		 {
    			 if(index2+1<p.length() && p.charAt(index2+1) =='*' )
    			 {
    				 return isMatchSub(s, p, index1, index2+2) ;
    			 }
    			 else
    			 {
    				 return false;
    			 }
    		 }
    		 }
         if(index1<s.length() && index2 == p.length()) return false;

         if((index2+1) <p.length() && p.charAt(index2+1) =='*')
         {
             if(p.charAt(index2)!='.' && p.charAt(index2)!=s.charAt(index1))
             {
                return isMatchSub(s, p, index1, index2+2) ;
             }
             else
             {
                  return isMatchSub(s, p, index1+1, index2) || isMatchSub(s, p, index1, index2+2);
             }
         }
         else
         {
             if(p.charAt(index2)!='.'&& p.charAt(index2)!=s.charAt(index1)) return false;
             return isMatchSub(s, p, index1+1, index2+1);
         }
     }
     
     public static boolean isMatch2(String s, String p) {
         // Note: The Solution object is instantiated only once and is reused by each test case.
         
         return isMatchSub2(s,p,0,0);
         
     }
      public static boolean isMatchSub2(String s, String p, int index1, int index2)
      {
         if(index1 == s.length() && index2 == p.length()) return true;
          
         if(index1<s.length() && index2 == p.length()) return false;
          
     	 if(s.substring(index1).equals(p.substring(index2)))return true;
     	 
     	 if(s.charAt(index1) == p.charAt(index2)) 
 		 {
     		 if(index2<p.length()-1 && p.charAt(index2 +1) =='*')
     			 return isMatchSub2(s,p, index1+1, index2+2) || isMatchSub2(s,p, index1+1, index2);
     		 else
     			return isMatchSub2(s,p, index1+1, index2+1);
 		 }
     	 
     	 if(p.charAt(index2) == '.' && index2<p.length()-1 && p.charAt(index2 +1) =='*')
     	    return isMatchSub2(s,p, index1+1, index2+2) ||isMatchSub2(s,p, index1+1, index2);
     	 else if(p.charAt(index2) == '.')
     	    return isMatchSub2(s,p, index1+1, index2+1);
     	 else 
     	    return false;
      }
}
