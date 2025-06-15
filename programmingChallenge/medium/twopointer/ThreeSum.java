package programmingChallenge.medium.twopointer;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 * Note: doesn't matter with the order of the triplets and output.
 * */
public class ThreeSum {

    // bruteforce solution
    // O(N³)
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();

        for(int i =0; i<=nums.length-1; i++) {

            for(int j=1; j<=nums.length-1; j++) {

                for(int k=2; k<=nums.length-1; k++) {
                    if(k != j && j != i && i != k && (nums[i] + nums[j] + nums[k] == 0)) {

                        List<Integer> triplet = new ArrayList<>();

                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        // sort to make unique triplet
                        triplet.sort(null);

                        if(!set.contains(triplet)) {
                            set.add(triplet);
                            list.add(triplet);
                        }
                    }

                }
            }
        }

        return list;
    }

    // 0 (N²)
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList();
        for(int i = 0; i + 2 < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            // sum = -nums[i]
            // ex: 1 -> -1,
            // -2 -> 2
            int low = i + 1, high = nums.length - 1, sum = -nums[i];
            // two pointer for last 2 number
            while(low < high){
                // this code same with nums[low] + nums[high] + nums[i] == 0
                // because we set sum = "-" nums[i]
                // ex: 1 + 1 = 2 ( -nums[i] -> - (-2))
                if(nums[low] + nums[high] == sum){
                    list.add(Arrays.asList(nums[low], nums[high], nums[i]));

                    // we value same let increase value -> because we want unique value in same index
                    // ex: [-2, 0,1,1,2]
                    // low = 1 -> low = 2 -> low = 3 -> continue
                    do{
                        low++;
                    } while(low < high && nums[low] == nums[low - 1]);

                    do {
                        high--;
                    } while(low < high && nums[high] == nums[high + 1]);

                    // same code with above
                    // ex: [-2, 0, 1, 1, 2]
                    // index, value ->
                    // start while (low)
                    // 2, 1
                    // 3, 1
                    // end while
                    // while (low < high && nums[low] == nums[low+1]) low++;
                    // while (low < high && nums[high] == nums[high-1]) high--;
                    // 4, 2
                    // low++; high--;
                } else if(nums[low] + nums[high] > sum){
                    high--;
                }else{
                    low++;
                }
            }
        }
        return list;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                sum *= -1;
                if(map.containsKey(sum)){
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(sum);
                    res.add(list);
                }
            }
            map.put(nums[i], i);
        }

        return new ArrayList(res);
    }
}
