
public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		sortList(node1);
		System.out.println("2");
		
	}
	  public static ListNode sortList(ListNode head) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        ListNode node = new ListNode(0);
	        node.next = head;
	        sortListSub(node,null);
	        return node.next;
	    }
	      public static void sortListSub(ListNode start, ListNode end) {
	          if(start.next == null)return;
	          if(start.next == end)return;
	          ListNode pivot = start.next;
	          ListNode cur = pivot.next;
	          if(cur == null)return;
	          ListNode prev = pivot;
	          while(cur!=end)
	          {
	              if(cur.val<pivot.val)
	              {
	                  prev.next = cur.next;
	                  cur.next = start.next;
	                  start.next = cur;
	                  cur = prev.next;
	              }
	              else
	              {
	                  cur = cur.next;
	                  prev = prev.next;
	              }
	          }
	          sortListSub(start, pivot);
	          sortListSub(pivot, end);
	          
	      }
}
