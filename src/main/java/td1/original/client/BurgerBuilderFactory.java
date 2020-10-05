package td1.original.client;

import td1.original.api.general.Burger;
import td1.original.api.general.Sauce;

public class BurgerBuilderFactory {
    private String name;
    private String menu;
    private String size;
    private Boolean onions;
    private Boolean cheese;
    private Sauce.SauceType sauce;

    public BurgerBuilderFactory select(String name){
        this.name = name;
        return this;
    }
    public BurgerBuilderFactory order_menu (String menu){
        this.menu = menu;
        return  this;
    }
    public BurgerBuilderFactory with_onions(){
        this.onions = onions;
        return  this;
    }
    public BurgerBuilderFactory with_cheese(){
        this.cheese = cheese;
        return  this;
    }
    public BurgerBuilderFactory with_sauce (Sauce.SauceType sauce){
        this.sauce = sauce;
        return  this;
    }
    public BurgerBuilderFactory order_personal(String size, String menu) {
        this.size = size;
        this.menu = menu;
        return this;
    }

    public Burger cook(){
        return new Burger(name,menu, onions,cheese,sauce);
    }
}