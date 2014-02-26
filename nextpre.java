import java.util.ArrayList;


public class nextpre {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[]  input = {1,5,1};
		//nextPermutation(input);
		//OutputHelper.printArrInt(input);
		
		System.out.println(getPermutation(3,2));
	}
	public static void nextPermutation(int[] num) {
		 if(num.length ==0)return;
	        if(num.length ==1)return;
	        int index1 = num.length -2;
	        int index2 = 0;
	        while(index1>=0 && num[index1]>=num[index1+1])index1--;
	        if(index1>=0)
	        {
	            index2 = index1 +1;
	            while( index2<num.length && num[index1]<num[index2])index2++;
	            swap(num, index1, index2-1);
	        }
	        index1++;
	        index2 = num.length -1;
	        while(index1<index2)swap(num,index1++,index2--);

    }
    public static void swap(int[]num, int i, int j)
    {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    public static String getPermutation(int n, int k) {
        
        int[] data = new int[n +1];
        data[0] = 1;
        for(int i=1;i<n+1;i++)
        {
            data[i] = data[i-1]*i;
        }
        boolean[] used = new boolean[n+1];
        StringBuilder sb = new StringBuilder();
        int index = n-1;
        int num = 1;
        while(k>1)
        {
            while(k>data[index])
            {
            	do{num++;}
                while(used[num]);
                k-=data[index];
            }
            sb.append(num);
            used[num] = true;
            index--;
            num =1;
            while(used[num])num++;
        }
        for(int i=1;i<used.length;i++)
        {
        	if(!used[i])
        	sb.append(i);
        }
        return sb.toString();
        
    }
}
