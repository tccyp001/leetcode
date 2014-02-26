import java.util.ArrayList;


public class TextJustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] words = {"What","must","be","shall","be."};
		//String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		String[] words = {"Here","is","an","example","of","text","justification."};
		TextJustification ins = new TextJustification();
		ArrayList<String> ret = ins.fullJustify(words,14);
		OutputHelper.printArrString(ret);
	}
	
	public ArrayList<String> fullJustify(String[] words, int L) {
        int index = 0;
        ArrayList<String> ret = new ArrayList<String>();
        
        ArrayList<String> sublist = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        int curLen = 0;
        while(index<words.length)
        {
            if(curLen + sublist.size() + words[index].length()>L)
            {
            	String tmp = formatLine(sublist, curLen, L);
            	curLen = 0;
                ret.add(tmp);
                sb.setLength(0);
                sublist.clear();
            }
            else 
            {
                curLen += words[index].length();
                sublist.add(words[index]);
                index++;
            }
        }
        String lastLine = formatLastLine(sublist,L);
        ret.add(lastLine);
        return ret;
    }
	 public String formatLine(ArrayList<String> line, int totalChar, int totalSpace)
	    {
	        StringBuilder sb = new StringBuilder();
	        int leftCnt = line.size();
	        for(int i =0;i<line.size();i++)
	        {
	            String curStr = line.get(i);
	            if(curStr.isEmpty())continue;
	            int curSpace = leftCnt==1? 0: (totalSpace - totalChar) / (leftCnt -1);
	            sb.append(curStr);
	            for(int j = 0;j<curSpace;j++)
	            {
	                sb.append(" ");
	            }
	            totalChar-=curStr.length();
	            totalSpace-=curStr.length();
	            totalSpace-=curSpace;
	            leftCnt--;
	        }
	        return sb.toString();
	    }
	    public String formatLastLine(ArrayList<String> line, int totalSpace)
	    {
	        StringBuilder sb = new StringBuilder();
	        for(int i =0;i<line.size();i++)
	        {
	             String curStr = line.get(i);
	             if(curStr.isEmpty())continue;
	             sb.append(curStr);
	             totalSpace= totalSpace - curStr.length() -1;
	             if(totalSpace>0)
	            	 sb.append(" ");
	            
	        }
	        for(int j =0;j<totalSpace;j++)
	        {
	            sb.append(" ");
	        }
	        return sb.toString();
	    }
}
