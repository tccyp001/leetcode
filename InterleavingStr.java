import java.util.Stack;


public class InterleavingStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "aabccabc";
		String str2 = "dbbabc";
		String str3 = "aabdbbccababcc";
		
		boolean ret = isInterleave(str1,str2,str3);
		System.out.println(ret);
	}
	public static boolean isInterleave(String s1, String s2, String s3) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
       int targetLen = s1.length()+s2.length();
       if(targetLen!=s3.length())return false;
       if(s1.length()==0)return s2.equals(s3);
       if(s2.length()==0)return s1.equals(s3);
       
       boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
       
       
       
       for(int i =0;i<s1.length();i++)
       {
         dp[i+1][0] =  s1.charAt(i)==s3.charAt(i);
       }
       for(int j =0;j<s2.length();j++)
       {
         dp[0][j+1] =  s2.charAt(j)==s3.charAt(j);
       }
       
       if(dp[1][0] ==false&&dp[0][1]==false)return false; //fisrt one is not same
       
       for(int i =1;i<s1.length()+1;i++)
       {
    	   for(int j=1;j<s2.length()+1;j++)
    	   {
    		   dp[i][j] = (dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1)) ||  (dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
    	   }
       }
       return dp[s1.length()][s2.length()];
       
	}
	public static boolean isInterleave2(String s1, String s2, String s3) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        Stack<Integer> s = new Stack<Integer>();
        if(s1.length()+s2.length()!=s3.length())return false;
        
        s.push(p1);
        s.push(p2);
        s.push(p3);
        
        
        while(!s.isEmpty())
        {
        	p3 = s.pop();
        	p2 = s.pop();
        	p1 = s.pop();
        	
        
	        while(p1<s1.length()&&p2<s2.length()&&p3<s3.length())
	        {
	        	 if(s1.charAt(p1) == s3.charAt(p3)&&s2.charAt(p2) == s3.charAt(p3))
	             {
	        		 s.push(p1);
	        		 s.push(p2+1);
	        		 s.push(p3+1);
	        		 p1++;
	        		 p3++;
	             }
	        	 else if(s1.charAt(p1) == s3.charAt(p3))
	            {
	            	
	            	p1++;
	            	p3++;
	            }
	            else if(s2.charAt(p2) == s3.charAt(p3))
	            {
	            	p2++;
	            	p3++;
	            }
	            else 
	            {
	            	if(s.isEmpty())
	            	return false;
	            	else
	            		break;
	            }
	        }
	        
	        while(p1<s1.length())
	        {
	        	if(s1.charAt(p1) != s3.charAt(p3))
	            {
	        		if(s.isEmpty())
	        		return false;
	        		else
	            		break;
	            }
	           	p1++;
	        	p3++;
	        }
	        while(p2<s2.length())
	        {
	        	if(s2.charAt(p2) != s3.charAt(p3))
	            {
	        		if(s.isEmpty())
	        		return false;
	        		else
	            		break;
	            }
	           	p2++;
	        	p3++;
	        }
        }
        return true;
    }
}
