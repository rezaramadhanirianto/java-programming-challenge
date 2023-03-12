package programmingChallenge.unclassified;

/**
 * Find all subsequence of length K from an array whose final sum of subsequence is not divisible by 2.
 *
 * Sample Input
 * K = 3
 * 5 4 3 2 1
 *
 * Sample Output
 * 4
 *
 * Explanation
 * {5, 4, 2} & {5, 3, 1} & {4, 3, 2} & {4, 2, 1}
 *
 * **/
// O (2 ^ n)
// proof that is 2^n https://stackoverflow.com/a/59879165
public class FindDivisibleSubsequenceNotDivisibleBy2 {
    private static void solve(int[] nums, int k){
        int res = helper(nums, 0, 0, k);
        System.out.println(res);
    }

    static int helper(int[] nums, int i, int sum, int k){
        if(k == 0 && sum % 2 == 1) return 1;
        else if(k <= 0) return 0;

        int count = 0;
        for(; i < nums.length; i++){
            count += helper(nums, i + 1, sum + nums[i], k -1);
        }
        return count;
    }

    public static void main(String[] args) {
        solve(new int[]{5,4,3,2,1}, 3);
    }
}
