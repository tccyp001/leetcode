import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class WordLadder1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> dict = new HashSet<String>();
	/*	dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");*/
		dict.add("hot");
		dict.add("dog");
		dict.add("dot");
        int ret = ladderLength4("hot","dog", dict);
        //int ret = ladderLength("hit","cog", dict);
        System.out.println(ret);
	}
    public static int ladderLength4(String start, String end, HashSet<String> dict) {
        
        HashSet<String> vistied = new HashSet<String>();
        Queue<String> queueParent = new LinkedList<String>();
        Queue<String> queueChild = new LinkedList<String>();
        queueParent.add(start);
        vistied.add(start);
        StringBuilder sb = new StringBuilder();
        int step = 1;
        while(!queueParent.isEmpty())
        {
            String cur = queueParent.remove();
            sb.setLength(0);
            sb.append(cur);
            for(int i = 0;i<cur.length();i++)
            {
                for(int j=0;j<26;j++)
                {
                    sb.setCharAt(i, (char)('a'+j));
                    String newStr = sb.toString();
                    if(newStr.equals(end))
                    	return step+1;
                    if(!vistied.contains(newStr) && dict.contains(newStr))
                    {
                        queueChild.add(newStr);
                        vistied.add(newStr);
                    }
                }
            }
            if(queueParent.isEmpty())
            {
                Queue<String> tmp = queueChild;
                queueChild = queueParent;
                queueParent = tmp;
                step++;
            }
        }
        return 0;
    }
	 public static int ladderLength(String start, String end, HashSet<String> dict) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
		 if(dict.size()<2)return 0;
		 Queue<String> queueParent = new LinkedList<String>();
		 Queue<String> queueChild = new LinkedList<String>();
		 HashSet<String> visited = new HashSet<String>();
		 
		 String curS = start;
		 queueParent.add(start);
		 visited.add(start);
		 
		 int depth = 1;
		 while(!queueParent.isEmpty() || !queueChild.isEmpty())
		 {
			 curS = queueParent.remove();

			 for (int i = 0; i < curS.length(); i++) {
                 StringBuffer sb = new StringBuffer(curS);
                 for (int j = 0; j < 26; j++) {
                	 sb.setCharAt(i, (char) ('a'+j));
                	 String next = sb.toString();
                	 if(end.equals(next))
                	 {
                		 return depth +1;
                	 }
                	 if(!visited.contains(next) && dict.contains(next))
                	 {
                		 queueChild.add(next);
     			    	 visited.add(next);
                	 }
                 }
             }
			
			 if(queueParent.isEmpty())
			 {
				 depth++;
				 Queue<String> tmp = queueParent;
				 queueParent= queueChild;
				 queueChild = tmp;
				 queueChild.clear();
			 }
		 }
		 
		 return 0;
		 
		 
/*
			int index=0,startIndex =0, endIndex =0;
			
			int arrSize = dict.size()+2;
			int[][] dp = new int[arrSize][arrSize];
			int i =0;
			int j =0;
			for(String str1:dict)
			{
				j=0;
				for(String str2:dict)
				{
					dp[i][j] = isNextStr(str1,str2);
					j++;
				}
				dp[i][arrSize-1] =  isNextStr(start,str1);
				dp[i][arrSize-2] =  isNextStr(end,str1);
				dp[arrSize-1][i] =  isNextStr(start,str1);
				dp[arrSize-2][i] =  isNextStr(end,str1);
				i++;
	
				
			}
			dp[arrSize-1][arrSize-1] = Integer.MAX_VALUE;
			dp[arrSize-2][arrSize-2] = Integer.MAX_VALUE;
			dp[arrSize-1][arrSize-2] = Integer.MAX_VALUE;
			dp[arrSize-2][arrSize-1] = Integer.MAX_VALUE;
			startIndex = arrSize-2;
			endIndex = arrSize -1;


			HashSet<Integer> visited = new HashSet<Integer>();
			visited.add(startIndex);
			
			while(visited.size()<arrSize)
			{
				int minDis = Integer.MAX_VALUE;
				int minIndex = -1;
				for(int i1 =0;i1<arrSize;i1++)
				{
					if(!visited.contains(i1) && dp[startIndex][i1]<minDis)
					{
						minDis = dp[startIndex][i1];
						minIndex = i1;
					}
					
				}
				if(minIndex == -1) return 0;
				
				visited.add(minIndex);
				for(int i1 =0;i1<arrSize;i1++)
				{
					if(!visited.contains(i1))
					{
						if(dp[minIndex][i1]< Integer.MAX_VALUE && dp[startIndex][i1] > dp[startIndex][minIndex] + dp[minIndex][i1])
						{
							dp[startIndex][i1] = dp[startIndex][minIndex] + dp[minIndex][i1];
						}
					}

				}
				if(dp[startIndex][endIndex]<Integer.MAX_VALUE)return dp[startIndex][endIndex]+1;
			}
			if(dp[startIndex][endIndex] == Integer.MAX_VALUE) return 0;
			
			return dp[startIndex][endIndex]+1;*/
			
			
	  }
	  public static boolean isNextStr(String str1, String str2)
	  {
		  if(str1==str2) return false;
		  if(str1.length()!=str2.length())return false;
		  int diff = 0;
		  for(int i =0;i<str1.length();i++)
		  {
			  if(str1.charAt(i)!= str2.charAt(i))
			  {
				  diff++;
				  if(diff>1) return false;
			  }
		  }
		  return true;
	  }
}
