import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[1];
		arr[0] =1;
		
		int a = 13;
		int b = a&1;
		System.out.print(b);
		//System.out.println(intToRoman(2766));
		
	//	System.out.println(romanToInt("MMDCCLXVI"));
		int[] numbers = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		
		for(int m:numbers)
		{
			System.out.println(m);
		}
		for(int i = 1 ;i<4000;i++)
		{
			System.out.print("\"" + intToRoman(i) + "\",");
		}
		//System.out.println(arr[0]);
		String ss = "bbb";
		testStr(ss);
		System.out.println(ss);
	}
	public static void testStr(String s)
	{
		s+="aaa";
	}
	public static String intToRoman(int num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        String[] strs = {"M","CM", "D", "CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] numbers = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        StringBuilder sb = new StringBuilder();
        sb.deleteCharAt(index)
        
        int index = 0;
        int count = 0;
        while(num>0)
        {
        	count++;
            if(num>=numbers[index])
            {
                num-=numbers[index];
                sb.append(strs[index]);
            }
            else
            {
                index++;
            }
            if(num==0) break;
        }
        

        
        return  sb.toString();
    }
	public static int romanToInt(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        String[] strs = {"M","CM", "D", "CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] numbers = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        HashMap<String,String> map = new HashMap<String,String>();
        StringBuilder sb = new StringBuilder();
        
        int index = 0;
        int result = 0;
        while(s.length()>0)
        {
            if(s.startsWith(strs[index]))
            {
            	result+=numbers[index];
            	s = s.substring(strs[index].length());
            }
            else
            {
            	index++;
            }
        }
        return result;
    }
}
