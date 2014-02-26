import java.util.ArrayList;
import java.util.HashMap;


public class SubstringWithAllWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "barfoothefoobarman";
		String[] L = {"foo", "bar"};
		
		//String S = "a";
		//String[] L = {"a"};
		SubstringWithAllWord ins = new SubstringWithAllWord();
		ArrayList<Integer> ret = ins.findSubstring(S, L);
		OutputHelper.printArrInt(ret);
	}
	 public ArrayList<Integer> findSubstring(String S, String[] L) {
			ArrayList<Integer> ret = new ArrayList<Integer>();
			if(L.length ==0)return ret;
			int wordLen = L[0].length();
			int count = 0;
			HashMap<String,Integer> need = new HashMap<String,Integer>();
			HashMap<String,Integer> found = new HashMap<String,Integer>();
			for(String s : L)
			{
			    if(need.containsKey(s))need.put(s,need.get(s)+1);
			    else need.put(s, 1);
			}
			for(int i = 0;i<wordLen;i++)
			{
				int start = i;
				int end = i+wordLen;
				found.clear();
				count = 0;
			    while(end<S.length()+wordLen||count == L.length)
			    {
			    	if(count == L.length)
			    	{
			    		if(end - wordLen -start==L.length * L[0].length())
			    		{
			    			ret.add(start);
			    		}
			    		String tmp = S.substring(start,start+wordLen);
			    		if(getCountFromMap(found,tmp)==getCountFromMap(need,tmp))
			    		{
			    			count--;
			    		}
		    			decreaseMapVal(found,tmp);
		    			start+=wordLen;
			    	}
			    	else
			    	{
			    		if(end >S.length())break;
				    	String tmp = S.substring(end-wordLen,end);
				        if(getCountFromMap(found,tmp) < getCountFromMap(need,tmp))
				        {
				        	count++;
				        }
			        	increaseMapVal(found,tmp);
				        end+=wordLen;
			    	}

			    }
			}
	        return ret;
	    }
	 	public int getCountFromMap(HashMap<String,Integer> map, String key)
	 	{
	 		if(!map.containsKey(key))return 0;
	 		else return map.get(key);
	 	}
	 	public void increaseMapVal(HashMap<String,Integer> map, String key)
	 	{
	 		if(!map.containsKey(key))map.put(key, 1);
	 		else map.put(key,map.get(key)+1);
	 	}
	 	public void decreaseMapVal(HashMap<String,Integer> map, String key)
	 	{
	 		if(!map.containsKey(key))map.put(key, 0);
	 		else map.put(key,map.get(key)-1);
	 	}
}
