import java.util.ArrayList;


public class restoreIP2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> ret = restoreIpAddresses("010010");
		for(String str:ret)
		{
			System.out.println(str);
		}
	}
	public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> path = new ArrayList<String>();
        ArrayList<String> ret = new ArrayList<String>();
        restoreSub(s, 4,  path, ret);
        return ret;
    }
    public static void restoreSub(String str, int leftPart,  ArrayList<String> path, ArrayList<String> ret)
    {
        if(str.length()>leftPart*3 || str.length()<leftPart)return;
        if(leftPart == 0)
        {
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<path.size();i++)
            {
                if(i!=0)sb.append(".");
                sb.append(path.get(i));
            }
            ret.add(sb.toString());
        }
        
        for(int i =1;i<=Math.min(str.length(), 3);i++)
        {
            String substr = str.substring(0,i);
            if(!isValueIpPart(substr))continue;
            path.add(substr);
            restoreSub(str.substring(i), leftPart-1, path, ret);
            path.remove(path.size()-1);
        }
        
        
    }
    public static boolean isValueIpPart(String str)
    {
    	if(str.length()>1&&str.startsWith("0"))return false; 
        int val = Integer.parseInt(str);
        if(val>=0&&val<=255)return true;
        return false;
    }
}
