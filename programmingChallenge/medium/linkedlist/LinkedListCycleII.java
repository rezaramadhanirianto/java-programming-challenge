package programmingChallenge.medium.linkedlist;

import programmingChallenge.utils.ListNode;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
