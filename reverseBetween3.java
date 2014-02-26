import java.util.PriorityQueue;


public class reverseBetween3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseBetween3 ins = new reverseBetween3();
		
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(5);
		n1.next = n2;
		ins.reverseBetween(n1,1,1);
	}
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)return null;
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        ListNode startPre = getKNode(dummyHead, m-1);
        ListNode end = getKNode(dummyHead, n);
        ListNode endNext = end.next;
        reverse(startPre.next, endNext);
        startPre.next.next = endNext;
        startPre.next = end;

        return dummyHead.next;
        
    }
    public ListNode getKNode(ListNode dummyHead, int k)
    {
        ListNode cur = dummyHead;
        while(k-->0)cur = cur.next;
        return cur;
    }
    public void reverse(ListNode start, ListNode end)
    {
        ListNode pre = null;
        ListNode cur = start;
        ListNode nextp = null;
        
        while(cur!=null&&cur!=end)
        {
            nextp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextp;
        }
    }
}
