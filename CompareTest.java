import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class CompareTest {

	 public static class MyComp implements Comparator<ListNode> {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return Integer.compare(o1.val, o2.val);
			}
		}
	    public ListNode mergeKLists(ArrayList<ListNode> lists) {
	        PriorityQueue<ListNode> pqueue = new PriorityQueue<ListNode>(10,new MyComp());
	        
	        ListNode dummyHeader = new ListNode(-1);
	        ListNode cur = dummyHeader;
	        int val = 0;

	        boolean isContinue = true;
	        while(isContinue)
	        {
	            isContinue = false;
	            for(int i =0;i<lists.size();i++)
	            {
	            	ListNode node = lists.get(i);
	                if(node == null) continue;
	                
	                isContinue = true;
	                pqueue.offer(node);
	                lists.set(i, node.next);
	            }
	            while(!pqueue.isEmpty())
	            {
	                cur.next = pqueue.poll();
	                cur = cur.next;
	            }
	        }
	        return dummyHeader.next;
	        
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		ListNode n1 = new ListNode(1);
		lists.add(n1);
		CompareTest ins = new CompareTest();
		ins.mergeKLists(lists);
	}

}
