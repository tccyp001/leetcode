
public class DecodeWay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("01"));
	}
	 public static int numDecodings(String s) {
	        if(s==null || s.isEmpty())return 0;
	        if(s.length()==1 &&!s.equals("0"))return 1;
	        else if (s.startsWith("0"))return 0;
	        int[] f = new int[s.length()+1];
	        f[0]=1;
	        f[1]=1;

	        
	        for(int i=2;i<=s.length();i++)
	        {
	            if(isValidNum(s.substring(i-1,i)))
	                f[i]+=f[i-1];
	            if(isValidNum(s.substring(i-2,i)))
	                f[i]+=f[i-2];
	        }
	        return f[s.length()];
	    }
	    public static boolean isValidNum(String str)
	    {
	        if (str.startsWith("0"))return false;
	        if(Integer.parseInt(str)<=26&&Integer.parseInt(str)>0)return true;
	        return false;
	    }
}
