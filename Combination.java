import java.util.ArrayList;


public class Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> ret = combine(4,2);
		for(ArrayList<Integer> list:ret)
		{
			for(int i:list)
			{
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        return combineSub(n,k,1);
        	
    }
    public static  ArrayList<ArrayList<Integer>> combineSub(int n, int k, int start)
    {
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(k ==0)return ret;
        if(k==1)
        {
        	for(int i = start;i<=n;i++)
        	{
        		
        		ArrayList<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		ret.add(list);
        	}
        	return ret;
        }
        for(int i =start;i<=n;i++)
        {
        	ArrayList<ArrayList<Integer>> sublist = combineSub(n, k-1, i+1);
        	for(ArrayList<Integer> list:sublist)
        	{
        		list.add(0,i);
        		ret.add(list);
        	}
        }
        return ret;
        
    }
}
