
public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("1","111"));
		int m =3;
		if((m&0x01) ==1)
	}
	 public static String addBinary(String a, String b) {
		    int carry = 0;
	        if(a.length()<b.length())
	        {
	            String tmp = a;
	            a = b;
	            b = tmp;
	        }
	        int indexa = a.length()-1;
	        int indexb = b.length()-1;
	        StringBuilder sb = new StringBuilder();
	        while(indexb>=0)
	        {
	            int cur = a.charAt(indexa) - '0' + b.charAt(indexb) -'0' + carry;
	            sb.insert(0, cur%2);
	            carry = cur/2;
	            indexa --;
	            indexb --;
	        }
	        while(indexa>=0)
	        {
	             int cur = a.charAt(indexa) - '0' + carry;
	             sb.insert(0, cur%2);
	             carry = cur/2;
	             indexa--;
	        }
	        if(carry ==1)
	        {
	            sb.insert(0, "1");
	        }
	        return sb.toString();
	    }
}
