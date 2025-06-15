package programmingChallenge.medium.math;

// https://leetcode.com/problems/reach-a-number/
public class ReachNumber {
    public int reachNumber(int target) {
        target = Math.max(target, -target);
        int sum = 0, step = 0;
        while(true){
            sum += ++step;
            if(sum == target) return step;
            else{
                if(sum > target && (sum - target) %2 == 0) return step;
            }
        }
    }
}
