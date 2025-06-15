package programmingChallenge.hard.greedy;

// https://leetcode.com/problems/super-washing-machines/description/
public class SuperWashingMachine {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int sum = 0;
        for(int machine: machines) sum += machine;
        if(sum % n != 0) return -1;
        int average = sum/n, res = 0, curr = 0;
        for(int machine: machines){
            int diff = machine - average;
            res = Math.max(diff, res);
            curr += diff;
            res = Math.max(res, Math.abs(curr));
        }
        return res;
    }
}
