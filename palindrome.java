
public class palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        boolean ret = isPalindrome("A man, a plan, a canal: Panama.");
        System.out.println(ret);
	}
	public static boolean isPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s.isEmpty()) return true;
        s = s.toLowerCase();
        int end = s.length()-1;
        int start = 0;
        while(start<end)
        {
        	while(end>start&&!((s.charAt(end)>='a' && s.charAt(end)<='z')||
        			(s.charAt(end)>='A' && s.charAt(end)<='Z')||
        			(s.charAt(end)>='0' && s.charAt(end)<='9')))
        	{
        		end--;
        	}
        	while(start<end&&!((s.charAt(start)>='a' && s.charAt(start)<='z')||
        			(s.charAt(start)>='A' && s.charAt(start)<='Z')||
        			(s.charAt(start)>='0' && s.charAt(start)<='9')))
        	{
        		start++;
        	}
        	if(s.charAt(start)!=s.charAt(end))
        	{
        		return false;
        	}
        	start++;
        	end--;
        }
        return true;
    }
}
