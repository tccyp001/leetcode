import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class TestSTDin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ArrayList<String> arrList = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine())
		{
			arrList.add(in.nextLine());
		}	
		if(arrList.size()<3)return;
		//printBuz(Integer.parseInt(arrList.get(0)));
		
		String line2 = arrList.get(1);
		String line3 = arrList.get(2);
		String[] arrStrs = line2.split(" ");
		if(arrStrs.length!=3)return;
		
		int K = Integer.parseInt(arrStrs[0]);
		int L = Integer.parseInt(arrStrs[1]);
		int M = Integer.parseInt(arrStrs[2]);
*/
	
		//int output = findFreq(line3,K,L,M);

		int output = findFreq("abceabcdabccab",3,4,3);
		System.out.println(output);
	}
	public static int  findFreq(String s, int K, int L, int M)
	{
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		ArrayList<Integer> ret =new ArrayList<Integer>();
		
		for(int len = K;len<=L;len++)
		{
			for(int i = 0 ;i<=s.length() - len;i++)
			{
				String substr = s.substring(i,i+len);
				if(isValid(substr,M))
				{
					if(!map.containsKey(substr))
					{
						map.put(substr, 1);
					}
					else
					{
						map.put(substr, map.get(substr)+1);
					}
				}
			}
		}
		int max = 0;
		for(int i :map.values())max = Math.max(max, i);
		
		return max;
		
	}
	public static boolean isValid(String s, int M)
	{
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		int count =0;
		for(int i = 0;i<arr.length;i++)
		{
			if(i>0&&arr[i]==arr[i-1])continue;
			count++;
		}
		if(count>M)return false;
		return true;
	}
	public static void printBuz(int ival)
	{
		for(int i = 0;i<ival;i++)
		{
			if(i%3==0&&i%5==0)
			{
				System.out.println("FizzBuzz");
			}
			else if(i%3==0)
			{
				System.out.println("Fizz");
			}
			else if(i%3==0)
			{
				System.out.println("Fizz");
			}
			else
			{
				System.out.println(i);
			}
		}
	}
}
