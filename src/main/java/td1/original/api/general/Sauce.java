package td1.original.api.general;

public class Sauce implements FoodProduct {

    public static enum SauceType implements FoodConstituent
    {
        BURGER, BARBECUE, BEARNAISE;
        // BURGER : 240 kcal / 100g
        // BARBECUE : 130 kcal / 100g
        // BEARNAISE : 550 kcal / 100g
        public double calories_per_100g(){
            double rtr = 0;
            switch (this)
            {
                case BURGER  :
                    rtr = 100;
                break;
                case BARBECUE :
                    rtr = 130;
                break;
                case BEARNAISE  :
                    rtr = 550;
                break;
                default:
                    rtr = 240;

            }
            return rtr;
        }
    }


    private static double BASE_PRICE = 1;

    private SauceType type;
    private double weight;

    public Sauce(SauceType type, double weight) {
        this.type = type;
        this.weight = weight;
    }

    @Override
    public double price() {
        return BASE_PRICE;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double calories_per_100g()
    {
        return type.calories_per_100g();
    }
    @Override
    public String toString() {
        return String.format("%s sauce (%.0fg) -- %.2f€", type, weight(), price());
    }
}
