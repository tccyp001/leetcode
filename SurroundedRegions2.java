import java.util.LinkedList;
import java.util.Queue;


public class SurroundedRegions2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SurroundedRegions2 ins = new SurroundedRegions2();
		char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
		ins.solve(board);
		
		
	}
    public void solve(char[][] board) {
        if(board.length==0)return;
        for(int i =0;i<board.length;i++)
        {
            solveSub(board, i, 0);
            solveSub(board, i, board[0].length-1);
        }
        for(int j =1;j<board[0].length-1;j++)
        {
            solveSub(board, 0, j);
            solveSub(board, board.length-1, j);
        }
        for(int i =0;i<board.length;i++)
        {
            for(int j =0;j<board[0].length;j++)
            {
                if(board[i][j]=='1')board[i][j]='O';
                else board[i][j]='X';
            }
        }
        return;
    }
    public void solveSub(char[][] board, int i, int j)
    {
        Queue<Integer> queX = new LinkedList<Integer>();
        Queue<Integer> queY = new LinkedList<Integer>();
        solveBFS(board, queX, queY, i,j);
        while(!queX.isEmpty()){
            int x = queX.remove();
            int y = queY.remove();
            solveBFS(board, queX, queY, x-1,y);
            solveBFS(board, queX, queY, x+1,y);
            solveBFS(board, queX, queY, x,y-1);
            solveBFS(board, queX, queY, x,y+1);
        }
    }
    public void solveBFS(char[][] board, Queue<Integer> queX,  Queue<Integer> queY, int i, int j)
    {
        if(i<0||j<0||i>=board.length||j>=board[0].length)return;
        
        if(board[i][j]=='O')
        {
        	board[i][j] = '1';
            queX.offer(i);
            queY.offer(j);
        }
    }
}
