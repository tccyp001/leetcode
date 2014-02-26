
public class minWindow2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minWindow2 ins = new minWindow2();
		String str = ins.minWindow("acbbaca", "aba");
		System.out.println(str);
	}
	  public String minWindow(String S, String T) {
	        
	        if(S.isEmpty())return "";
	        if(S.length()<T.length())return "";
	        int[] need = new int[256];
	        int[] found = new int[256];
	        for(int i=0;i<T.length();i++)
	        {
	            need[T.charAt(i)]++;
	        }
	        int end = 0;
	        int start = 0;
	        int count = 0;
	        int min_len = Integer.MAX_VALUE;
	        int min_start = 0;
	        String minStr = "";
	        
	        for(int i = 0;i<S.length();i++)
	        {
	            if(found[S.charAt(i)]<need[S.charAt(i)])count++;
	            found[S.charAt(i)]++;
	            
	            if(count == T.length())
	            {
	                while(need[S.charAt(start)]==0 || found[S.charAt(start)]> need[S.charAt(start)])
	                {
	             
	                    found[S.charAt(start)]--;
	                    start ++;
	                }
	                if(i - start + 1 <min_len)
	                {
	                    min_len = i - start +1;
	                    min_start = start;
	                }
	            }
	            
	        }
	        if(min_len == Integer.MAX_VALUE)return "";
	        return S.substring(min_start, min_start + min_len);
	    }
}
