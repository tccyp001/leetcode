
public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(2147483647));
	}
	 public static int sqrt(int x) {
	        if(x==0)return 0;
	        if(x==1)return 1;
	        if(x==2)return 1;
	        long start = 1;
	        long end = (long)x+1;
	        long mid =0;
	        while(start<end)
	        {
	            mid = start + (end - start)/2;
	            if(mid*mid <= x && (mid+1)*(mid+1)>x)return (int)mid;
	            if(mid*mid<x) start = mid+1;
	            else end = mid;
	        }

	        return (int)mid;
	        
	    }
}
