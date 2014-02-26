
public class editDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ret =  minDistance("zoo", "zoo");
       System.out.println(ret);
      // ret =  minDistance2("zoologicoarchaeologist", "zoogeologist");
       ret =  minDistance2("zoo", "zoo");
	}
	 public static int minDistance2(String word1, String word2) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(word1.length() ==0)return word2.length();
	        if(word2.length() ==0)return word1.length();
	        int [][] dp = new int[word1.length()+1][word2.length()+1];
	        int max = word1.length() + word2.length();
	        for(int i =0;i<word2.length()+1;i++)
	        {
	            dp[0][i] = i;
	        }
	        for(int i =0;i<word1.length()+1;i++)
	        {
	            dp[i][0] = i;
	        }
	        dp[0][0] = 0;
	        int min = 0;
	        for(int i =1;i<word1.length()+1;i++)
	        {
	            for(int j =1;j<word2.length()+1;j++)
	            {
	                min = max;
	                if(dp[i-1][j-1]<min) min = dp[i-1][j-1];
	                if(dp[i][j-1]<min) min = dp[i][j-1];
	                if(dp[i-1][j]<min) min = dp[i-1][j];
	                
	                if(word1.charAt(i-1) != word2.charAt(j-1)) min++;
	                
	                dp[i][j] = min;
	                   
	            }
	        }
	        printMatrix(dp);
	        return dp[word1.length()][word2.length()];
	    }
	 public static void printMatrix(int[][] dp)
	 {
	      for(int i = 0; i<dp.length;i++)
	        {
	        	for(int j =1;j<dp[0].length;j++)
	            {
	        		System.out.print(dp[i][j] + "  ");
	            }
	        	System.out.println();
	        }
	 }
	 public static int minDistance(String word1, String word2) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(word1.length() ==0)return word2.length();
	        if(word2.length() ==0)return word1.length();
	        int [][] dp = new int[word1.length()+1][word2.length()+1];
	        int max = word1.length() + word2.length();
	        for(int i =0;i<word2.length()+1;i++)
	        {
	            dp[0][i] = i;
	        }
	        for(int i =0;i<word1.length()+1;i++)
	        {
	            dp[i][0] = i;
	        }

	        dp[0][0] = 0;
	        int min = 0;
	        for(int i =1;i<word1.length()+1;i++)
	        {
	            for(int j =1;j<word2.length()+1;j++)
	            {
	            	if(word1.charAt(i-1) == word2.charAt(j-1))dp[i][j] = dp[i-1][j-1];
	            	else
	            	{
		                min = max;
		                if(dp[i-1][j-1]<min) min = dp[i-1][j-1];
		                if(dp[i][j-1]<min) min = dp[i][j-1];
		                if(dp[i-1][j]<min) min = dp[i-1][j];
		                
		                
		                
		                dp[i][j] = min+1;
	            	}

	                   
	            }
	        }
	        printMatrix(dp);
	        return dp[word1.length()][word2.length()];
	    }
}
