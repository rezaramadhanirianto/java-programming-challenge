package programmingChallenge.unclassified;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array A of size n.You Choose subarray of size 1,2 and 3 at most x,y and z times respectively. sum the values in all chooses subarrays. find the maximum sum possible
 * . Note can also skip choosing one of the subarrays.
 * n<=100, x,y,z<=20
 *
 * Example -
 * 1 2 3 4 5 , x=1,y=1,z=1
 *
 * choose (1,2,3) and (4,5)
 * or (1,2) and (3,4,5)
 * for maximum
 * sum = 15 . Here we didn't choose 1 size
 * **/
public class MaximumPossibleSumOfXYZ {
    int maximumPossibleSumOfXYZ(List<Integer> arr){
        arr.sort(Collections.reverseOrder());
        int res = 0;
        for(int i = 0; i < Math.min(arr.size(), 6); i++){
            res += arr.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        var main = new MaximumPossibleSumOfXYZ();
        var list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        var res = main.maximumPossibleSumOfXYZ(list);
        System.out.println(res); // expected 15
    }
}
