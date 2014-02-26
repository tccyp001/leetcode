import java.util.ArrayList;
import java.util.HashMap;


public class RestoreIPAddresses2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIPAddresses instance = new RestoreIPAddresses();
		//ArrayList<String> ret = instance.restoreIpAddresses("25525511135");
		ArrayList<String> ret = instance.restoreIpAddresses("11111");
		for(String str : ret)
		{
			System.out.println(str);
		}
		
		HashMap<String, ArrayList<String>> map = HashMap<String, ArrayList<String>>();
	}
	public ArrayList<String> restoreIpAddresses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        String path = "";
        ArrayList<String> ret = new ArrayList<String>();
        retoreIPDFS(s,0,4,path,ret);
        return ret;
    }
	public void retoreIPDFS(String s, int start, int leftparts, String path,ArrayList<String> ret)
	{
		if(leftparts==0 && start == s.length())
		{
			ret.add(path.substring(path.length()-1));//remove last '.'
		}
		if(s.length() - start < leftparts) return;
		if(s.length() - start > leftparts *3)return;
		int num = 0;
		for(int i = 0;i<=3;i++)
		{
			char c = s.charAt(start + i);
			num*= 10;
			num+= c - '0';
			if(num<=255)
				retoreIPDFS(s, start +i+1, leftparts -1, path + num + '.', ret);
			if(num==0)break;
		}
		
	}
}
