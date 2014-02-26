import java.util.ArrayList;


public class solveNQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =4;
		char[][] board = new char[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				board[i][j]='.';
			}
		}
		 ArrayList<String[]> result = new  ArrayList<String[]>();
		solveNQueens1(n, board, 0, result);
		System.out.println("aa");
	}
	public static  void solveNQueens1(int n, char[][] board, int col, ArrayList<String[]> result)
	{
		if(col == n)
		{
			String[] strs = new String[n];
			for(int k=0;k<n;k++)
			{
				strs[k] = new String(board[k]);
			}
			result.add(strs);
			return;
		}
		for(int j =0 ;j<n ; j++)
		{
			boolean isValid = true;
			for(int i =0;i<col;i++)
			{
				if(board[i][j]=='Q' )
				{
					isValid = false;
					break;
				}
			}
			int k = j-1;
			int h = col -1;
			while(k>=0&&h>=0)
			{
				if(board[h][k]=='Q' ) 
				{
					isValid = false;
					break;
				}
				h--;
				k--;
				
			}
			 k = j+1;
			 h = col -1;
			while(k<n&&h>=0)
			{
				if(board[h][k]=='Q' ) 
				{
					isValid = false;
					break;
				}
				k++;
				h--;
			}
			if(isValid)
			{
				board[col][j] = 'Q';
				solveNQueens1(n, board, col+1, result);
				board[col][j] = '.';
			}
			
		}
		
	}
}
