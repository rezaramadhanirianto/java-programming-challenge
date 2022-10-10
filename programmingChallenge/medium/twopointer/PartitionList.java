package programmingChallenge.medium.twopointer;

import programmingChallenge.utils.ListNode;

// https://leetcode.com/problems/partition-list/
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0), dummy2 = new ListNode(0);
        ListNode lower = dummy, greater = dummy2, trav = head;
        while(trav != null){
            if(trav.val < x){
                lower.next = trav;
                lower = lower.next;
            }else{
                greater.next = trav;
                greater = greater.next;
            }
            trav = trav.next;
        }
        greater.next = null;
        lower.next = dummy2.next;
        return dummy.next;
    }
}
