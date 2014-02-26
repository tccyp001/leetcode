
public class ReverseBetween {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		//reverseBetween(n1,1,2);
		OutputHelper.printLindedList(n1);
		ListNode ret = reverseKGroup(n1,2);
		OutputHelper.printLindedList(ret);
	}
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHeader = new ListNode(0);
        dummyHeader.next = head;
        
        ListNode cur = head;
        ListNode pre_h = null;
        ListNode pre = dummyHeader;
        for(int i=0;i<n;i++)
        {
            if(i==m-1)pre_h = pre;
            else if(i>=m)
            {
                pre.next = cur.next;
                cur.next = pre_h.next;
                pre_h.next = cur;
                cur = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummyHeader.next;
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null|| k<2)return head;
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fh = dummyHead;
        for(int i = 0;i<k;i++)
        {
            fh = fh.next;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        ListNode lastH = dummyHead;

        while(fh!=null)
        {
            while(lastH.next!=fh)
            {
                pre.next = cur.next;
                cur.next = lastH.next;
                lastH.next = cur;
                cur = pre.next;
            }
            lastH = pre;
            fh = pre;

            for(int i = 0;i<k;i++)
            {
                if(fh==null)return dummyHead.next;
                fh = fh.next;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummyHead.next;
        
        
    }
}
