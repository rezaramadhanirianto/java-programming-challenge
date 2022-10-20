package programmingChallenge.medium.sorting;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/largest-number/
public class LargestNumber {
    public String largestNumber(int[] nums) {
        Integer[] sorted = Arrays.stream( nums ).boxed().toArray( Integer[]::new );
        Arrays.sort(sorted, (Comparator<Integer>) (num1, num2) -> {
            String str = "" + num1 + num2;
            String str2 = "" + num2 + num1;

            // overflow because there has really big integer
            // return Integer.valueOf(str2) - Integer.valueOf(str);
            return str2.compareTo(str);
        });

        if(sorted[0] == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for(int s: sorted) sb.append(s);
        return sb.toString();
    }
}
