package programmingChallenge.medium.linkedlist;

import programmingChallenge.utils.ListNode;

// https://leetcode.com/problems/reorder-list/
public class ReOrderList {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;
        slow = temp;

        slow = reverse(slow);

        merge(head, slow);
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public void merge(ListNode from, ListNode dest){
        while(from != null && dest != null){
            ListNode temp = from.next;
            ListNode temp2 = dest.next;
            from.next = dest;
            dest.next = temp;

            from = temp;
            dest = temp2;
        }

    }
}
