
public class reverseList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseList ins = new reverseList();
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		//n2.next = n3;
		ins.reorderList(n1);
	}
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null)return ;
        ListNode dummyHeader = new ListNode(-1);
        dummyHeader.next = head;
        ListNode p1 = dummyHeader;
        ListNode p2 = dummyHeader;
        
        while(p1!=null)
        {
            p1 = p1.next;
            if(p1==null) break;
            
            p1 = p1.next;
            if(p1==null) break;
            p2 = p2.next;
        }
        
        ListNode tmp = p2.next;
        p2.next = null;
        ListNode l2 = reverse(tmp);
        merge(head,l2);
        
    }
    
    public ListNode reverse(ListNode node)
    {
        ListNode dummyHeader = new ListNode(-1);
     //   dummyHeader.next = node;
        
        ListNode cur = node;
        while(cur!=null)
        {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = dummyHeader.next;
            dummyHeader.next = tmp;
        }
        return dummyHeader.next;
    }
    public void merge(ListNode node1, ListNode node2)
    {
        ListNode dummyHeader = new ListNode(-1);
        ListNode cur = dummyHeader;
        while(node1 !=null&& node2!=null)
        {
            cur.next = node1;
            cur = node1;
            if(cur == null)break;
            node1 = node1.next;
            cur.next = node2;
            cur = node2;
            node2 = node2.next;
        }
        
    }
}
