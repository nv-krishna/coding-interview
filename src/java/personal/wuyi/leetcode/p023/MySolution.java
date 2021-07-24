package personal.wuyi.leetcode.p023;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class MySolution {
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else {
            TreeMap<Integer, Queue<Integer>> sortedMap = new TreeMap<>();    // key:   the val of the head node of each list
                                                                             // value: the index of all the heads equal to that value
            boolean hasNonNullList = false;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (sortedMap.get(lists[i].val) == null) {
                        Queue<Integer> queue = new LinkedList<>();
                        queue.add(i);
                        sortedMap.put(lists[i].val, queue);
                    } else {
                        sortedMap.get(lists[i].val).add(i);
                    }
                    hasNonNullList = true;
                } 
            }
            
            if (!hasNonNullList) {
                return null;
            }
            
            // build the head
            Map.Entry<Integer, Queue<Integer>> entry = sortedMap.firstEntry();
            int index = entry.getValue().remove();
            ListNode head = new ListNode(lists[index].val);
            lists[index] = lists[index].next;
            if (lists[index] != null) {                        
                if (sortedMap.get(lists[index].val) == null) {
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(index);
                    sortedMap.put(lists[index].val, queue);
                } else {
                    sortedMap.get(lists[index].val).add(index);
                }
            }
            
            if (entry.getValue().peek() == null) {
                sortedMap.remove(entry.getKey());
            }
            
            ListNode current = head;
            
            while (sortedMap.size() > 0) {
                Map.Entry<Integer, Queue<Integer>> sEntry = sortedMap.firstEntry();
                int sIndex = sEntry.getValue().remove();
                ListNode newNode = new ListNode(lists[sIndex].val);
                lists[sIndex] = lists[sIndex].next;
                if (lists[sIndex] != null) {                        
                    if (sortedMap.get(lists[sIndex].val) == null) {
                        Queue<Integer> queue = new LinkedList<>();
                        queue.add(sIndex);
                        sortedMap.put(lists[sIndex].val, queue);
                    } else {
                        sortedMap.get(lists[sIndex].val).add(sIndex);
                    }
                }
                
                if (sEntry.getValue().peek() == null) {
                    sortedMap.remove(sEntry.getKey());
                }
                
                current.next = newNode;
                current = newNode;
            }
            
            return head;
        }
    }
}
