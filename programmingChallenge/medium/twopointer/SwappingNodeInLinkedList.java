package programmingChallenge.medium.twopointer;

import programmingChallenge.utils.ListNode;

// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
// head = [1,2,3,4,5], k = 2
public class SwappingNodeInLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // find node before target in start position
        // head = [1,2,3,4,5], k = 2 -> [2...4]
        // prev.val = 1
        for(int i = 0; i < k - 1; i++) {
            prev = prev.next;
        }

        // find node before target in end position
        // head = [1,2,3,4,5], k = 2 -> [2...4]
        // prevNodeEndOfK.val = 3
        ListNode trav = prev.next.next, prevNodeEndOfK = dummy;
        while(trav != null) {
            trav = trav.next;
            prevNodeEndOfK = prevNodeEndOfK.next;
        }


        // declare variable that handle node of each target
        // targetStart = 2 -> 3 -> 4 -> 5, targetEnd = 4 -> 5
        ListNode targetStart = prev.next, targetEnd = prevNodeEndOfK.next;

        // set to target value
        // ex: 1 -> 2 -> 3 -> 4 -> 5
        // 1 -> 4 -> 5
        // 1 -> 4 -> 5 and 3 -> 2 -> 4 -> 5
        prev.next = targetEnd;
        prevNodeEndOfK.next = targetStart;

        // swap each next value
        // ex: prev case
        ListNode temp = targetEnd.next;
        // 3 -> 2 -> 5
        targetEnd.next = targetStart.next;
        // 1 -> 4 -> 3 -> ...
        targetStart.next = temp;

        return dummy.next;
    }

    public ListNode swapValues(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode fast = dummy, slow = dummy, first;
        dummy.next = head;
        for(int i = 0; i < k; i++) fast = fast.next;

        first = fast;
        // instead fast.next != null we should check fast != null because slow first node is dummy
        // that's why we got prev node not target node when we check as fast.next != null
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        int temp = first.val;
        first.val = slow.val;
        slow.val = temp;
        return head;
    }
}
