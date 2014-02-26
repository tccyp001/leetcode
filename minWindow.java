
public class minWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow1("ADOBECODEBANC","ABC"));
	}
    public static String minWindow1(String S, String T) {
        
        int[] need = new int[256];
        int[] found = new int[256];
        for(int i=0;i<T.length();i++)
        {
            need[T.charAt(i)]++;
        }
        int end = 0;
        int start = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        String minStr = "";
        while(true)
        {
            if(count==T.length())
            {
                if(min>end-start+1)
                {
                	min = end-start+1;
                	minStr = S.substring(start,end);
                }
                if(found[S.charAt(start)]<=need[S.charAt(start)])
                {
                    count--;
                }
                found[S.charAt(start)]--;
                start++;
            }
            else
            {	
            	if(end==S.length())break;
                if(found[S.charAt(end)]<need[S.charAt(end)])
                {
                    count++;
                }
                found[S.charAt(end)]++;
                end++;
            }
        }
        return minStr;
    }
}
