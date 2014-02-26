
public class minCut2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minCut("bb");
	}
	 public static int minCut(String s) {
	        int len = s.length();
	        
	        boolean[][] isPal = new boolean[len][len];
	        int f[] = new int[len];
	        f[len-1]=1;
	        for(int i = len-2;i>=0;i--)
	        {
	            for(int j = i+1;j<len;j++)
	            {
	                if(j == i+1)f[i] = f[i+1]+1;
	                if(j-i<2 || (isPal[i+1][j-1] && s.charAt(i) == s.charAt(j)))
	                {
	                    isPal[i][j] = true;
	                    f[i] = Math.min(f[i], f[j]+1);
	                }
	            }
	        }
	        
	        return f[0]; 
	    
	    }
}
