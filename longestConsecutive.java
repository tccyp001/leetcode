import java.util.HashMap;


public class longestConsecutive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestConsecutive(getInput());
	}
	public static int[] getInput()
	{
		int[] input = {9000,8999,8998,8997,8996,8995,8994,8993,8992,8991,8990,8989,8988,8987,8986,8985,8984,8983,8982,8981,8980,8979,8978,8977,8976,8975,8974,8973,8972,8971,8970,8969,8968,8967,8966,8965,8964,8963,8962,8961,8960,8959,8958,8957,8956,8955,8954,8953,8952};
		return input;
	}
	public static int longestConsecutive(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int maxLen = 0;
        for(int i =0;i<num.length;i++)
        {
            map.put(num[i],-1);
        }
        for(int i =0;i<num.length;i++)
        {
            int currentNum = num[i];
            map.put(currentNum,1);
            int currentMax  = 1;
            boolean isContinue = true;
            while(map.containsKey(++currentNum))
            {
                int Lnext = map.get(currentNum);
                if(Lnext>0) 
                {
                    currentMax = Lnext;
                    isContinue = false;
                    break;
                }
                currentMax++;
            }
            currentNum = num[i];
            if(isContinue)
            {
                while(map.containsKey(--currentNum))
                {
                    int Rnext = map.get(currentNum);
                    if(Rnext>0) 
                    {
                        currentMax = Rnext;
                        break;
                    }
                    currentMax++;
                }
            }

            if(currentMax>maxLen) maxLen = currentMax;
            map.put(num[i], currentMax);
        }
        
        return maxLen;
        
    }
}
