package programmingChallenge.easy.twopointer;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        while(slow < fast && fast < nums.length){
            while( fast < nums.length && nums[slow] == nums[fast]) fast++;
            if(fast < nums.length) nums[++slow] = nums[fast++];
        }

        return slow + 1;
    }
}
