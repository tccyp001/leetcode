import java.util.Stack;


public class InterLeave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterLeave ins = new InterLeave();
		boolean ret = ins.isInterleave("aabcc","dbbca","aadbbcbcac");
        Stack<Character> stack = new Stack<Character>();
		System.out.println(ret);
	}
	public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() ==0)return s2.equals(s3);
        if(s2.length() ==0)return s1.equals(s3);
        
        if(s1.length()+s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        
        dp[0][0] = true;           
        
        for(int i =0;i<s1.length()+1;i++)
        {
            for(int j = 0;j<s2.length()+1;j++)
             {
            	if(i==0 && j ==0)continue;
                dp[i][j] = (i==0? false :(s1.charAt(i-1) == s3.charAt(j + i -1) && dp[i-1][j])) 
                            || (j==0?false:s2.charAt(j-1) == s3.charAt(j + i-1) && dp[i][j-1]) ;
             }
        }
        return dp[s1.length()][s2.length()];
        
    }
}
