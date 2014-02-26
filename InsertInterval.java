import java.util.ArrayList;


public class InsertInterval {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i1 = new Interval(1,5);
		Interval i2 = new Interval(6,8);
		Interval i3 = new Interval(5,6);
		
		ArrayList<Interval> input = new ArrayList<Interval>();
		input.add(i1);
		input.add(i2);
		
		
		ArrayList<Interval> ret = insert(input,i3);
	}
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        for(int i = 0;i<intervals.size();i++)
        {
            Interval curInterval = intervals.get(i);
            if(curInterval.start>newInterval.end)
            {
                intervals.add(i,newInterval);
                return intervals;
            }
            else if(newInterval.start>curInterval.end)
               continue;
            else if(curInterval.start<=newInterval.start && curInterval.end >=newInterval.start||
                curInterval.start>=newInterval.start && curInterval.start<=newInterval.end)
            {
                newInterval.start = Math.min(newInterval.start,curInterval.start);
                newInterval.end = Math.max(newInterval.end,curInterval.end);
                intervals.remove(i);
                i--;
            }
        }
        intervals.add(newInterval);
        return intervals;
    }
}
