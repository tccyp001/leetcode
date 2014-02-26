
public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(3, 2));
	}
	 public static String getPermutation(int n, int k) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
		    StringBuilder sb = new StringBuilder();
		    int[] data = new int[n];
		    data[0]=1;
	        for(int i = 1;i<n;i++)
	        {
	        	data[i] = data[i-1]*(i); 
	        }
	        boolean[] used = new boolean[n];
	        
	        for(int i = n-1;i>=0;i--)
	        {
	        	int curDigit = 1;
	        //	if(k<data[i])continue;
	        	while(k>data[i])
	        	{
	        		curDigit++;
	        		k -=data[i];
	        	}
	        	for(int j = 0; j<n;j++)
	        	{
	        		
	        		if(!used[j])
        			{
	        			curDigit--;
	        			if(	curDigit==0)
	        			{
	          				sb.append(j+1);
	        				used[j]=true;
	        				break;
	        			}
      
        			}
	        		
	        	}
	        }
	        return sb.toString();
	        
	    }
}
