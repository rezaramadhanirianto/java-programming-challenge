package programmingChallenge.easy.tree;

import programmingChallenge.utils.ListNode;
import programmingChallenge.utils.TreeNode;

// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
public class ConvertListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBSTHelper(head, null);
    }

    TreeNode sortedListToBSTHelper(ListNode head, ListNode tail){
        ListNode fast = head, slow = head;
        if(head == tail) return null;
        while(fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBSTHelper(head, slow);
        node.right = sortedListToBSTHelper(slow.next, tail);
        return node;
    }
}
