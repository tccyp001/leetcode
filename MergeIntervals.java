import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MergeIntervals {


	  public class Interval {
	     int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MergeIntervals mi = new MergeIntervals();
		mi.test();
		System.out.println();
		mi.testInsert();
		
	}
	public void test()
	{
		Interval inter1 = new Interval(1,3);
		Interval inter2 = new Interval(2,6);
		Interval inter3 = new Interval(8,10);
		Interval inter4 = new Interval(15,18);
		ArrayList<Interval> input = new ArrayList<Interval>();
		input.add(inter1);
		input.add(inter2);
		input.add(inter3);
		input.add(inter4);
		
		ArrayList<Interval> ret = merge(input);
		
	   for(Interval inter: ret)
	   {
		   System.out.println(inter.start + ", "+ inter.end);
	   }
		
	}
	public void testInsert()
	{
		Interval inter1 = new Interval(1,2);
		Interval inter2 = new Interval(3,5);
		Interval inter3 = new Interval(6,7);
		Interval inter4 = new Interval(8,10);
		Interval inter5 = new Interval(12,16);
		ArrayList<Interval> input = new ArrayList<Interval>();
		input.add(inter1);
		input.add(inter2);
		input.add(inter3);
		input.add(inter4);
		input.add(inter5);
		
		
		Interval inter6 = new Interval(4,9);
		ArrayList<Interval> ret = insert(input, inter6);
		
	   for(Interval inter: ret)
	   {
		   System.out.println(inter.start + ", "+ inter.end);
	   }
		
	}
	 public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        
		 ArrayList<Interval> ret = new ArrayList<Interval>();
		 boolean isAdded = false;
		 for(int i =0; i<intervals.size();i++)
	      {
			 if(newInterval.end< intervals.get(i).start)
			 {
				 if(!isAdded)
				 {
					 ret.add(newInterval);
					 isAdded = true;
				 }
				 ret.add(intervals.get(i));
			 }
			 else if(newInterval.start> intervals.get(i).end)
			 {
				 ret.add(intervals.get(i));
			 }
			 else
			 {
				 if(newInterval.start>intervals.get(i).start)
				 {
					 newInterval.start = intervals.get(i).start;
				 }
				 if(newInterval.end<intervals.get(i).end)
				 {
					 newInterval.end = intervals.get(i).end;
				 }
			 }			 
	      }
		 if(!isAdded)ret.add(newInterval);
		 return ret;
		 
	    }
	 public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
		 
		 if(intervals.size()==0)return intervals;
	      Collections.sort(intervals, new Comparator<Interval>(){
	    	  public int compare(Interval inter1, Interval inter2)
	    	  {
	    		  return inter1.start>inter2.start?1:(inter1.start==inter2.start?0:-1);
	    	  }
	      });
	      
	      ArrayList<Interval> ret = new ArrayList<Interval>();
	      Interval cur = intervals.get(0);
	      
	      
	      for(int i =1; i<intervals.size();i++)
	      {
	    	  if(cur.end>intervals.get(i).start)
	    	  {
	    		  if(cur.end<intervals.get(i).end)
	    		  {
	    			  cur.end= intervals.get(i).end;
	    		  }
	
	    	  }
	    	  else
	    	  {
	    		  ret.add(cur);
	    		  cur = intervals.get(i);
	    	  }
	      }
	      ret.add(cur);
	      return ret;
	      
	    }
}
