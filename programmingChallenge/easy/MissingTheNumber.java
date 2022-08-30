package programmingChallenge.easy;

// https://leetcode.com/problems/missing-number/
// input: [3,0,1]
public class MissingTheNumber {
    public static void main(String[] args){
        solution(new int[]{1,2,3,4,5,6,8,9});
    }

    public static void solution(int[] arr){
        var missingTheNumber = new MissingTheNumber();
        System.out.println(missingTheNumber.missingNumber(arr));
        System.out.println(missingTheNumber.missingNumber2(arr));
    }

    public int missingNumber(int[] nums) {
        int total = 0;
        int i = 0;
        for(; i < nums.length; i++){
            total -= nums[i];
            total += i;
        }
        return total + i;
    }

    public int missingNumber2(int[] nums){
        int n = nums.length;
        // formula arithmetic progression
        int total = n * (n + 1) / 2;
        for(int num: nums)
            total -= num;
        return total;
    }
}
