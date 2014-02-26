import java.util.ArrayList;


public class OutputHelper {

	public static void printArrArrInt(ArrayList<ArrayList<Integer>> input)
	{
		for(ArrayList<Integer> list:input)
		{
			for(int i:list)
			{
				System.out.print(i);
			}
			System.out.println();
		}
	}
	public static void printArrArrStr(ArrayList<ArrayList<String>> input)
	{
		for(ArrayList<String> list:input)
		{
			for(String i:list)
			{
				System.out.print(i);
			}
			System.out.println();
		}
	}
	public static void printArrInt(ArrayList<Integer> input)
	{

			for(int i:input)
			{
				System.out.print(i);
			}
			System.out.println();

	}
	public static void printArrString(ArrayList<String> input)
	{

			for(String i:input)
			{
				System.out.println(i);
			}
			System.out.println();

	}
	public static void printArrArrInt(int[][] input)
	{

			for(int[] i:input)
			{
				for(int j :i)
				System.out.print(j +" ");
				System.out.println();
			}
			System.out.println();

	}
	public static void printArrInt(int[] input)
	{

			for(int i:input)
			{
				System.out.print(i);
			}
			System.out.println();

	}
	public static void printLindedList(ListNode head)
	{
		while(head!=null)
		{
			System.out.print(head.val);
			System.out.print("->");
			head = head.next;
		}
		System.out.println();
	}
}
