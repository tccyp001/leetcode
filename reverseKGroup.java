
public class reverseKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		
		n1.next = n2;
		n2.next = n3;
		
		
		reverseKGroup ins = new reverseKGroup();
		ListNode ret =ins.reverseKGroup1(n1, 2);
		OutputHelper.printLindedList(ret);
	}
    public ListNode reverseKGroup1(ListNode head, int k) {
        if(k == 1||head == null)return head;
        
        ListNode dummyHeader = new ListNode(-1);
        dummyHeader.next = head;
  
        ListNode sNode = dummyHeader;
        ListNode eNode = null;
        ListNode nextStart = null;
        while(sNode !=null)
        {
            eNode = getNextK(sNode,k);
            
            if(eNode==null)return dummyHeader.next;
            
            nextStart = sNode.next;
            reverseBetween(sNode, eNode.next);
            sNode = nextStart;
        }
        return dummyHeader.next;
    }
    public void reverseBetween(ListNode start, ListNode end)
    {
        ListNode p1 = start.next;
        if(p1==null)return;
        ListNode p2 = p1.next;
        while(p2!=end)
        {
            p1.next = p2.next;
            p2.next = start.next;
            start.next = p2;
            p2 = p1.next;
        }
    }
    public ListNode getNextK(ListNode node , int k)
    {
        while(k>0 && node !=null)
        {
            k--;
            node = node.next;
        }
        if(k>0)return null;
        return node;
    }
}
