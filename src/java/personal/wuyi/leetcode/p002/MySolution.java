package personal.wuyi.leetcode.p002;

public class MySolution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head  = null;
        int      cd    = 0;
        boolean  plus1 = false;
        
        if (l1 != null) {
            cd = l1.val;
            l1 = l1.next;
        }
            
        if (l2 != null) {
            cd = cd + l2.val;
            l2 = l2.next;
        }
        
        if (cd < 10) {
            head = new ListNode(cd);
        } else {
            head = new ListNode(cd - 10);
            plus1 = true;
        }
        
        ListNode it1 = head;
        ListNode it2 = null;
        cd = 0;
        while (l1 != null || l2 != null || plus1) {
            if (l1 != null) {
                cd = l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                cd = cd + l2.val;
                l2 = l2.next;
            }
            
            if (plus1) {
                cd = cd + 1;
                plus1 = false;
            }
            
            if (cd < 10) {
                it2 = new ListNode(cd);
            } else {
                it2 = new ListNode(cd - 10);
                plus1 = true;
            }
            
            it1.next = it2;
            it1      = it2;
            it2      = null;
            cd       = 0;
        }
        
        return head;
    }
}
