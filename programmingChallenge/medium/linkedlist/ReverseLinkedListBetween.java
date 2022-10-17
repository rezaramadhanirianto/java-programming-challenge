package programmingChallenge.medium.linkedlist;

import programmingChallenge.utils.ListNode;

// https://leetcode.com/problems/reverse-linked-list-ii/
//
public class ReverseLinkedListBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int len = right - left;
        ListNode prevStart = dummy;
        while(left-- > 1) prevStart = prevStart.next;

        ListNode start = prevStart.next, prev = null;
        while(start != null && len-- >= 0){
            ListNode next = start.next;

            start.next = prev;
            prev = start;
            start = next;
        }

        prevStart.next = prev;
        while(prev.next != null) prev = prev.next;
        prev.next = start;
        return dummy.next;
    }

    // https://leetcode.com/problems/reverse-linked-list-ii/discuss/30666/Simple-Java-solution-with-clear-explanation
    // To clarify, all you're doing is inserting then between pre and pre.next. You keep moving then forward by 1 until you reach the difference, m - n, & you keep making start.next point to then.next to insure it's always pointing to the tail part of the list. Pretty simple lol.
    // https://leetcode.com/problems/reverse-linked-list-ii/discuss/30666/Simple-Java-solution-with-clear-explanation/143165
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < left; i++) pre = pre.next;

        ListNode start = pre.next;
        ListNode then = start.next;

        for(int i = 0; i < right - left; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
