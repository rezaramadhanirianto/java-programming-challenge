package programmingChallenge.easy.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-target-indices-after-sorting-array/
public class FindTargetIndicesAfterSorting {
    // O(N Log N + N + N)
    // binary search approach
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            // these two code line below to get first target
            // ex: [1,2,2,4] target = 2
            // return 1;
            // if you want to get last target instead you can
            // if(nums[mid] <= target) low = mid + 1;
            //  else high = mid - 1;
            if(nums[mid] >= target) high = mid -1;
            else low = mid + 1;
        }
        ArrayList<Integer> output = new ArrayList();
        for(int i = low; i < nums.length; i++){
            if(nums[i] == target) output.add(i);
            else break;
        }
        return output;
    }


//     O(N)
//     public List<Integer> targetIndices(int[] nums, int target) {
//         int count = 0, less = 0;
//         for(int num: nums){
//             if(target == num) count++;
//             else if(target > num) less++;
//         }

//         ArrayList<Integer> output = new ArrayList();
//         while(count > 0){
//             output.add(less++);
//             count--;
//         }
//         return output;
//     }
}
