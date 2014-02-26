import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class WordLadder2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> dic = new HashSet<String>();
		dic.add("hot");
		dic.add("dot");
		dic.add("dog");
		dic.add("lot");
		dic.add("log");
		
		
		//dic.add("hit");
		
		//dic.add("cog");
		
		ArrayList<ArrayList<String>> ret = findLadders("hit", "cog", dic);
		
		
		for(ArrayList<String> sublist : ret)
		{
			for(String str: sublist)
			{
				System.out.print(str+"  ,");
			}
			System.out.println();
		}
	}
	 public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
		 	 ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
	         if(dict.size()<2)return ret;
			 Queue<String> queueParent = new LinkedList<String>();
			 Queue<String> queueChild = new LinkedList<String>();
			 HashSet<String> visited = new HashSet<String>();
			 HashMap<String,ArrayList<String>> parent = new HashMap<String,ArrayList<String>>();
			 queueParent.add(start);
			 visited.add(start);
			 HashMap<String, HashSet<String>> neighbours = new HashMap<String, HashSet<String>>();
			 dict.add(start);
			 dict.add(end);
			 for(String str : dict){  
		            calcNeighbours(neighbours, str, dict);  
		     } 

			 boolean isFound = false;
			 while((!queueParent.isEmpty() || !queueChild.isEmpty()) && !isFound)
			 {
			     for(String str : queueParent)
			     {
			         visited.add(str);
			     }
	        
				 for(String str : queueParent)
			     {
					 
					 if(neighbours.containsKey(str))
					 {
						 for(String next : neighbours.get(str))
						 {
							 if(end.equals(next))
		                	 {
		                		 isFound= true;
		                	 }
		                	 if((!visited.contains(next) && dict.contains(next))||next.equals(end))
		                	 {
		                		 if(!parent.containsKey(next))
		                		 {
		                			 ArrayList<String> sublist = new ArrayList<String>();
		                			 parent.put(next,sublist);
		                		 }
		                	     parent.get(next).add(str);
		                		 queueChild.add(next);
		     
		                	 }
						 }
					 }
			     }

				 Queue<String> tmp = queueParent;
				 queueParent= queueChild;
				 queueChild = tmp;
				 queueChild.clear();

			 }
			 if(!isFound) return ret;
			 ArrayList<String> curPath = new ArrayList<String>();
			 return buildPath(parent, curPath, start, end);

	    }
	  /*
	     * complexity: O(26*str.length*dict.size)=O(L*N)
	     */
	    private  static void  calcNeighbours(HashMap<String, HashSet<String>> neighbours, String str, HashSet<String> dict) {
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
	    private static ArrayList<ArrayList<String>> buildPath( HashMap<String,ArrayList<String>> parent, ArrayList<String> curPath, String start, String end)
	    {
	    	 ArrayList<ArrayList<String>> ret = new  ArrayList<ArrayList<String>>();

	    	 curPath.add(0,end);
	    	 if(start.equals(end)) 
    		 {
    		 	ret.add(new ArrayList<String>(curPath));
    		 	curPath.remove(0);
    		 	return ret;
    		 }


	    	 for(String str : parent.get(end))
	    	 {
	    		 ArrayList<ArrayList<String>> subret = buildPath( parent, curPath, start, str);
	    		 ret.addAll(subret);
	    	 }
	    	 
	    	 curPath.remove(0);
	    	 
	    	 return ret;
	    	 
	    	 
	    }
}
