
public class ZigZag2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("twckwuyvbihajbmhmodminftgpdcbquupwflqfiunpuwtigfwjtgzzcfofjpydjnzqysvgmiyifrrlwpwpyvqadefmvfshsrxsltbxbziiqbvosufqpwsucyjyfbhauesgzvfdwnloojejdkzugsrksakzbrzxwudxpjaoyocpxhycrxwzrpllpwlsnkqlevjwejkfxmuwvsyopxpjmbuexfwksoywkhsqqevqtpoohpd",4));
	}
	 public static String convert(String s, int nRows) {
	        StringBuilder sb = new StringBuilder();
	        if(nRows==1)return s;
	        for(int j = 0;j<nRows;j++)
	        {
	            for(int i = 0;i<s.length();i++)
	            {
	                int index = i%(2*nRows-2);
	                if(index == j || index == 2*nRows-2 - j)
	                {
	                   sb.append(s.charAt(i));
	                   
	                }
	            }
	        }
	        return sb.toString();
	    }
}
