package programmingChallenge.medium.twopointer;

import programmingChallenge.utils.ListNode;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // If we found linked list, the owner of this solution suggest that we created dummy node
        // I think because to prevent case [1] because .next is null and .next.next can be null pointer
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start, fast = start;
        // set fast to n +1
        // [1,2,3,4,5]
        // n = 2 -> node that need to delete is 4
        // fast = 3
        // fast [3,4,5]
        // slow [1,2,3] -> right? it shows previous node we want to delete
        for(int i = 1; i <= n + 1; i++){
            fast = fast.next;
        }
        // if fast null that can be slow is previous node that we want to delete
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;

    }
}
