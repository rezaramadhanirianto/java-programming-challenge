package programmingChallenge.medium.sorting;

import java.util.List;

// https://leetcode.com/problems/minimum-time-difference/
public class FindMinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        boolean[] bucket = new boolean[24*60];
        int min = 1441, max = -1;
        for(String timePoint: timePoints){
            String[] times = timePoint.split(":");
            int h = Integer.valueOf(times[0]);
            int m = Integer.valueOf(times[1]);
            int time = h*60+m;

            if(bucket[time]) return 0;
            bucket[time] = true;
            max = Math.max(max, time);
            min = Math.min(min, time);
        }

        int minDiff = Integer.MAX_VALUE;
        int prev = min;
        for(int i=min+1 ; i<=max ; i++){
            if(bucket[i]){
                minDiff = Math.min(minDiff, i - prev);
                prev = i;
            }
        }
        return minDiff;
    }
}
