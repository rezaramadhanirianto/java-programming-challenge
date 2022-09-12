package programmingChallenge.medium.twopointer;

import programmingChallenge.utils.ListNode;

// https://leetcode.com/problems/rotate-list/
public class RotateList {
    // O(N+M)
    public ListNode rotateRight(ListNode head, int n) {
        // default check
        if(head == null || head.next == null || n == 0) return head;
        ListNode trav = head;

        // get length of linked list
        int i = 1;
        while(trav.next != null){
            trav = trav.next;
            i++;
        }

        // create a cycle to linked list
        // ex: 1,2,3,4,5,1,2,3,4,5.....
        trav.next = head;

        // set pointer to last not rotated item
        // ex: 1,2,3,4,5 k = 2
        // pointer should be in "3"
        int rotated = i - n % i;
        while(rotated-- > 0){
            trav = trav.next;
        }

        // set head to pointer that linked list that rotated
        // ex: 1,2,3,4,5 k = 2
        // pointer should be in "4"
        // 4,5,1,2,3,4,5,1,2,3,4,5... (cuz cycle we created before)
        head = trav.next;
        // because we have a cycle list
        // set next to null
        // visual
        // head = 4 -> 5 -> 1 -> 2 -> 3 -> 4 ....
        // trav = 3 -> 4 -> 5 -> 1 -> 2 -> 3 -> 4 ....

        // when trav.next = null
        // trav = 3 -/> 4 -> 5 -> 1 -> 2 -> 3 -> null
        // head = 4 -> 5 -> 1 -> 2 -> 3 -> null because action "trav.next = null"
        trav.next = null;

        return head;
    }

    // O(N+M)
    // using dummy node to handle k = 0
    // using dummy node is safer because we manipulate item and pointer, that's why dummy is safer because
    // with dummy code we can check where the first pointer is
    public ListNode rotateRight2(ListNode head, int n) {
        // default check
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode trav = dummy;

        // get length of linked list
        int i = 0;
        while(trav.next != null){
            trav = trav.next;
            i++;
        }

        // create a cycle to linked list
        // ex: 1,2,3,4,5,1,2,3,4,5.....
        trav.next = dummy.next;

        // set pointer to last not rotated item
        // ex: 1,2,3,4,5 k = 2
        // pointer should be in "3"
        int rotated = i - n % i;
        while(rotated-- > 0){
            trav = trav.next;
        }

        dummy.next = trav.next;
        trav.next = null;
        return dummy.next;
    }
}
