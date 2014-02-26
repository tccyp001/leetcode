import java.util.Arrays;
import java.util.PriorityQueue;


public class ScrambleString2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScrambleString2 ins = new ScrambleString2();
		boolean ret = ins.isScramble("aab", "baa");
		String a = "a/a/a";
		char[] arr = a.toCharArray();
		 StringBuilder sb = new StringBuilder();
		 PriorityQueue<ListNode> pq = new  PriorityQueue<ListNode>();
		 
		System.out.println(arr.length);
		System.out.println(ret);
	}
	 public boolean isScramble(String s1, String s2) {
	        
	        if(s1.equals(s2))return true;
	        if(!isValid(s1,s2))return false;
	        int len = s1.length();
	        for(int i=1;i<s1.length();i++)
	        {
	            String sub1left = s1.substring(0,i);
	            String sub2left = s2.substring(0,i);
	            
	            String sub1right = s1.substring(i);
	            String sub2right = s2.substring(i);
	            
	            String sub1right2 = s1.substring(len-i);
	            String sub2right2 = s2.substring(i);
	            String sub1left2 = s1.substring(0, len-i);
	            String sub2left2 = s2.substring(0, i);
	            
	            if(isScramble(sub1left,sub2left) &&  isScramble(sub1right,sub2right)) return true;
	            if(isScramble(sub1left2,sub2right2) &&  isScramble(sub1right2,sub2left2)) return true;
	        }
	        return false;
	    }
	    public boolean isValid(String s1, String s2)
	    {
	        if(s1.length()!=s2.length())return false;
	        char[] arr1 = s1.toCharArray();
	        char[] arr2 = s2.toCharArray();
	        Arrays.sort(arr1);
	        Arrays.sort(arr2);
	        
	        for(int i = 0;i<arr1.length;i++)
	        {
	            if(arr1[i]!=arr2[i])return false;
	        }
	        return true;
	        
	    }
}
