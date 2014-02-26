import java.util.ArrayList;


public class restoreIp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		restoreIp3 ins = new restoreIp3();
		ArrayList<String> ret = ins.restoreIpAddresses("0000");
		OutputHelper.printArrString(ret);
	}
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ret = new ArrayList<String>();
        ArrayList<String> path = new ArrayList<String>();
        restoreDFS(ret, path, s, 0,4);
        return ret;
    }
    public void restoreDFS(ArrayList<String> ret, ArrayList<String> path, String s, int start, int leftSectCnt)
    {
        if(leftSectCnt == 0 && s.length() == start)
        {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<path.size();i++)
            {
                if(i>0)sb.append(".");
                
                sb.append(path.get(i));
            }
            ret.add(sb.toString());
            return;
        }
        int leftLen = s.length() - start;
        if(leftLen> leftSectCnt *3 || leftLen <leftSectCnt)return;
        int end = Math.min(s.length()-1, start+2);
        for(int i = start;i<=end;i++)
        {
            String leftStr = s.substring(start,i+1);
            if(isValidSector(leftStr))
            {
                path.add(leftStr);
                restoreDFS(ret, path,s, i+1,leftSectCnt-1);
                path.remove(path.size()-1);
            }
        }
        
    }
    public boolean isValidSector(String str)
    {
        int val = Integer.parseInt(str);
        if(!Integer.toString(val).equals(str))return false;
        if(val>=0&&val<=255)return true;
        return false;
    }
}
