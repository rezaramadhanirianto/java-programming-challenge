package programmingChallenge.medium.heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/k-th-smallest-prime-fraction/
public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a, b) -> (a[0] > b[0]) ? 1 : (a[0] == b[0]) ? 0 : -1);
        int n = arr.length;
        int[] res = new int[2];
        for(int i = 0; i < n-1; i++) pq.add(new double[]{(double)arr[i]/arr[n-1], i, n-1});
        while(k-- > 0 && !pq.isEmpty()){
            double[] curr = pq.poll();
            int first = (int) curr[1];
            int sec = (int) curr[2];
            res = new int[]{arr[first], arr[sec]};

            int nextId = (int) curr[2]-1;
            if(nextId > first) pq.add(new double[]{(double)arr[first]/arr[nextId], first, nextId});
        }
        return res;
    }
}
