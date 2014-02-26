import java.util.ArrayList;


public class NQueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueen ins = new NQueen();
		ArrayList<String[]> ret = ins.solveNQueens(4);
		
		for(String[] strs: ret)
		{
			for(String s : strs)
			{
				System.out.println(s);
			}
			System.out.println();
			System.out.println();
		}
	}
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> intret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        solveNQueensIntDFS(n,0,intret,path);
        return convertIntArrToStrArr(intret,n);
    }
    public ArrayList<String[]> convertIntArrToStrArr(ArrayList<ArrayList<Integer>> input,int n)
    {
        StringBuilder sb = new StringBuilder();
        ArrayList<String[]> ret = new ArrayList<String[]>();
        for(ArrayList<Integer> arrList : input)
        {
        	String[] strs = new String[n];
        	int arrIndex=0;
            for(Integer i : arrList)
            {
                int index = 0;
                sb.setLength(0);
                while(index<n)
                {
                    if(index ==i)sb.append('Q');
                    else sb.append('.');
                    index++;
                }
                strs[arrIndex++] = sb.toString();
            }
            ret.add(strs);
        }
        return ret;
    }
    public void solveNQueensIntDFS(int n, int row, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> path)
    {
        if(row == n)
    	{
    		ret.add(new ArrayList<Integer>(path));
    		return;
    	}
        
        for(int i = 0;i<n;i++)
        {
            if(isValid(path, i,row))
            {
                path.add(i);
                solveNQueensIntDFS(n,row+1,ret,path);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isValid(ArrayList<Integer> path, int x, int y)
    {
        for(int i = 0;i<path.size();i++)
        {
            if(path.get(i)==x)return false;
            if(Math.abs(y-i) == Math.abs(x-path.get(i)))return false;
        }
        return true;
    }
}
