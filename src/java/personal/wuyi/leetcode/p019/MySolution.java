package personal.wuyi.leetcode.p019;

public class MySolution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int step = removeNthFromEndRecur(head.next, n);
        
        if (n == 1){
            if (step == 0) {              // list only has one element
                head = null;
            } else if (step == 1) {
                head.next = null;
            } 
        } else if (step == n - 1) {       // remove first element
            head = head.next;
        } else if (step == n) {
            head.next = head.next.next;
        }
        return head;
    }
    
    public int removeNthFromEndRecur(ListNode head, int n) {
        if (head == null) {
            return 0;
        } else {
            int step = removeNthFromEndRecur(head.next, n);
            if (step == n) {
                if (n == 1) {                    // remove last element
                    head.next = null;
                } else {
                    head.next = head.next.next;
                }
                return step + 1;
            } else {
                return step + 1;
            }
        }
    }
}
