
public class test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,1,1,1,-2,-3,-4,1,-5};
		rearrange(input);
		OutputHelper.printArrInt(input);
	}
	public static void rearrange(int A[])
	{
		int index1 = 0;
		int index2 = 1;
		
		while(index1<A.length && index2<A.length)
		{
			while(index1<A.length && A[index1]<0)index1 = index1 +2;
			while(index2<A.length && A[index2]>0)index2 = index2 +2;
			
			if(index1<A.length && index2 <A.length)
				swap(A,index1, index2);
			index1=index1+2;
			index2=index2+2;
			
		}
	}
	public static void swap(int A[], int i, int j)
	{
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
