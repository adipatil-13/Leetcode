class FoodRatings {
    private Map<String, String> foodToCuisine = new HashMap<>();
    private Map<String, Integer> foodToRating = new HashMap<>();
    private Map<String, TreeSet<Food>> cuisineToRatings = new HashMap<>();

    private class Food implements Comparable<Food> {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        public int compareTo(Food other) {
            if (this.rating != other.rating) {
                return other.rating - this.rating; //Descending
            }
            return this.name.compareTo(other.name); //Lexicographic
        }

        public boolean equals(Object o) {
            if (o instanceof Food) {
                Food f = (Food) o;
                return name.equals(f.name);
            }
            return false;
        }

        public int hashCode() {
            return name.hashCode();
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToRatings
                .computeIfAbsent(cuisine, k -> new TreeSet<>())
                .add(new Food(food, rating));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);
        TreeSet<Food> set = cuisineToRatings.get(cuisine);

        set.remove(new Food(food, oldRating));
        set.add(new Food(food, newRating));
        foodToRating.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        return cuisineToRatings.get(cuisine).first().name;
    }
}