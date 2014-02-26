import java.util.ArrayList;
import java.util.HashSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
public class WordLadder23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
        HashMap<String, HashSet<String>> neighbours = new HashMap<String, HashSet<String>>();
		 dict.add(start);
		 dict.add(end);
		 for(String str : dict){  
	            calcNeighbours(neighbours, str, dict);  
	     } 
        
        while(!parentQue.isEmpty())
        {
        	for(String str : parentQue)
		    {
		         visited.add(str);
		    }
            String cur = parentQue.remove();
            if(neighbours.containsKey(cur))
			{
			    for(String tmp : neighbours.get(cur))
				{
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
     private  void  calcNeighbours(HashMap<String, HashSet<String>> neighbours, String str, HashSet<String> dict) {
        int length = str.length();
        char [] chars = str.toCharArray();
        for (int i = 0; i < length; i++) {
            
            char old = chars[i]; 
            for (char c = 'a'; c <= 'z'; c++) {

                if (c == old)  continue;
                chars[i] = c;
                String newstr = new String(chars);                
                
                if (dict.contains(newstr)) {
                    HashSet<String> set = neighbours.get(str);
                    if (set != null) {
                        set.add(newstr);
                    } else {
                        HashSet<String> newset = new HashSet<String>();
                        newset.add(newstr);
                        neighbours.put(str, newset);
                    }
                }                
            }
            chars[i] = old;
        }
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
