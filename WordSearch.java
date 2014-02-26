
public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'a'}};
		String word = "a";
		boolean ret = exist(board,word);
		System.out.println(ret);
	}
	public static boolean exist(char[][] board, String word) {
        int rowCount = board.length;
        if(word.length()==0)return true;
        if(rowCount<=0)return false;
        
        int colCount = board[0].length;
        
        boolean[][] visited = new boolean[rowCount][colCount];
        boolean ret = false;
        for(int i =0;i<rowCount;i++)
        {
            for(int j = 0; j<colCount;j++)
            {
                existSub(board,word,visited,i,j);
                if(ret)return true;
            }
        }
        return false;
        
    }
    
    public static  boolean existSub(char[][] board, String word, boolean [][] visited, int X, int Y)
    {
        if(word.length()==0)return true;
        if(X<0||Y<0||X>=board.length||Y>=board[0].length)return false;
        if(visited[X][Y])return false;
        if(board[X][Y] != word.charAt(0))return false;
        
        visited[X][Y] = true;
        boolean ret =  existSub(board,word.substring(1),visited,X-1,Y)||
                       existSub(board,word.substring(1),visited,X,Y-1)||
                       existSub(board,word.substring(1),visited,X+1,Y)||
                       existSub(board,word.substring(1),visited,X,Y+1);

        visited[X][Y] =false;
        return ret;
        
    }
}
