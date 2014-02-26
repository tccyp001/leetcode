import java.util.ArrayList;


public class Triangle11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> ret = generate(5);
		OutputHelper.printArrArrInt(ret);
	}

    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(numRows ==0)return ret;
        int[] f = new int[numRows];
        f[0] = 1;
        for(int i = 0;i<numRows;i++)
        {
            ArrayList<Integer> subret = new ArrayList<Integer>();
            for(int j = i ;j>=0;j--)
            {
                
                if(j==i)f[j]=1;
                else if(j>0)f[j] = f[j-1] + f[j];
                subret.add(f[j]);
            }
            ret.add(subret);
        }
        return ret;
    }
	
}
