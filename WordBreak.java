import java.util.Set;


public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public boolean wordBreak(String s, Set<String> dict) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	       if(s == null || dict == null) return false;
	       if(s.isEmpty())return false;
	       boolean[] dp = new boolean[s.length()+1];
	       dp[s.length()] = true;
	        for(int i = s.length()-1;i>=0;i--)
	        {
	            for(int j = i+1;j<s.length()+1;j++)
	            {
	                String sub = s.substring(i,j);
	                if(dict.contains(sub) && dp[j]) dp[i]=true;
	            }

	        }
	        return dp[0];
	        
	    }
}
