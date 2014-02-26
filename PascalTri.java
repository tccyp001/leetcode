import java.util.ArrayList;


public class PascalTri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> ret = generate(5);
		for(ArrayList<Integer> arr:ret)
		{
			for(int i: arr)
			{
				System.out.print(i);
			}
			System.out.println();
		}
		ArrayList<Integer> rowRet = getRow(6);
		for(int i: rowRet)
		{
			System.out.print(i);
		}
		System.out.println();
	}
	 public static ArrayList<Integer> getRow(int rowIndex) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        ArrayList<Integer> parentLevel = new ArrayList<Integer>();
	        ArrayList<Integer> childLevel = new ArrayList<Integer>();
	        parentLevel.add(1);
	        if(rowIndex ==0)return parentLevel;
	        parentLevel.add(1);
	        if(rowIndex ==1)return parentLevel;
	        
	        int i = 2;
	        while(i<=rowIndex)
	        {
	            childLevel.add(1);
	            for(int j=0;j<parentLevel.size()-1;j++)
	            {
	                childLevel.add(parentLevel.get(j) + parentLevel.get(j+1));
	            }
	            childLevel.add(1);
	            ArrayList<Integer> tmp = parentLevel;
	            parentLevel = childLevel;
	            childLevel = tmp;
	            childLevel.clear();
	            i++;
	        }
	        return parentLevel;
	        
	    }
	 public static ArrayList<ArrayList<Integer>> generate(int numRows) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	        if(numRows ==0)return ret;
	        ArrayList<Integer> sub = new ArrayList<Integer>();
	        sub.add(1);
	        ret.add(sub);

	        for(int i= 1;i<numRows;i++)
	        {
	            ArrayList<Integer> newLevel = new ArrayList<Integer>();
	            newLevel.add(1);
	            for(int j = 0;j<i-1;j++)
	            {
	               newLevel.add(ret.get(i-1).get(j)+ ret.get(i-1).get(j+1));
	            }
	            newLevel.add(1);
	            ret.add(newLevel);
	        }
	        return ret;
	            
	        
	    }
}
