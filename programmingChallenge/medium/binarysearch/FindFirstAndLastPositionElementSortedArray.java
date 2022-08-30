package programmingChallenge.medium.binarysearch;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// [5,7,7,8,8,10]
// 8
public class FindFirstAndLastPositionElementSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int startIndex = -1;
        int endIndex = -1;
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= target) high = mid - 1;
            else low = mid + 1;

            if(nums[mid] == target) startIndex = mid;
        }

        high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] <= target) low = mid + 1;
            else high = mid - 1;

            if(nums[mid] == target) endIndex = mid;
        }

        return new int[]{startIndex, endIndex};
    }
}
