import java.util.ArrayList;
import java.util.Arrays;


public class sum33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,-2,1};
		ArrayList<ArrayList<Integer>> ret = threeSum(input);
		OutputHelper.printArrArrInt(ret);
	}
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        if(num.length<3)return ret;
        for(int i = 0 ;i<num.length - 2;i++)
        {
            if(i>0 && num[i] == num[i-1])continue;
            int target = 0 - num[i];
            int start = i+1;
            int end = num.length -1;
            while(start<end)
            {
                if(num[start] + num[end] == target) 
                {
                    ArrayList<Integer> subret = new ArrayList<Integer>();
                    subret.add(num[i]);
                    subret.add(num[start++]);
                    subret.add(num[end--]);
                    ret.add(subret);
                    while(start<end && num[start-1] == num[start]) start++;
                    while(start<end && num[end+1] == num[end]) end--;
                }
                else if(num[start] + num[end] > target)end--;
                else start++;
            }
        }
        return ret;
    }
}
