import java.util.ArrayList;
import java.util.HashMap;


public class MaxPoint {
    public static class Point
    {
    	int x;
    	int y;
    	public Point(){x=0;y=0;}
    	public Point(int a, int b){x=a;y=b;}
    }
	public static class Line
    {
    	Point m_p;
    	double m_slope;
    	
    	public Line(Point p1, Point p2)
    	{
    		m_p = p1;
            m_slope = getSlope(p1, p2);
    	}
    	public double getSlope(Point p1, Point p2)
    	{
    	    if(p1.x == p2.x) return Double.MIN_VALUE;
    		return (double)(p1.y - p2.y) / (p1.x- p2.x);
    	}
    	public boolean isPointOnLine(Point p1)
    	{
    		if(p1.x== m_p.x && p1.y == m_p.y)return true;
    		double slope = getSlope(p1, m_p);
    		if(Math.abs(slope- m_slope)<0.00001) return true;
    		return false;
    	}
    	@Override
    	public int hashCode()
    	{
    	    return (int)(m_slope) ^ m_p.x ^ m_p.y;
    	}
    	@Override
    	public boolean equals(Object obj)
    	{
    		 if (obj == null)
    	            return false;
    	     if (obj == this)
    	            return true;
    	     if (!(obj instanceof Line))
    	            return false;
    	     
    	     if(Math.abs(((Line)obj).m_slope - m_slope)<0.00001 && isPointOnLine(((Line)obj).m_p))
    	    	 return true;
    	     
    	     return false;
    		
    	}
    }
	public int maxPoints(Point[] points) {
        
		
		HashMap<Line,Integer> map = new HashMap<Line,Integer>();

		for(int i = 0;i<points.length-1;i++)
		{
			for(int j = i+1;j<points.length;j++)
			{
				Line line1 = new Line(points[i], points[j]);
				if(!map.containsKey(line1))
					map.put(line1, 0);
			}
		}
		int max = 0;
		for(Point p1: points)
		{
			for(Line line1:map.keySet())
			{
				if(line1.isPointOnLine(p1)) 
				{ 
					int curCnt = map.get(line1)+1;
					max = Math.max(curCnt, max);
					map.put(line1,curCnt);
				}
			}
		}
		return max;
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPoint ins = new MaxPoint();
		
		ArrayList<Point> arr = new ArrayList<Point>();
		Point[] points = new Point[3];
		points[0]  = new Point(0,0);
		points[1]  = new Point(1,1);
		points[2]  = new Point(0,0);
		
		int cnt = ins.maxPoints(points);
		System.out.println(cnt);
	}

}
