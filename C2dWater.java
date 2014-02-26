import java.util.PriorityQueue;


public class C2dWater {
    private int m;
    private int n;
    private int[][] mat;
    private boolean[][] visited;
    private PriorityQueue<Cell> pq;
    private int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] input = {{8,6,1,3,3},{3,3,3,3,3},{3,3,0,3,3},{3,3,3,3,3},{3,3,3,3,3}};
		
		C2dWater ins = new C2dWater(input);
		ins.solve();
	}
	    
    class Cell implements Comparable<Cell>{
        int x;
        int y;
        int height;
        public Cell(int x,int y,int height){
            this.x=x;
            this.y=y;
            this.height=height;
        }
        
        public int compareTo(Cell o){
            return height-o.height;
        }
    }
    
    public C2dWater(int[][] input){
        mat=input;
        m=mat.length;
        n=mat[0].length;
        visited=new boolean[m][n];
        pq=new PriorityQueue<Cell>();
        count=0;
    }
    
    private void check(int x, int y, int lowest){
        if(x<0 || x>=m || y<0 || y>=n || visited[x][y]) return;
        if(mat[x][y]<lowest) count+=lowest-mat[x][y];
        visited[x][y]=true;
        pq.offer(new Cell(x,y,Math.max(lowest, mat[x][y])));
    }
    
    public int solve(){
        for(int i=0;i<m;i++){
            visited[i][0]=true;
            pq.offer(new Cell(i,0,mat[i][0]));
                
            visited[i][n-1]=true;
            pq.offer(new Cell(i,n-1,mat[i][n-1]));
        }
        
        for(int j=1;j<n-1;j++){
            visited[0][j]=true;
            pq.offer(new Cell(0,j,mat[0][j]));
                
            visited[m-1][j]=true;
            pq.offer(new Cell(m-1,j,mat[m-1][j]));
        }

        while(!pq.isEmpty()){
            Cell curr=pq.poll();
            check(curr.x-1,curr.y,curr.height);
            check(curr.x+1,curr.y,curr.height);
            check(curr.x,curr.y-1,curr.height);
            check(curr.x,curr.y+1,curr.height);
        }
        
        return count;
    }
	
}
