import java.util.ArrayList;
import java.util.Arrays;


public class Pemuteta22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pemuteta22 ins = new Pemuteta22();
		int[] input = {1,3,2,1};
		ArrayList<ArrayList<Integer>> ret = ins.permuteUnique(input);
		OutputHelper.printArrArrInt(ret);
	}
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num.length == 0)return ret;
        boolean[] used = new boolean[num.length];
        Arrays.sort(num);
        ArrayList<Integer> path = new ArrayList<Integer>();
        permuteDFS(num, path, ret, 0,used);
        return ret;
    }
    public void permuteDFS(int [] num, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ret, int start, boolean[] used)
    {
        if(start == num.length)ret.add(new ArrayList<Integer>(path));
        int last = -1;
        for(int i = 0;i<num.length;i++)
        {
            if((last!=-1 && num[i] == num[last]) || used[i])continue;
            used[i] = true;
            path.add(num[i]);
            permuteDFS(num, path, ret, start+1,used);
            path.remove(path.size()-1);
            used[i] = false;
            last = i;
        }
    }
    public void swap(int[] num, int i, int j)
    {
        int tmp = num[i];
        num[i] =num[j];
        num[j]=tmp;
    }
}
