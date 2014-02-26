import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class WordBreak22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s = "catsanddog";
		String s = "b";
		Set<String> dict = new  HashSet<String>();
		dict.add("a");
		/*dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");*/
		WordBreak22 ins = new WordBreak22();
		ArrayList<String> ret = ins.wordBreak(s,dict);
		
		OutputHelper.printArrString(ret);
 
	}
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		HashMap<Integer,ArrayList<Integer>> nextList = new HashMap<Integer,ArrayList<Integer>>();
		ArrayList<String> ret = new ArrayList<String>();
		ArrayList<String> path = new ArrayList<String>();
		wordBreakDP(nextList, dict, s);
		getResultDFS(ret, path, s, nextList, 0); 
        return ret;
    }
    public void wordBreakDP(HashMap<Integer,ArrayList<Integer>> nextList, Set<String> dict, String s)
    {
       int len = s.length();
       boolean[] dp = new boolean[len+1];
       dp[len] = true;
       for(int i = len-1;i>=0;i--)
       {
    	   for(int j = i+1;j<=len;j++)
    	   {
    		   String tmp = s.substring(i,j);
    		   if(dp[j] && dict.contains(tmp))
    		   {
    			   	dp[i] = dp[j];
    			   	if(!nextList.containsKey(i))nextList.put(i, new ArrayList<Integer>());
    			   	nextList.get(i).add(j);
    		   }
    	   }
       }
    }
    public void getResultDFS(ArrayList<String> ret, ArrayList<String> path, String s,  HashMap<Integer,ArrayList<Integer>> nextList, int start) 
    {
    	if(start == s.length())
    	{
    		StringBuilder sb = new StringBuilder();
    		for(String s1: path)
    		{
    			sb.append(s1);
    			sb.append(" ");
    		}
    		ret.add(sb.toString().trim());
    		return;
    	}
    	if(!nextList.containsKey(start))return;
    	for(Integer i : nextList.get(start))
    	{
    		String tmp = s.substring(start,i);
    		path.add(tmp);
    		getResultDFS(ret, path,s,nextList,i);
    		path.remove(path.size()-1);
    	}
    }
}
