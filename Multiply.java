
public class Multiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Multiply ins = new Multiply();
		String str = ins.multiply("6","501");
		System.out.println(str);
	}
    public String multiply(String num1, String num2) {
        if(num1 == ("0")||num2.equals("0"))return "0";
        if(num1=="1")return num2;
        if(num2=="1")return num1;
        
        boolean isNeg = false;
        if(num1.startsWith("-"))
        {
            num1 = num1.substring(1);
            isNeg = !isNeg;
        }
        if(num2.startsWith("-"))
        {
            num2 = num2.substring(1);
            isNeg = !isNeg;
        }
        int len = num1.length()+num2.length();
        int [] res = new int[len];
        
        for(int i =0;i<num1.length();i++)
        {
            for(int j =0;j<num2.length();j++)
            {
                int tmp = (num1.charAt(num1.length() - i -1) - '0') * (num2.charAt(num2.length() - j -1) - '0');
                res[len - i -j -1] +=tmp;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = res.length-1;
        int end = 0;
        while(end<res.length-1&&res[end]==0)end++;
        while(i>=end-1)
        {
        	sb.insert(0,(char)(res[i]%10 +'0'));
        	if(i>0)res[i-1] +=res[i]/10;
        	i--;
        	
        }
        if(sb.length()==0)sb.append("0");
        if(isNeg)sb.insert(0,"-");
        return sb.toString();
    }
}
