package personal.wuyi.leetcode.p021;

/**
 * This solution is based on misunderstanding the description
 * This solution is based on just merge list1 and list2 without comparing the value
 */
public class MySolution1 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1.next == null && l2.next == null) {
            l1.next = l2;
            return l1;
        } else {
            ListNode head = l1;
        
            ListNode p1_1 = l1;
            ListNode p1_2 = l1.next;
            ListNode p2_1 = l2;
            ListNode p2_2 = l2.next;
        
            while (p1_1 != null || p2_1 != null) {
                if (p1_1 != null) {
                    p1_1.next = p2_1;
                }
                if (p2_2 != null && p1_2 == null) {
                    return head;
                } else {
                    p2_1.next = p1_2;
                }
            
                p1_1 = p1_2;
                p2_1 = p2_2;
                
                if (p2_1 == null && p1_1 != null) {
                    return head;
                }
                if (p2_1 == null && p1_1 == null) {
                    return head;
                }
                
                p1_2 = p1_1.next;
                p2_2 = p2_1.next;
            }
            
            return head;
        }
    }
}
