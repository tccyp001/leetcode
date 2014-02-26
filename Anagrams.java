import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"and","dan"};
		ArrayList<String> ret = anagrams(strs);
		for(String str: ret)
			System.out.println(str);
	}
	public static ArrayList<String> anagrams(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> ret = new ArrayList<String>();
        if(strs.length == 0)return ret;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for(String str:strs)
        {
            String tmpStr = sortStr(str);
            if(!map.containsKey(tmpStr))
            {
                 ArrayList<String> arr = new ArrayList<String>();
                 map.put(tmpStr,arr);
            }
            ArrayList<String> arr = map.get(tmpStr);
            arr.add(str);
            
        }
        for(ArrayList<String> arr : map.values())
        {
            if(arr.size()>1){
            	ret.addAll(arr);

            }
        }
        return ret;
    }
	public double pow(double x, int n) {
        if(n==1)return x;
        if((n & 0x01) == 1) return x*pow(x,n-1);
        double v = pow(x,n>>1);
        return v*v;
    }
    public static String sortStr(String str)
    {
        char [] c = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
