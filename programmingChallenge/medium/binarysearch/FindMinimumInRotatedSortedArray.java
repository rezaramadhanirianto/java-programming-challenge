package programmingChallenge.medium.binarysearch;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] < nums[high]){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return nums[high];
    }
}
