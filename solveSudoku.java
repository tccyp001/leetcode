
public class solveSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] strs = {"8........","..36.....",".7..9.2..",".5...7...","....457..","...1...3.","..1....68","..85....1.",".9....4.."};
        char[][] input = getCharArr(strs);
        solveSudoku(input);
        System.out.println("done");
	}
    public static  char[][] getCharArr(String[] strs)
    {
    	char[][] arr = new char[9][9];
    	
    	for(int i = 0;i<strs.length;i++)
    	{
    		String str = strs[i];
    		for(int j = 0;j<9;j++)
    		{
    			arr[i][j] = str.charAt(j);
    		}
    	}
    	return arr;
    }
	    public static void solveSudoku(char[][] board) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        solveSudoKuSub(board);
	    }
	    public static boolean solveSudoKuSub(char[][] board)
	    {
	        for(int i =0;i<9;i++)
	        {
	            for(int j =0;j<9;j++)
	            {
	                if(board[i][j]=='.')
	                {
	                    for(int k =1;k<=9;k++)
	                    {
	                        board[i][j] = (char)(k+'0');
	                        if(isValid(board, i,j)&&solveSudoKuSub(board) ) return true;
	                        else board[i][j] = '.';
	                  
	                    }
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	    public static boolean isValid(char[][] board, int i,int j)
	    {
	        char c = board[i][j];
	        
	        int colStart = j/3 *3;
	        int rowStart = i/3*3;
	        for(int h = rowStart;h<rowStart+3;h++)
	        {
	            for(int k = colStart;k<colStart+3;k++)
	            {
	                if(h!=i && k!=j&&board[h][k]==c)return false;
	            }
	        }
	        
	        for(int h =0;h<9;h++)
	        {
	            if(h!=j&&board[i][h] ==c)return false;
	            if(h!=i&&board[h][j] ==c)return false;
	        }
	        return true;
	    }

}
