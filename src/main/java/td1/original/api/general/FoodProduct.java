package td1.original.api.general;

public interface FoodProduct extends FoodConstituent, Product {
    default double calories(){
        return weight() / 100 * calories_per_100g();
    }
}
