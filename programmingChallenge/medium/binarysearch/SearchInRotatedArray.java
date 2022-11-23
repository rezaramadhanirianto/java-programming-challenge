package programmingChallenge.medium.binarysearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int n = nums.length, lo = 0,hi = n-1;
        while(lo<hi){
            int mid=(lo+hi)/2;

            if(nums[mid]== target) return mid;
            else if(nums[mid]>nums[hi]) lo=mid+1;
            else hi=mid;
        }

        if(target > nums[n-1]){
            hi = lo;
            lo = 0;
        }else{
            hi = n-1;
            lo = lo;
        }
        while(lo<=hi){
            int mid=(lo+hi)/2;

            if(nums[mid]== target) return mid;
            else if(nums[mid]<target) lo = mid+1;
            else hi = mid-1;
        }

        return -1;
    }
}
