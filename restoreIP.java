import java.util.ArrayList;


public class restoreIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> ret = restoreIpAddresses("010010");
		for(String str:ret)
		{
			System.out.println(str);
		}
	}
    public static ArrayList<String> restoreIpAddresses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
         return retoreIPSub(s,4);
    }
    public  static ArrayList<String> retoreIPSub(String s, int sec)
    {
        ArrayList<String> ret = new ArrayList<String>();
        if(sec==1)
        {
            if(isValidPart(s))
            {
                 ret.add(s);
            }
              
            return ret;
        }
        
        int max = 3;
        if(s.length()<3) max = s.length()-1;
        for(int i=0;i<max;i++)
        {
            String left = s.substring(0,i+1);
            if(isValidPart(left))
            {
                String right = s.substring(i+1);
                ArrayList<String> subret = retoreIPSub(right,sec-1);
                if(!subret.isEmpty())
                {
                    for(String str: subret)
                    {
                        ret.add(left+"." +str);
                    }
                }
                
            }
        }
        return ret;
        
    }
    public static boolean isValidPart(String s)
    {
        if(s.length()>3)return false;
        if(s.length()==0)return false;
        if(s.length()>1 && s.charAt(0) =='0')return false;
        int sum = 0;
        for(int i =0;i<s.length();i++)
        {
           sum = sum*10;
           sum+= s.charAt(i) - '0';
        }
        if(sum>255 || sum<0) return false;
        return true;
    }
}
