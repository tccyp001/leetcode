import java.util.Arrays;


public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "msboaguwnnyqxnzlgdgwpbtrwblnsadeuguumoqcdrubetokyxhoachwdvmxxrdryxlmndqtukwagmlejuu";
		
	    String s2 = "ryxlmndqtukwag";
	    int len2 = lengthOfLongestSubstring(s);
	//	int len = lengthOfLongestSubstring2(s);
		//System.out.println(len);
	    
	    int len3 = lengthOfLongestSubstringWrong("acbdcea");
	    
	    
	    String s4 = "qopubjguxhxdipfzwswybgfylqvjzhar";
	    int len4 = lengthOfLongestSubstring3(s4);
		System.out.println(len4);
		//System.out.println(s2.length());
		//System.out.println(s.substring(63,77));
	//	System.out.println(s.substring(63,77).length());
		
		//System.out.println(s.substring(18,34));
	}
	
	public static int lengthOfLongestSubstring3(String s) {
        int[] map = new int[256];
        int maxLen = 0;
        int start = 0;
        for(int i = 0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(map[c] >0)
            {
                maxLen = Math.max(maxLen, i - start);
                map[start] = 0;
                while(s.charAt(start) != c) map[s.charAt(start++)] = 0;
                start++;
                   
            }
            map[c]++;
        }
        return Math.max(maxLen,s.length() - start);
    }
	 public static int lengthOfLongestSubstring2(String s) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        
	        
		        int map[] = new int[256];
		        for(int i =0; i<256; i++)
		        {
		            map[i] =-1;
		        }
		        int maxLength = 0;
		        int lastLength =0;
		        int endPos = 0;
		        String maxStr = "";
		        for(int i = 0; i<s.length();i++)
		        {
		            char c = s.charAt(i);
		            if(map[c]>=0)
		            {
		               if(i-map[c] > lastLength)
		               {
		                   
		                   lastLength ++;
		                   if(lastLength > maxLength) 
		                	   {
		                	   endPos= i;
		                	   	maxLength = lastLength;

		                	   }
		               }
		               else
		               {
		                   lastLength = i - map[c];
		               }
		               
		            }
		            else
		            {
		                 lastLength ++;
		                 if(lastLength > maxLength) 
		                	 {
		                	 endPos= i;
		                	 	maxLength = lastLength;

		                	 }
		            }
		            map[c] = i;
		        }
		        System.out.println(endPos);
		        return maxLength;
	    }
    public static int lengthOfLongestSubstring(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s.length()==0)return 0;    
        int[] map = new int[256];
        Arrays.fill(map,-1);
        int start = 0;
        int max = 0;
        for(int i = 0;i<s.length();i++)
        {
            if(map[s.charAt(i)]==-1)
            {
                map[s.charAt(i)] =i ;
                if(max<i-start +1)
                {
                		max = i -start +1;
                		//maxStr = s.substring(start, i+2);
                }
                
            }
            else
            {
            	if(start<map[s.charAt(i)] +1)
            	{
                    start = map[s.charAt(i)] +1;
            	}
            	else
            	{
            		if(max<i-start +1)
                    {
                    		max = i -start +1;
                    		//maxStr = s.substring(start, i+2);
                    }
            	}
            }
        	map[s.charAt(i)] = i;
        }
       // System.out.println(maxStr);
       // System.out.println(maxStr.length());
        return max;
        
    
    }
    public static int lengthOfLongestSubstringWrong(String s)  
    {
    	if(s.length()==0)return 0;    
        int[] map = new int[256];
        Arrays.fill(map,-1);
        int start = 0;
        int max = 0;
        for(int i = 0;i<s.length();i++)
        {
            if(map[s.charAt(i)]==-1)
            {
                map[s.charAt(i)] =i ;
                if(max<i-start +1)
                	{
                		max = i -start +1;
                	}
                
            }
            else
            {
            	if(start<map[s.charAt(i)] +1)
            	{
                    start = map[s.charAt(i)] +1;
            	}
            	map[s.charAt(i)] = i;

            }
        }
        return max;
        
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(l1==null)return l2;
        if(l2==null)return l1;
        
        ListNode ret = new ListNode(0);
        ListNode cur = ret;
        int carry = 0;
        int val1 = 0;
        int val2 = 0;
        while(l1!=null || l2!=null)
        {
        	val1=  (l1==null)? 0: l1.val;
        	val2=  (l2==null)? 0: l2.val;
         
            ListNode node1 = new ListNode((val1+val2 + carry)%10);
            carry = (val1+val2 + carry)/10;
            cur.next = node1;
            cur = cur.next;

            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;
        }
        if(carry==1)
        {
            ListNode node = new ListNode(carry);
            cur.next = node;
        }
        return ret.next;
    
    }

}
