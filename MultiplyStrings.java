
public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "1234";
		String s2 = "456";
		System.out.println(multiply(s1,s2));
	}
	
	 public static String multiply(String num1, String num2) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        int i = num2.length()-1;
	        int factor = 1;
	        String result = "";
	        while(i>=0)
	        {
	        	String ret = timesSingle(num1, (num2.charAt(i) - '0')*factor);
	        	factor *=10;
	        	result = add(ret, result);
	        	i--;
	        }
	        return result;
	    }
	public static String timesSingle(String num1, int c)
	{
		
		int i = num1.length() -1;
		
		int carry = 0;
		int result = 0;
		StringBuilder sb = new StringBuilder();
		while(i>=0)
		{
			result = (num1.charAt(i) - '0')*c + carry;
			carry = result /10;
			result = result %10;
			sb.insert(0, result);
			i--;
		}
		if(carry>0)sb.insert(0, carry);
		return sb.toString();
	}
    public static String add(String num1, String num2)
    {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        int cur1 = 0;
        int cur2 = 0;
        int result = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0||j>=0)
        {
            cur1 = i>=0?num1.charAt(i) - '0':0;
            cur2 = j>=0?num2.charAt(j) - '0':0;
            result = cur1 + cur2 + carry;
            carry = result/10;
            result = result %10;
            sb.insert(0, result);

            i--;
            j--;
        }
		if(carry>0)sb.insert(0, carry);
        return sb.toString();
    }
}
