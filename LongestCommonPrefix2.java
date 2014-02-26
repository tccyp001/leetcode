
public class LongestCommonPrefix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"a","b"};
		System.out.println(longestCommonPrefix(strs));
	}
	  public static String longestCommonPrefix(String[] strs) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(strs.length==0)return "";
	        int min =strs[0].length();
	        for(int i =1;i<strs.length;i++)
	        {
	            if(strs[i].length()<min)min = strs[i].length();
	        }
	        char c;
	        int k = 0;
	        for(k=0;k<min;k++)
	        {
	            c = strs[0].charAt(k);
	            for(int j = 0;j<strs.length;j++)
	            {
	               if(c!=strs[j].charAt(k)) return strs[0].substring(0,k);
	            }
	        }
	        return strs[0].substring(0,k);
	    }
}
