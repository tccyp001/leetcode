
public class NQueen12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> intret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        solveNQueensIntDFS(n,0,ret,path);
        return convertIntArrToStrArr(intret,n);
    }
    public ArrayList<String[]> convertIntArrToStrArr(ArrayList<ArrayList<Integer>> input,int n)
    {
        StringBuilder sb = new StringBuilder();
        ArrayList<String[]> ret = new ArrayList<String[]>();
        for(ArrayList<Integer> arrList : input)
        {
            String[] strs = new String[n];
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
                strs.add(sb.toString());
            }
            ret.add(strs);
        }
    }
    public void solveNQueensIntDFS(int n, int row, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> path)
    {
        if(row == n) ret.add(new ArrayList<Integer>(path));
        
        for(int i = 0;i<n;i++)
        {
            if(isValid(path, i,row))
            {
                path.add(i)
                solveNQueensIntDFS(n,row+1,ret,path);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isValid(ArrayList<Integer> path, int x, int y)
    {
        for(int i = 0;i<path.size();i++)
        {
            if(path.get(i)==y)return false;
            if(Math.abs(x-i) == Math.abs(y-path.get(i))return false;
        }
        return true;
    }
}
