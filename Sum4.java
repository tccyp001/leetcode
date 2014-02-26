import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class Sum4 {
	public class Pair<F, S> {
		public F first;
		public S second;
		public Pair(F first,S second)
		{
			this.first = first;
			this.second = second;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sum4 s = new Sum4();
		int[] input = {-3,0,0,3};
		ArrayList<ArrayList<Integer>> ret = s.fourSum(input,0);
		for(ArrayList<Integer> arr1 : ret)
		{
			for(int i :arr1)
			{
				System.out.print(i+ ",");
				
			}
			System.out.println();
		}
		System.out.println("aa");
	}
	 public  ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        HashMap<Integer,List<Pair<Integer,Integer>>> map = new HashMap<Integer,List<Pair<Integer,Integer>>>();
		    Arrays.sort(num);
	        int len = num.length;
	        for(int i = 0; i< len;i++)
	        {
	        	if(i>0&&num[i]==num[i-1])continue;
	            for(int j = i+1;j<len;j++)
	            {
	            	if(j>i+1&&num[j]==num[j-1])continue;
	            	int key = num[i] + num[j];
	            	Pair<Integer,Integer> pair = new Pair<Integer,Integer> (i,j);
	            	if(map.containsKey(key))
	            	{
	            		map.get(key).add(pair);
	            	}
	            	else
	            	{
	            		ArrayList<Pair<Integer,Integer>> list= new ArrayList<Pair<Integer,Integer>>();
	            		list.add(pair);
	            		map.put(key, list);
	            	}
	            }
	        }
	        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	        
	        for(int i:map.keySet())
	        {
	        	if(map.containsKey(target-i))
	        	{
	        		for(Pair<Integer,Integer> pair1: map.get(i))
	        		{
	        			for(Pair<Integer,Integer> pair2: map.get(target-i))
		        		{
		        			if(pair1.first!=pair2.first && pair1.first!=pair2.second && 
		        					pair1.second!=pair2.first && pair1.second!=pair2.second &&
		        				pair1.first<pair2.first && pair1.second<pair2.first)
		        			{
		        				ArrayList<Integer> subret = new ArrayList<Integer>();
		        				subret.add(num[pair1.first]);
		        				subret.add(num[pair2.first]);
		        				subret.add(num[pair1.second]);
		        				subret.add(num[pair2.second]);
		        				Collections.sort(subret);
		        				ret.add(subret);
		        			}
		        		}
	        		}
	        	}
	        }
	        return ret;
	        
	        
	    }
}
