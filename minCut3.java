
public class minCut3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "aa";
		String a = s.substring(2);
		minCut("cabababcbc");
	}
    public static int minCut(String s) {
        if(s.length()<=1)return 0;
        int[] f = new int[s.length()];
        boolean[][] h = new boolean[s.length()][s.length()];
        for(int i = 0;i<s.length();i++)
        {
            f[i] = i;
            for(int j=i;j>=0;j--)
            {
                if((i-j<2 || h[j+1][i-1]) && s.charAt(j) == s.charAt(i))
                {
                    h[j][i] = true;
                    if(j == 0)
                    	f[i] =0;
                    else f[i] =  Math.min(f[i],f[j-1] +1);
                }

            }
        }
        return f[s.length()-1];
    }
}
