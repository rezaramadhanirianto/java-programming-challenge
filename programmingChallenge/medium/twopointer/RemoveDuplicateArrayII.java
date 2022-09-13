package programmingChallenge.medium.twopointer;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
// O (N)
public class RemoveDuplicateArrayII {
    // my solution
    public int removeDuplicates(int[] nums) {
        int prev = 0, index = 0, count = 0, output = 0;
        for(int num: nums){
            if(index < 2 || count < 2 || prev != num){
                if(prev != num) count = 0;
                nums[index++] = num;
                prev = num;
                count++;
                output++;
            }
        }
        return output;

    }

    // elegant solutions
    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for(int num: nums){
            if(i < 2 || num > nums[i -2]){
                nums[i++] = num;
            }
        }
        return i;
    }
}
