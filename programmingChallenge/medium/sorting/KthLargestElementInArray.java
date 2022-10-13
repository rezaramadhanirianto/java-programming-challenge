package programmingChallenge.medium.sorting;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
// https://www.geeksforgeeks.org/quickselect-algorithm/
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot < index) start = pivot + 1;
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }

    public int partition(int[] values, int low, int high){
        int i = low - 1;
        int pivot = values[high];
        for(int j = low; j < high; j++){
            if(values[j] <= pivot){
                i++;
                swap(values, j, i);
            }
        }
        swap(values, i+1, high);
        return i+1;
    }

    public void swap(int[] nums, int from, int destination){
        int temp = nums[from];
        nums[from] = nums[destination];
        nums[destination] = temp;
    }
}
