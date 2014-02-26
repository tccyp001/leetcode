
public class DivideTwoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int ret = divide2(-1010369383, -2147483648);
         System.out.println(ret);
	}
	 public static int divide(int dividend, int divisor) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        boolean flag = true;
	        long  dividend1 = divisor ,divisor1 = dividend;
	        if(dividend==0)return 0;
	        if(dividend1<0)
	        {
	            dividend1 =-dividend1;
	            flag = !flag;
	        }
	        if(divisor1<0)
	        {
	        	divisor1 = -divisor1;
	            flag = !flag;
	        }
	          int ret=0;
	        int shift = 0;
			while(divisor1>=dividend1)
			{
			    dividend1 = dividend1<<1;
			    shift++;
			}
			dividend1 = dividend1 >>1;
        
			for(int i =0;i<shift;i++)
			{
			     ret = ret<<1;
			     if(divisor1>=dividend1)
			     {
			         divisor1-=dividend1;
			         ret=ret+1;
			     }
			     dividend1 = dividend1>>1;
         
			}
	       
	        if(flag)
	            return ret;
	        else
	        {
	            return -ret;
	        }
	        
	    }
	    public static int divide2(int dividend, int divisor) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        boolean isNeg = false;
	        long dividend1 = dividend;
	        long divisor1 = divisor;
	        if(divisor1 == 0)return 0;
	        if(divisor1 == 1)return dividend;
	        if(divisor1 == -1)return -dividend;
	        if(dividend1<0)
	        {
	            isNeg = true;
	            dividend1 = - dividend1;
	        }
	        if(divisor<0)
	        {
	            isNeg = !isNeg;
	            divisor1 = - divisor1;
	        }
	        int shift =0;
	        long tmp = dividend1;
	        while((tmp-divisor1)>=divisor1)
	        {
	            shift++;
	            tmp=  tmp>>1;
	            
	        }
	        int ret = 0;
	        for(int i=0;i<=shift;i++)
	        {
	        	ret = ret<<1;
	            if(dividend1>=(divisor1<<(shift-i)))
	            {
	                dividend1-=(divisor1<<(shift-i));
	                ret+=1;
	            }
	        }
	        if(isNeg) return -ret;
	        return ret;
	        
	    }
}
