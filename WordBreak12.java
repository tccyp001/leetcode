import java.util.HashSet;
import java.util.Set;


public class WordBreak12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		//dict.add("a");
		dict.add("leet");
		dict.add("code");
		
		WordBreak12 ins = new WordBreak12();
		boolean ret = ins.wordBreak("leetcode1", dict);
		System.out.println(ret);
	}
	 public boolean wordBreak(String s, Set<String> dict) {
	        if(s.length()==0)return false;
	        boolean[] dp = new boolean[s.length()+1];
	        dp[0] = true;
	        for(int i = 1;i<s.length()+1;i++)
	        {
	            for(int j = 0;j<i;j++)
	            {
	                if(dp[j])
	                {
	                    String tmp = s.substring(j,i); 
	                    if(dict.contains(tmp))
	                        dp[i] = true;
	                }
	            }
	        }
	        return dp[s.length()];
	    }
}
