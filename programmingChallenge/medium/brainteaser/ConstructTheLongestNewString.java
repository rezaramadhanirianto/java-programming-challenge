package programmingChallenge.medium.brainteaser;

// https://leetcode.com/problems/construct-the-longest-new-string/solutions/3677618/java-c-python-1-line-o-1/
public class ConstructTheLongestNewString {
    int longestString(int x, int y, int z) {
        int min = Math.min(x, y);
        if (x == y) return ((4 * x) + (2 * z));
        else return ((2 * min) + ((min + 1) * 2) + (2 * z));
    }
}
