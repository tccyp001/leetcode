
public class BuyStocks3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,1,2,0,1};
		System.out.println(maxProfit(input));
	}

	    public static int maxProfit(int[] prices) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        
	        if(prices.length<=1)return 0;
	        
	        int[] forward = new int[prices.length];
	        int[] backward = new int[prices.length];
	        forward[0] = 0;
	        backward[prices.length-1]=0;
	        
	        int curMin = prices[0];
	        for(int i=1;i<prices.length;i++)
	        {
	        	curMin = Math.min(curMin, prices[i]);
	            forward[i] = Math.max(forward[i-1], prices[i]- curMin);
	        }
	        int curMax = prices[prices.length-1];
	        for(int i=prices.length-2;i>=0;i--)
	        {
	        	curMax = Math.max(curMax, prices[i]);
	            backward[i] = Math.max(backward[i+1], curMax - prices[i]);
	        }
	        
	        int max = 0;
	        for(int i = 0;i<prices.length;i++)
	        {
	            max = Math.max(max, forward[i]+backward[i]);
	        }
	        return max;
	    }
}
