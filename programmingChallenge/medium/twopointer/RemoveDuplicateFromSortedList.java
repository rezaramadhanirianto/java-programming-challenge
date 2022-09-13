package programmingChallenge.medium.twopointer;

import programmingChallenge.utils.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RemoveDuplicateFromSortedList {
    // solution with 2 pointer
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while(fast != null){
            // set pointer to last duplicate item
            while(fast.next != null && fast.next.val == fast.val){
                fast = fast.next;
            }

            // duplicate found
            // ex: 1,2,2,3,3,4
            // slow -> 0 [1]
            // fast -> 2 [2]
            // slow.next != fast (memory check) -> false
            // --
            // slow.next = fast.next
            // slow.next = 2 [2]
            // slow.next = 5 [3]
            // --
            // ex: no duplicate found
            // slow -> 0 [1]
            // fast -> 6 [4]
            // slow.next == fast (memory check) -> true
            if(slow.next != fast){
                slow.next = fast.next;
                fast = fast.next;
            }else{
                slow = slow.next;
                fast = slow.next;
            }
        }
        return dummy.next;
    }

    // solution with count number
     public ListNode deleteDuplicates2(ListNode head) {
         if(head == null || head.next == null) return head;

         ListNode real = new ListNode(0);
         ListNode output = real;

         int count = 1;
         while(head != null){
             // count value that appear
             if(head.next == null || head.val != head.next.val){
                 if(count == 1){
                     real.next = new ListNode(head.val);
                     real = real.next;
                 }
                 count = 1;
             }else{
                 count++;
             }
             head = head.next;
         }

         return output.next;
     }
}
