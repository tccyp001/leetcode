import java.util.HashSet;


public class Chapter1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Q1();
		//Test();
		//Q4();
		 Q5();
	}
	static void  Q1()
	{
		String inputStr1 = "abcdefa";
		String inputStr2 = "abcdef";
		boolean ret = isUniqueChar(inputStr1);
		System.out.println(ret);
		ret = isUniqueChar(inputStr2);
		System.out.println(ret);
		return;
		
	}
	static boolean  isUniqueChar(String str)
	{
		HashSet<Character> hs = new HashSet<Character>();
		for(char c :str.toCharArray())
		{
			if(hs.contains(c)) return false;
			else hs.add(c);
		}
		return true;
	}
	static void  Test()
	{
		HashSet<Character> hs = new HashSet<Character>();
		Character c1 = new Character('c');
		Character c2 = new Character('c');
		hs.add(c1);
		boolean ret = hs.contains(c2);
		System.out.println(ret);
	}
	static void  Q2()
	{
		//reverse string should be in c
	}
	static void  Q4()
	{

		String str = "i am Tiger    ";
		
		char[] arr = str.toCharArray();
		int len = arr.length;
		System.out.println(str);
		
		int oldEnd = arr.length -1;
		while(arr[oldEnd] == ' ')
		{
			oldEnd --;
		}
		
		int newEnd = arr.length -1;
		
		while (oldEnd >=0)
		{
			if(arr[oldEnd] == ' ')
			{
				arr[newEnd--]= '0';
				arr[newEnd--]= '2';
				arr[newEnd]= '%';
			}
			else
			{
				arr[newEnd] = arr[oldEnd];
			}
			newEnd--;
			oldEnd--;
		}
		System.out.println(arr);
	}
	
	static void  Q5()
	{
		String str = "aabbbbccd";
		StringBuilder sb = new StringBuilder();
		
		char lastChar = str.charAt(0);
		int count =0;
		for(char c:str.toCharArray())
		{
			if(c == lastChar)
			{
				count ++;
			}
			else
			{
				sb.append(lastChar);
				sb.append(count);
				count =1;
				lastChar = c;
			}
		}
		
		sb.append(lastChar); /// pay attention
		sb.append(count);
		
		if(sb.length()>str.length())
		{
			System.out.println(str);
		}
		else
		{
			System.out.println(sb.toString());
		}
		
		
		
	}
	
}
