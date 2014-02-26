import java.util.ArrayList;
import java.util.HashMap;


public class SubstringwithConcatenation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	String[] L = {"foo", "bar"};
		//String S ="barfoobarthefoobarman";
	//	String[] L ={"a","a"};
	//	String S  = "aaa";
		//String[] L ={"ab","ba","ab","ba"};
		//String S = "abaababbaba";
		
		String S = "abcbaabcabcaccbcccbbaaabaaaaaabaabcacbacaaacabcabaccbccbaaaabbbbabcaaaaabbcbcbabccbccbbcbbacbccbabcacabbcbacaabbcabcbcaacbaaaccbbcababccaabcbab";
		String[] L = {"cac","bcc","bab","abb","bac"};
		System.out.println(S.substring(86));
		
		ArrayList<Integer> ret = findSubstring(S,L);
		for(int i:ret)
		{
			System.out.println(i);
		}
	}
	 public static ArrayList<Integer> findSubstring(String S, String[] L) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        ArrayList<Integer> ret = new ArrayList<Integer>();
	        if(L.length ==0 )return ret;
	        if(L.length * L[0].length()>S.length())return ret;
	        
	        HashMap<String, Integer> needCnt = new HashMap<String, Integer>();
	        HashMap<String, Integer> foundCnt = new HashMap<String, Integer>();
	        
	        for(int i = 0;i<L.length;i++)
	        {
	            int cnt = 0;
	            if(needCnt.containsKey(L[i]))
	            {
	                cnt = needCnt.get(L[i]);
	            }
	            needCnt.put(L[i],cnt+1);
	        }
	        int wordLen = L[0].length();
	        
	        for(int i = 0;i<wordLen;i++)
	        {
	        	foundCnt.clear();
	            int foundNum = 0;

	            for(int j=0;j<L.length;j++)
	            {
	                if(i + (j+1)*wordLen>S.length()) break;
	                String str = S.substring(i + j*wordLen,i + (j+1)*wordLen);
	                if(needCnt.containsKey(str))
	                {

	                    int cnt = 0;
	                    if(!foundCnt.containsKey(str))foundNum ++;
	                    if(foundCnt.containsKey(str))
	                    {
	                    	if(foundCnt.get(str)< needCnt.get(str))foundNum ++;
	                        cnt = foundCnt.get(str);
	                    }
	                    foundCnt.put(str,cnt+1);
	                }
	            }
	            if(foundNum==L.length)ret.add(i);
	            int start = i;
	            int end = i+ wordLen * L.length;
	            int offset = 0;
	            while(offset+end + wordLen<=S.length())
	            {
	                String str1 = S.substring(start+offset,start+offset+wordLen);
	                String str2 = S.substring(end+offset,end+offset+wordLen);
	                if(foundCnt.containsKey(str1))
	                {
	                    if(foundCnt.get(str1)<=needCnt.get(str1)) 
	                    {
	                        foundNum--;
	                    }
                        foundCnt.put(str1, foundCnt.get(str1)-1);
	                }

	                if(!needCnt.containsKey(str2))
	                {
	                	offset+=wordLen;
	                	continue;
	                }
	                if(needCnt.containsKey(str2))
	                {
	                    if(!foundCnt.containsKey(str2)) 
	                    {
	                        foundNum++;
	                        foundCnt.put(str2, 1);
	                    }
	                    else if(foundCnt.get(str2)<needCnt.get(str2))
	                    {
	                        foundNum++;
	                        foundCnt.put(str2, foundCnt.get(str2)+1);
	                    }
	                    else
	                    {
	                        foundCnt.put(str2, foundCnt.get(str2)+1);
	                    }
	                }
	                offset+= wordLen;
	                if(foundNum==L.length)
                	{
                		ret.add(start+offset);
                	}

	            }
	        }
	        
	        return ret;
	    }
}
