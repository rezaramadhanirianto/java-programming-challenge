package programmingChallenge.medium.sorting;

import programmingChallenge.utils.ListNode;

// https://leetcode.com/problems/sort-list/
public class LinkedListSorting {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode node){
        if(node == null || node.next == null) return node;

        ListNode right = getMiddle(node);
        ListNode nextToMiddle = right.next;
        right.next = null;

        ListNode right2 = mergeSort(nextToMiddle);
        ListNode left2 = mergeSort(node);

        return merge(right2, left2);
    }

    public ListNode getMiddle(ListNode node){
        ListNode fast = node, slow = node;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode right, ListNode left){
        ListNode dummy = new ListNode(0), output = dummy;
        while(right != null && left != null){
            if(right.val > left.val){
                output.next = left;
                left = left.next;
            }else{
                output.next = right;
                right = right.next;
            }
            output = output.next;
        }

        if(right != null){
            output.next = right;
        } else if(left != null){
            output.next = left;
        }
        return dummy.next;
    }


//     Insertion Sort
//     Time limit because handle worst case ex: 5000,1,2,3,4,5,6,....4999
//     public ListNode sortList(ListNode head) {
//         ListNode dummy = new ListNode(0);
//         ListNode trav = head;
//         while(trav != null){
//             ListNode next = trav.next, prev = dummy;
//             while(prev.next != null && prev.next.val < trav.val) prev = prev.next;

//             trav.next = prev.next;
//             prev.next = trav;
//             trav = next;
//         }
//         return dummy.next;
//     }
}
