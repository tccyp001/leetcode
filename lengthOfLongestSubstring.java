
public class lengthOfLongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ret = lengthOfLongestSubstring("abcabcbddbac");
		System.out.println(ret);
	}
	 public  static int lengthOfLongestSubstring(String s) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        
	        int map[] = new int[256];
	        for(int i =0; i<256; i++)
	        {
	            map[i] =-1;
	        }
	        int maxLength = 0;
	        int lastLength =0;
	        
	        for(int i = 0; i<s.length();i++)
	        {
	            char c = s.charAt(i);
	            if(map[c]>=0)
	            {
	               if(i-map[c] > lastLength)
	               {
	                   
	                   lastLength ++;
	                   if(lastLength > maxLength) maxLength = lastLength;
	               }
	               else
	               {
	                   lastLength = i - map[c];
	               }
	               
	            }
	            else
	            {
	                 lastLength ++;
	                 if(lastLength > maxLength) maxLength = lastLength;
	            }
	            map[c] = i;
	        }
	        return maxLength;
	    }
}
