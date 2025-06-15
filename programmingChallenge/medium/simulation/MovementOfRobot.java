package programmingChallenge.medium.simulation;

import java.util.Arrays;

// https://leetcode.com/problems/movement-of-robots/description/
public class MovementOfRobot {
    // Let us ignore any collisions, and just imagine all robots simply passed through each other, as if they were ghosts. Then now we can simply just subtract the distance from them if they were going left or add the distance to them if they were going right. Now, we simply need to compute the distance between each pair of robots.
    // If we have the array [7, 5, 3, 1] and we want to calculate the sum of the distances, we do:
    //
    // (7-5) + (7-3) + (7-1) = 2 + 4 + 6 = 12
    // (5-3) + (5-1) = 2 + 4 = 6
    // (3-1) = 2
    // 12 + 6 + 2 = 20 (this is n^2, which isn't good enough)
    // However, with some math manipulation (extract common factor), we can see that 1, 2, and 3 can become:
    //
    // (7*3) - (5+3+1) = 21 - 9 = 12 (common factor is 7)
    // (5*2) - (3+1) = 10 - 4 = 6 (common factor is 5)
    // (3*1) - (1) = 3 - 1 = 2 (common factor is 3)
    // In this case, for each iteration, we do (nums[i] * i) - (sum(i->size-1) which can be calculated in O(1)
    public int sumDistance(int[] nums, String s, int d) {
        for(int i = 0; i < nums.length; i++){
            nums[i] += d * (s.charAt(i) == 'L' ? -1 : 1);
        }

        Arrays.sort(nums);
        long pref = 0, res = 0;
        for(int i = 0; i < nums.length; i++){
            res += i * (long) nums[i] - pref;
            res %= 1_000_000_007;
            pref += nums[i];
        }
        return (int) res;
    }
}
