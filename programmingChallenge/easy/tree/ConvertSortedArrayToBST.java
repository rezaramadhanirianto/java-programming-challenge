package programmingChallenge.easy.tree;

import programmingChallenge.utils.TreeNode;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
// useful explanation: https://www.youtube.com/watch?v=KEyRLtBfbLk
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return add(nums, 0, nums.length-1);
    }

    // imagine, always find mid to consider the parent:
    // 1 2 3 4 5 6
    //       3
    //     2   5
    //    1   4 6
    TreeNode add(int[] nums, int left, int right){
        if(left > right) return null;

        int mid = (left + right)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = add(nums, left, mid-1);
        node.right = add(nums, mid+1, right);
        return node;
    }
}
