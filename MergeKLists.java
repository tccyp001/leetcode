import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class MergeKLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(0);
		//node1.next = node2;
		ArrayList<ListNode> listNode = new ArrayList<ListNode>();
		listNode.add(node1);
		listNode.add(node2);

		ListNode n3 = mergeKLists(listNode);
		System.out.println("aaa");
	}
	 public static ListNode mergeKLists(ArrayList<ListNode> lists) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        ListNode start = new ListNode(0);
	        int max = Integer.MAX_VALUE;
	        int maxPos = -1;
	        boolean isContinue = true;
	        ListNode maxNode = null;
	        ListNode curNode = start;
	        while(isContinue)
	        {
	            max = Integer.MAX_VALUE;
	            isContinue = false;
	            for(int i =0;i<lists.size();i++)
	            {
	                ListNode node = lists.get(i);
	                if(node!=null && node.val<max)
	                {
	                    isContinue = true;
	                    max = node.val;
	                    maxNode = node;
	                    maxPos = i;
	                    
	                }
	            }
	            if(isContinue)
	            {
	            	lists.set(maxPos, maxNode.next);
	                curNode.next = maxNode;
	                curNode = curNode.next;
	            }
	        }
	        curNode.next = null;
	        
	        return start.next;
	       
	    }
	 
	 public static ListNode mergeKLists2(ArrayList<ListNode> lists) {
		 
		   Comparator<ListNode> comparator = new Comparator<ListNode>() {
		        @Override
		        public int compare(ListNode n1, ListNode n2) {
		            if (n1.val < n2.val)  return -1;
		            if (n1.val > n2.val)  return 1;
		            return 0;
		        }
		    };

		    PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);
	 
	 }
}
