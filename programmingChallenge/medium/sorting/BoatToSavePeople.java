package programmingChallenge.medium.sorting;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/
public class BoatToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0, high = people.length-1;
        int boat = 0;


        // instead we maintain the lowest number to check next number, why dont we maintain largest number that
        // if we do that we only check the unvisited smallest number that fit to largest number to make boat 2 people
        // why set small or equals
        // 1 2 2 limit -> 3
        // low high
        //  0   2
        //  1   1 -> no worries, cuz ouput doesnt depends to value low or high
        // [1,2], [2]
        // low high
        //  0   2
        //  0   1
        //  0.  0
        // 1 3 3 limit -> 3
        // [3] [3] [1]
        while(low <= high){
            boat++;
            if(people[low] + people[high] <= limit) low++;
            high--;
        }
        return boat;
    }
}
