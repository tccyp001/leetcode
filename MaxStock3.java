
public class MaxStock3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2};

        int ret = maxProfit(num);
        System.out.println(ret);
	}
    public static int maxProfit(int[] prices) {
        if(prices.length <=1)return 0;
        int[] maxForward = new int[prices.length];
        int[] maxBack = new int[prices.length];
        int min = prices[0];
        int max = prices[prices.length-1];
        int totalMax = Integer.MIN_VALUE;
        maxForward[0] = 0;
        maxBack[prices.length-1] = 0;
        for(int i =1;i<prices.length;i++)
        {
             min = Math.min(min, prices[i]);
             maxForward[i] = Math.max(maxForward[i-1],prices[i] - min);
        }
         for(int i =prices.length-2;i>=0;i--)
        {
             max = Math.max(max, prices[i]);
             maxBack[i] = Math.max(maxBack[i+1],max- prices[i]);
             totalMax = Math.max(totalMax, maxBack[i] + maxForward[i]);
        }
        totalMax = Math.max(totalMax, maxBack[0] + maxForward[0]);
        totalMax = Math.max(totalMax, maxBack[prices.length-1] + maxForward[prices.length-1]);
        return totalMax;
    }
}
