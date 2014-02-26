
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs ={"abc","abc","abc"};
		System.out.println(longestCommonPrefix(strs));
	}
    public static String longestCommonPrefix(String[] strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int min = Integer.MAX_VALUE;
        
        if(strs.length==0)return "";
        if(strs.length==1)return strs[0];
        for(String str:strs)
        {
            if(str.length()<min)
            {
                min = str.length();
            }
        }
        int i =0;
        boolean isContinue = true;
        for(i =0;i<min;i++)
        {

            char c = strs[0].charAt(i);
            for(int j =1;j<strs.length;j++)
            {
                if(strs[j].charAt(i)!=c)
                {
                    isContinue = false;
                    break;
                }
            }
            if(!isContinue)break;
        }
        return strs[0].substring(0,i);
        
    }
}
