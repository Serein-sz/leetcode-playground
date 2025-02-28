package L2025.L02.L2353;

import utils.Pair;

import java.util.*;

/**
 * @author 王强
 * @since 2025/2/28
 */
public class Main {
    public static void main(String[] args) {

    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
class FoodRatings {

    private final Map<String, Pair<Integer, String>> foodMap;

    private final Map<String, PriorityQueue<Pair<Integer, String>>> ratingMap;

    private final int n;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        n = foods.length;
        foodMap = new HashMap<>();
        ratingMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            foodMap.put(food, new Pair<>(rating, cuisine));
            ratingMap.computeIfAbsent(cuisine, k -> new PriorityQueue<>((a, b) -> {
                if (!a.getKey().equals(b.getKey())) {
                    return a.getKey() - b.getKey();
                }
                return a.getValue().compareTo(b.getValue());
            })).add(new Pair<>(n - rating, food));
        }
    }

    public void changeRating(String food, int newRating) {
        Pair<Integer, String> pair = foodMap.get(food);
        String cuisine = pair.getValue();
        ratingMap.get(cuisine).add(new Pair<>(n - newRating, food));
        foodMap.put(food, new Pair<>(newRating, cuisine));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Pair<Integer, String>> q = ratingMap.get(cuisine);
        while (!q.isEmpty()) {
            Pair<Integer, String> top = q.peek();
            String food = top.getValue();
            if (n - top.getKey() == foodMap.get(food).getKey()) {
                return food;
            }
            q.poll();
        }
        return "";
    }
}

