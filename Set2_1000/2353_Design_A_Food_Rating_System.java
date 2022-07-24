class FoodRatings {

    private Map<String, PriorityQueue<Food>> fromCuisine;
    private Map<String, Food> fromFoodName;
    private String [] foods;
    private String [] cuisines;
    private int [] ratings;
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        fromCuisine = new HashMap<>();
        fromFoodName = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            Food current = new Food(ratings[i], cuisines[i], foods[i]);
            fromCuisine.putIfAbsent(cuisines[i], new PriorityQueue<>((a,b)->
            b.rating==a.rating ? a.food.compareTo(b.food) : Integer.compare(b.rating, a.rating)));
            PriorityQueue<Food> currentFood = fromCuisine.get(cuisines[i]);
            currentFood.add(current);
            fromFoodName.put(foods[i], current);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food currentFood = fromFoodName.get(food);
        PriorityQueue<Food> current = fromCuisine.get(currentFood.cuisine);
        current.remove(currentFood);
        currentFood.rating = newRating;
        current.add(currentFood);
        
    }
    
    public String highestRated(String cuisine) {
        return fromCuisine.get(cuisine).peek().food;
    }
}

class Food {
    int rating;
    String cuisine;
    String food;
    public Food(int rating, String cuisine, String food) {
        this.rating = rating;
        this.cuisine = cuisine;
        this.food = food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */