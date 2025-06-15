package programmingChallenge.hard.greedy;

// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
public class MinimumNumberOfTapsToOpenWaterGarden {
    public int minTaps(int n, int[] ranges) {
        int[] maxReach = new int[n+1];
        for(int i = 0; i < ranges.length; i++){
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            maxReach[start] = Math.max(maxReach[start], end);
        }

        int nextEnd = 0, currEnd = 0, res = 0;
        for(int i = 0; i <= n; i++){
            if(i > nextEnd) return -1;

            if(i > currEnd){
                currEnd = nextEnd;
                res++;
            }

            nextEnd = Math.max(nextEnd, maxReach[i]);
        }
        return res;
    }
}
