import java.util.ArrayList;


public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		ArrayList<ArrayList<String>> ret = partition(s);
		for(ArrayList<String> arrList :ret)
		{
			for(String str :arrList)
			{
				System.out.print(str);
				System.out.print(",");
			}
			System.out.println();
		}
	}
	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> output = new ArrayList<String>();
		DFS(s,output,ret);
		return ret;
				
	}
	public  static void DFS(String s, ArrayList<String> output, ArrayList<ArrayList<String>> result)
    {
        if(s.isEmpty())
        {
            if(output.size()>0)result.add(new ArrayList<String>(output));
            return;
        }
        for(int i =0;i<s.length();i++)
        {
            if(isPalindrome(s.substring(0,i+1)))
            {
                output.add(s.substring(0,i+1));
                DFS(s.substring(i+1),output, result);
                output.remove(output.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s)
    {
        int start = 0;
        int end = s.length()-1;
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }

}
