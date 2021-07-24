package personal.wuyi.leetcode.p021;

public class MySolution2 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1.next == null && l2.next == null) {
            if (l2.val < l1.val) {
                l2.next = l1;
                return l2;
            } else {
                l1.next = l2;
                return l1;
            }
        } else {
            ListNode head = null;
            
            ListNode p1 = l1;
            ListNode p2 = l2;
            
            if (p1.val < p2.val) {
                head = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                head = new ListNode(p2.val);
                p2 = p2.next;
            }
            
            ListNode ph = head;
            
            while (p1 != null || p2 != null) {
                if (p1 == null && p2 != null) {
                    ph.next = new ListNode(p2.val);
                    p2 = p2.next;
                    ph = ph.next;
                } else if (p1 != null && p2 == null) {
                    ph.next = new ListNode(p1.val);
                    p1 = p1.next;
                    ph = ph.next;
                } else {
                    if (p1.val < p2.val) {
                        ph.next = new ListNode(p1.val);
                        p1 = p1.next;
                        ph = ph.next;
                    } else {
                        ph.next = new ListNode(p2.val);
                        p2 = p2.next;
                        ph = ph.next;
                    }
                }
            }
            
            return head;
        }
    }
}
