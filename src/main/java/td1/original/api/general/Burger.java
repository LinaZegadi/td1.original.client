package td1.original.api.general;


import java.util.List;

public class Burger implements FoodProduct
{

    String name;
    List<FoodProduct> items;
    String menu;
    Boolean onions;
    Boolean cheese;
    Sauce.SauceType sauce;
    String size;


    public Burger(String name, List<FoodProduct> items) {
        this.name = name;
        this.items = items;
    }

    public Burger(String name, String menu, Boolean onions, Boolean cheese, Sauce.SauceType sauce) {
        this.name = name;
        this.menu= menu;
        this.onions= onions;
        this.cheese = cheese;
        this.sauce = sauce;
    }

    public Burger(String name, String menu, Boolean onions, Boolean cheese, Sauce.SauceType sauce, String size) {
        this.name = name;
        this.menu= menu;
        this.onions= onions;
        this.cheese = cheese;
        this.sauce = sauce;
        this.size = size;

    }

    @Override
    public double calories(){
        return items.stream().map(FoodProduct::calories).reduce(0.0,Double::sum);
    }
    @Override
    public double weight() {
        return items.stream().map(Product::weight).reduce(0.0, Double::sum);
    }

    @Override
    public double price() {
        return items.stream().map(Product::price).reduce(0.0, Double::sum);
    }
    @Override
    public double calories_per_100g() {
        return calories() / weight() * 100;

    }

    @Override
    public String toString() {
        final String DELIM = "--------------------\n";
        StringBuilder buffer = new StringBuilder();
        buffer.append(String.format("*** Menu %s ***\n", name));
        for (Object item : items) {
            buffer.append(String.format("- %s\n", item));
        }
        buffer.append(DELIM);
        buffer.append(String.format("price:         %.2f\n", price()));
        for (Object item : items) {
            buffer.append(String.format("- %s\n", item));
        }
        buffer.append(DELIM);

        buffer.append(String.format("calories:         %.2f\n", calories()));
        buffer.append(DELIM);
        buffer.append(String.format("calories/100g:         %.2f\n", calories_per_100g()));
        buffer.append(DELIM);
        return buffer.toString();
    }
}
