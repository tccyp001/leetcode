import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class wordDic {
	public static HashMap<String, List<String>> cache= new HashMap<String, List<String>>();
	public static HashSet<String> dic =new HashSet<String>(Arrays.asList("cat","cats", "and", "sand", "dog")) ;
	public static void getSolution(){
		String strTest = "catsanddog ";
		
		List<String> retList = breakWord(strTest);
		for(String str : retList)
		{
			System.out.println(str);
		}
		
		
	};
	public static List<String> breakWord(String input)
	{
		if(cache.containsKey(input)) return cache.get(input);

		List<String> retList = new ArrayList<String>();
		for(int i = 0 ;i<input.length();i++)
		{
			String strSubLeft = input.substring(0, i+1);
			if(dic.contains(strSubLeft))
			{
				if(i == input.length()-1) retList.add(strSubLeft);
				else
				{
					String strSubRight = input.substring(i+1);
					List<String> retSubList = breakWord(strSubRight);
					for(String str : retSubList)
					{
						retList.add(strSubLeft + " " + str);
					}
				}
			}
		}
		cache.put(input, retList);
		return retList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getSolution();
	}

}
