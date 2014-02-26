
public class CountSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String str = countAndSay(5);
       System.out.println(str);
	}
	 public static String countAndSay(int n) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        int[] tmp = new int[10];
	        String str = "1";
	        for(int i=0;i<n-1;i++)
	        {
	            str = getCountStr(str,tmp);
	        }
	        return str;
	    }
	    public static String getCountStr(String str, int[] tmp)
	    {
	    	if(str.length()==0)return "";
	    	int index = 1;
	    	int count = 1;
	    	char lastChar = str.charAt(0);
	        StringBuilder sb = new StringBuilder();
	    	while(index<str.length())
	    	{
	    		if(lastChar!=str.charAt(index))
	    		{
	    			sb.append(Integer.toString(count));
	    			sb.append(lastChar);
	    			lastChar = str.charAt(index);
	    			count =1;
	    		}
	    		else
	    		{
	    			count++;
	    		}
	    		index++;
	    	    	
	    	}
	    	sb.append(Integer.toString(count));
			sb.append(lastChar);
			
	
	        return sb.toString();
	    }
}
