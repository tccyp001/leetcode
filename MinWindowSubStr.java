
public class MinWindowSubStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "ADOBECODEBANC";
		String		T = "ABC";
		System.out.println(minWindow(S,T));
	}

    public static String minWindow(String S, String T) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    	if(S.length()==0)return"";
    	if(S.length()<T.length())return"";
        int[] expected = new int[256];
        int[] appeared = new int[256];
        
        for(int i = 0 ; i< T.length();i++)
        {
        	expected[T.charAt(i)]++;
        }
        int start = 0;
        //int end =0;
        int foundCnt = 0;
        int min = S.length()+1;
        int min_start = 0;
        //while(end<S.length())
        for(int end = 0; end< S.length(); end++)
        {
        	if(expected[S.charAt(end)]>0)
        	{
        		appeared[S.charAt(end)]++;
        		if(appeared[S.charAt(end)]<=expected[S.charAt(end)])
        		{
        	 		foundCnt++;
        		}
    
        	}
        	if(foundCnt == T.length())
        	{
        		while(appeared[S.charAt(start)]>expected[S.charAt(start)]
        				|| expected[S.charAt(start)]==0)
        		{
        			appeared[S.charAt(start)]--;
        			start++;
        		}
        		if(min> (end - start +1))
        		{
        			min =  end - start +1;
        			min_start = start;
        		}
        		
        	}
    		
        }
    
        
        
        if(min == S.length()+1)return "";
        else return S.substring(min_start, min_start+min);
        
    }

}
