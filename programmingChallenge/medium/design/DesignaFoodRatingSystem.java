package programmingChallenge.medium.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

// https://leetcode.com/problems/design-a-food-rating-system/
public class DesignaFoodRatingSystem {
    Map<String, TreeMap<Integer, TreeSet<String>>> map = new HashMap();
    Map<String, String> foodCuisine = new HashMap();
    Map<String, Integer> foodRating = new HashMap();
    public DesignaFoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for(int i = 0; i < n; i++){
            map.putIfAbsent(cuisines[i], new TreeMap<>());
            map.get(cuisines[i]).putIfAbsent(ratings[i], new TreeSet<>());

            map.get(cuisines[i]).get(ratings[i]).add(foods[i]);
            foodCuisine.put(foods[i], cuisines[i]);
            foodRating.put(foods[i], ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        TreeMap<Integer, TreeSet<String>> mapRating = map.get(foodCuisine.get(food));
        int currRating = foodRating.get(food);

        mapRating.get(currRating).remove(food);
        if(mapRating.get(currRating).size() == 0) mapRating.remove(currRating);
        mapRating.putIfAbsent(newRating, new TreeSet<>());
        mapRating.get(newRating).add(food);
        foodRating.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        return map.get(cuisine).get(map.get(cuisine).lastKey()).first();
    }
}
