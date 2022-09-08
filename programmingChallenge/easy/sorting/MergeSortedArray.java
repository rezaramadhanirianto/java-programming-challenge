package programmingChallenge.easy.sorting;

public class MergeSortedArray {
    // without extra space and two pointer
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while(tail2 >= 0){
            nums1[finished--] = (tail1 >= 0 && nums1[tail1] > nums2[tail2]) ? nums1[tail1--] : nums2[tail2--];
        }
    }


    // extra space
    public void merge2(int[] nums, int m, int[] nums2, int n) {
        int[] arr1 = new int[m];
        for(int i = 0; i < m; i++) arr1[i] = nums[i];

        int size = m + n;
        int left = 0, right = 0;
        for(int i = 0; i < size; i++){
            if(left >= m){
                nums[i] = nums2[right++];
            }else if(right >= n){
                nums[i] = arr1[left++];
            }else{
                if(arr1[left] < nums2[right]){
                    nums[i] = arr1[left++];
                }else{
                    nums[i] = nums2[right++];
                }
            }
        }
    }
}
