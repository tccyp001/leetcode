
public class RegMatch11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "aaaaaaaaaaaaab";
        String p = "a*a*a*a*a*a*a*a*a*a*c";
        System.out.println(isMatch(s,p));
	}
	 public static boolean isMatch(String s, String p) {
		 if(s.length()>0 && p.length()==0)return false;
	        
	        if(s.length()==0 && p.length()>0)
	        {
	            if(p.length()>1 && p.charAt(1) == '*') 
	               return isMatch(s, p.substring(2));
	            else return false;
	        }
	        if(s.equals(p))return true;
	        if(s.charAt(0) == p.charAt(0) || p.charAt(0) =='.')
	        {
	            if(p.length()>1 && p.charAt(1) == '*')
	              return isMatch(s.substring(1), p)  || isMatch(s, p.substring(2));
	            else 
	              return isMatch(s.substring(1), p.substring(1));
	        }
	        else
	        {
	            if(p.length()>1 && p.charAt(1) == '*') 
	               return isMatch(s, p.substring(2));
	            else return false;
	        }
	        
	    }
}
