import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;


public class Triangle3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l1 =new ArrayList<Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.remove(list.size()-1);
		list.ge
		l1.add(1);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(2);
		l2.add(3);
		input.add(l1);
		input.add(l2);
		int ret = minimumTotal(input);
		
		HashMap<Integer,Integer> map = HashMap<Integer, Integer>();
		map.put(1, 1);
		map.size()
	}
	 public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	        for(int i = triangle.size() - 2 ; i>= 0; i--)
	        {
	            for(int j = 0; j <= i; j++)
	            {
	                triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
	            }
	        }
	        return triangle.get(0).get(0);
	    }
}
