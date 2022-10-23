package programmingChallenge.medium.linkedlist;

import programmingChallenge.utils.ListNode;

// https://leetcode.com/problems/insertion-sort-list/
// NOTE: I think this not really same with insertion sort in array
// like we don't have result value in insertion sort
// but in linked list that's not possible
// because if we change the first value how can we change the original value?
public class InsertionSortLinkedList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode fast = head;
        // ex:
        // fast => 4 -> 6
        while(fast != null){
            // set temporary next of fast node
            // next => 6
            ListNode next = fast.next;

            // find right place to place node
            // trav => dummy -> 1 -> 3 -> 5 | fast.val = 4
            // trav => 3 -> 5
            ListNode trav = dummy;
            while(trav.next != null && trav.next.val < fast.val) trav = trav.next;

            // set to make space O(1)
            // 4 -> 5
            fast.next = trav.next;
            // trav => 3 -> 4 -> 5
            trav.next = fast;

            fast = next;
        }
        return dummy.next;
    }
}
