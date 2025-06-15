package programmingChallenge.hard.hashtable;

import java.util.*;

public class RearrangingFruits {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int c: basket1)
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        for (int c: basket2)
            cnt.put(c, cnt.getOrDefault(c, 0) - 1);
        List<Integer> last = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e: cnt.entrySet()) {
            int v = e.getValue();
            if (v % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(v) / 2; ++i)
                last.add(e.getKey());
        }
        int minx = Math.min(Arrays.stream(basket1).min().getAsInt(), Arrays.stream(basket2).min().getAsInt());
        Collections.sort(last);
        long res = 0;
        for (int i = 0; i < last.size() / 2; ++i) res += Math.min(last.get(i), minx * 2);
        return res;

    }
}
