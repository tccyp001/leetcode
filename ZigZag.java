
public class ZigZag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING",3));
	}
    public static String convert(String s, int nRows) {
        
        
        int sLen = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int cycle = nRows*2 -2;
        while(i<nRows)
        {
            int index = i;
            while(index <sLen)
            {
                if(i==0||i==nRows-1)sb.append(s.charAt(index));
                else
                {
                    sb.append(s.charAt(index));
                    if(index+ cycle-2*i<sLen)
                    	sb.append(s.charAt(index+ cycle-2*i));
                }
                index+=cycle;
            }
            i++;
        }
        return sb.toString();
    }
 public String convert2(String s, int nRows) {
        
        if(nRows <= 1) return s;
        if(s.length()==0)return s;
        
        int cycle = nRows * 2 -2;
        StringBuilder sb = new StringBuilder();
        for(int j = 0;j<nRows;j++)
        {
            for(int i = 0; i<s.length(); i+=cycle)
            {
                if(j==0 && i< s.length()) sb.append(s.charAt(i));
                
                else if(j==nRows-1 && i+j < s.length())sb.append(s.charAt(i+j));
                else
                {
                    if(i +j <s.length()) sb.append(s.charAt(i+j));
                    if(i + cycle - j  <s.length()) sb.append(s.charAt(i + cycle - j));
                }
            }
        }
        return sb.toString();

    }
}
