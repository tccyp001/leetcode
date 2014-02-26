
public class isValidSudok {

	 public boolean isValidSudoku(char[][] board) {
	        int row = 0;
	        int col = 0;
	        int cell = 0;
	        for(int i = 0;i<9;i++)
	        {
	            for(int j = 0;j<9;j++)
	            {
	                if(board[i][j]!='.')
	                {
	                    int valRow = board[i][j]  - '0';
	                    if(((1<<valRow) & row) != 0) return false;
	                    row |= 1<<valRow;
	                }
	                if(board[j][i]!='.')
	                {
	                    int valCol = board[j][i] - '0';
	                    if((1<<valCol) & col != 0) return false;
	                    col |= 1<<valCol;
	                }
	                if(board[i/3*3 + j%3][i%3*3 + j/3]!='.')
	                {
	                    int valCell = board[i/3*3 + j%3][i%3*3 + j/3] - '0';
	                    if((1<<valCell) & cell != 0) return false;
	                    cell |= 1<<valCol;
	                }
	            }
	            row = 0;
	            col = 0;
	            cell = 0;
	        }
	        return true;
	    }
}
