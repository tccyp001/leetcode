
public class addTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(8);
		n1.next = n2;
		ListNode n3 = new ListNode(0);
		addTwoNumbers(n1,n3);
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;
        ListNode head = l1;
        ListNode last = l1;
        while(l1!=null || l2!=null)
        {
            int l1val = l1==null?0:l1.val;
            int l2val = l2==null?0:l2.val;
            int val = l1val+l2val + carry;
            carry = val/10;
            l1.val = val%10;
            last = l1;
            if(l1!=null && l1.next==null && l2!=null)
            {
                l1.next = l2.next;
                l2.next = null;
            }
  
                
            if(l1!=null)l1 = l1.next;
            if(l2!=null) l2 = l2.next;
            
        }
        if(carry ==1)
        {
        	last.next = new ListNode(1);
        }
        return head;
    }
}
