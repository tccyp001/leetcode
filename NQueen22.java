import java.util.ArrayList;


public class NQueen22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueen22 ins = new NQueen22();
		int ret = ins.totalNQueens(14);
		System.out.println(ret);
		int ret2 = ins.totalNQueens2(14);
		System.out.println(ret2);
		
	}
	 public int totalNQueens(int n) {
	        int[] ret = new int[1];
	        int upper = (1<<n)-1 ;
	        solveNQueensIntDFS(0, 0, 0, upper, ret);
	        return ret[0];
	    }
	    public void solveNQueensIntDFS(int used, int ldiag, int rdiag, int upper, int[] ret)
	    {
	        if(used == upper)
	    	{
	    		ret[0]++;
	    		return;
	    	}
	        int pos = upper&(~(used|ldiag|rdiag));
	        while(pos!=0)
	        {
	            int p = pos &(-pos);
	            solveNQueensIntDFS(used+p, (ldiag+p)<<1, (rdiag+p)>>1,upper,ret);
	            pos = pos -p;
	        }
	    }
	    public int totalNQueens2(int n) {
	        int[] ret = new int[1];
	        ArrayList<Integer> path = new ArrayList<Integer>();
	        solveNQueensIntDFS(n, 0, ret, path);
	        return ret[0];
	    }
	    public void solveNQueensIntDFS(int n, int row, int[] ret, ArrayList<Integer> path)
	    {
	        if(row == n)
	    	{
	    		ret[0]++;
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
