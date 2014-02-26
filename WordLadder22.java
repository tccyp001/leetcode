import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class WordLadder22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// will time out on LC
		HashSet<String> dic = new HashSet<String>();
		dic.add("hot");
		dic.add("dot");
		dic.add("dog");
		dic.add("lot");
		dic.add("log");
		WordLadder22 ins = new WordLadder22();
		ArrayList<ArrayList<String>> ret = ins.findLadders("hit", "cog", dic);
		OutputHelper.printArrArrStr(ret); 
	}
	   public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
	        
	        
	        HashMap<String, ArrayList<String>> rPath = new HashMap<String, ArrayList<String>>();
	        
	        Queue<String> parentQue = new LinkedList<String>();
	        Queue<String> childQue = new LinkedList<String>();
	        StringBuilder sb = new StringBuilder();
	        parentQue.offer(start);
	        HashSet<String> visited = new HashSet<String>();
	        boolean isFound = false;
	        while(!parentQue.isEmpty())
	        {
	        	for(String str : parentQue)
			    {
			         visited.add(str);
			    }
	            String cur = parentQue.remove();
	            for(int i =0;i<cur.length();i++)
	            {
	                sb.setLength(0);
	                sb.append(cur);
	                for(int j =0;j<26;j++)
	                {
	                    sb.setCharAt(i,(char)(j+'a'));
	                    String tmp = sb.toString();
	                    if(tmp.equals(end))
	                    {
	                        if(!rPath.containsKey(tmp))rPath.put(tmp, new ArrayList<String>());
	                        rPath.get(tmp).add(cur);
	                        isFound = true;
	                    }
	                    else if((!visited.contains(tmp) && dict.contains(tmp)))
	                    {
	                        childQue.add(tmp);
	                        if(!rPath.containsKey(tmp))rPath.put(tmp, new ArrayList<String>());
	                        rPath.get(tmp).add(cur);
	                    }
	                }
	             }
	             
	             if(parentQue.isEmpty())
	             {
	            	 if(isFound)break;
	                 Queue<String> tmp = childQue;
	                 childQue = parentQue;
	                 parentQue = tmp;
	             }
	            
	        }
	        if(isFound) return builderPath(rPath,end,start);
	        return new ArrayList<ArrayList<String>>();
	    }
	    public ArrayList<ArrayList<String>> builderPath(HashMap<String, ArrayList<String>> rPath, String end, String start)
	    {
	        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
	        ArrayList<String> path = new ArrayList<String>();
	        path.add(end);
	        builderPathDFS(rPath,end,start,path,ret);
	        return ret;
	        
	    }
	    public void  builderPathDFS(HashMap<String, ArrayList<String>> rPath, String end, String start,ArrayList<String> path, ArrayList<ArrayList<String>> ret)
	    {
	        if(start.equals(end))ret.add(new ArrayList<String>(path));
	        
	        if(!rPath.containsKey(end))return;
	        for(String key : rPath.get(end))
	        {
	            path.add(0,key);
	            builderPathDFS(rPath,key, start, path, ret);
	            path.remove(0);
	        }
	    }
}
