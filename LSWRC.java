
public class LSWRC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("bbbbb"));
	}
	public static int lengthOfLongestSubstring(String s) {
        int[] d = new int[256];

        int left = 0, right =0;
        int max = 0;
        while(right<s.length())
        {
        	
        	if(d[s.charAt(right)]==0)
			{
				d[s.charAt(right)]++;
				right++;
				max = Math.max(max, right - left);
			}
        	else
        	{
        		d[s.charAt(left)]--;
        		left ++;
        	}
        }
        return max;
    }
    public String addBinary(String a, String b) {
        if(a.length()==0)return b;
        if(b.length()==0)return a;
        
        int aEnd = a.length() -1;
        int bEnd = b.length() -1;
        
        int carry  =0;
        StringBuilder sb = new StringBuilder();
        while(aEnd>=0 || bEnd>=0)
        {
            int vala = aEnd>=0?(a.charAt(aEnd) -'0'):0;
            int valb = bEnd>=0?(b.charAt(bEnd) -'0'):0;
            
            int val = vala + valb + carry;
            carry = val /2;
            val = val %2;
            sb.insert(0,val);
            aEnd --;
            bEnd --;
        }
        if(carry!=0)
        {
        
            sb.insert(0,carry);
        }
        return sb.toString();
    }
}
