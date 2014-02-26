import java.util.ArrayList;


public class RestoreIPAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIPAddresses instance = new RestoreIPAddresses();
		ArrayList<String> ret = instance.restoreIpAddresses("25525511135");
		for(String str : ret)
		{
			System.out.println(str);
		}
		
	}
	public ArrayList<String> restoreIpAddresses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> path = new ArrayList<String>();
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        retoreIPSub(s,0,4,path,ret);
        return mergeStrArr(ret);
    }
    public ArrayList<String> mergeStrArr(ArrayList<ArrayList<String>> arrlist)
    {
        ArrayList<String> ret = new ArrayList<String>();
        for(ArrayList<String> subarr:arrlist)
        {
            String tmp = "";
            boolean isFirst = true;
            for(String s : subarr)
            {
                if(isFirst)
                {
                    isFirst = false;
                    tmp+= s;
                }
                else
                {
                    tmp= tmp + "." +s;
                }
                
            }
            ret.add(tmp);
        }
        return ret;
    }
    public void retoreIPSub(String s, int start, int leftparts, ArrayList<String> path,ArrayList<ArrayList<String>> ret)
    {
        if(start == s.length())
        {
        	if(leftparts==0)
        		ret.add(new ArrayList<String>(path));
            return;
        }
        int maxRight = Math.min(start+4,s.length());
        for(int i = start+1; i<=maxRight;i++)
        {
            String substr = s.substring(start, i);
            if(isValidPart(substr))
            {
                path.add(substr);
                retoreIPSub(s, i,leftparts-1, path,ret);
                path.remove(path.size()-1);
            }
        }
        
    }
    public boolean isValidPart(String s)
    {
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
