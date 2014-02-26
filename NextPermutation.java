
public class NextPermutation {
	public static void  main(String[] args)
	{
		int[] input= {5,1,1};
		for(int i :input)
		{
			System.out.print(i+" ,");
		}
		nextPermutation(input);
		System.out.println();
		for(int i :input)
		{
			System.out.print(i+" ,");
		}

	}
	public  static void nextPermutation(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int end = num.length -1;

		while(end>0 && num[end-1]>=num[end])
		{
			end--;
		}
		if(end==0) 
		{
			swapArr(num, 0, num.length-1);
			return;
		}
		int curPos = end-1;
		int cur = num[curPos];
		if(cur<num[num.length-1]) 
		{
			num[curPos] = num[num.length-1];
			num[num.length-1] = cur;
		}
		else
		{
			while(end<num.length && cur<num[end])
			{
				end++;
			}
			num[curPos] = num[end-1];
			num[end-1] = cur;
		}

		swapArr(num, curPos+1,num.length-1);
		
    }
	
	public static void swapArr(int[] num, int start, int end)
	{
		while(start<end)
		{
			int tmp = num[end];
			num[end] =  num[start];
			num[start] = tmp;
			end--;
			start++;
		}
	}
}
