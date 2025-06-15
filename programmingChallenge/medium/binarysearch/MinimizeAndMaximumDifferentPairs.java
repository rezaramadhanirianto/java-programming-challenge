package programmingChallenge.medium.binarysearch;

import java.util.Arrays;

public class MinimizeAndMaximumDifferentPairs {
    public static void main(String[] args) {
        int[] nums1 = {10, 1, 2, 7, 1, 3};
        int p1 = 2;
        MinimizeAndMaximumDifferentPairs solution = new MinimizeAndMaximumDifferentPairs();
        System.out.println(solution.minimizeMax(nums1, p1));

        int[] nums2 = {4, 2, 1, 2};
        int p2 = 1;
        System.out.println(solution.minimizeMax(nums2, p2));

        int[] nums3 = {1, 5, 3, 9, 7};
        int p3 = 2;
        System.out.println(solution.minimizeMax(nums3, p3));
    }
    
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n-1] - nums[0];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFormPairs(nums, mid, p)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFormPairs(int[] nums, int maxDiff, int p) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                count++;
                i++;
            }
        }
        return count >= p;
    }
    
}