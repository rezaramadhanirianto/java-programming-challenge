package programmingChallenge.easy.math;

// https://leetcode.com/problems/pass-the-pillow/
public class PassThePillow {
    public int passThePillow(int n, int time) {
        int round = time/(n-1);
        int left = time % (n-1);
        return (round % 2 == 0) ? left+1 : n-left;
    }
}
