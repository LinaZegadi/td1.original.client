package td1.original.client;


import td1.original.api.general.*;
import static td1.original.api.general.Meat.MeatType.*;
import static td1.original.api.general.Sauce.SauceType.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("**** Choisissez votre Menu ******* \n" +
                "1 - Menu Beefy\n" +
                "2 - Menu Fishy\n" +
                "3 - Menu Cheesy");
        int m = sc.nextInt();
        sc.nextLine();
        switch (m){
            case 1 :    System.out.println("****** Menu Beefy ******");
            case 2 :    System.out.println("****** Menu Fishy ******");
            case 3 :    System.out.println("****** Menu Cheesy ******");
        }

        BurgerBuilderFactory advisor = new BurgerBuilderFactory();

        Burger alice_dinner = advisor
                .select("CHEAP")
                .order_menu("FISH_MENU")
                .cook();

                Burger bob_dinner = advisor
                .select("CHEAP")
                .order_menu("MEAT_MENU")
                .with_onions()
                .with_cheese()
                .cook();

                Burger charles_dinner = advisor
                .select("EXPENSIVE")
                .order_personal("BIG", "BEEF")
                .with_onions()
                .with_cheese()
                .with_sauce(BARBECUE)
                .with_sauce(BEARNAISE)
                .with_cheese()
                .cook();


/*
        Burger alice_dinner = new Burger(
                "Fishy",
                List.of(new Meat(WHITEFISH, 50),
                        new Sauce(BEARNAISE, 40))
        );
        Burger bob_dinner = new Burger(
                "Beefy",
                List.of(new Meat(BEEF, 100),
                        new Sauce(BURGER, 40),
                        new DeepFriedOnions(10),
                        new Cheddar(15),
                        new DeepFriedOnions(10),
                        new Cheddar(15))
        );
        Burger charles_dinner = new Burger(
                "Own Style",
                List.of(new Meat(BEEF,400),
                        new DeepFriedOnions(20),
                        new Cheddar(30),
                        new Sauce(BARBECUE,20),
                        new Sauce(BEARNAISE,20),
                        new Sauce(BURGER,20),
                        new Cheddar(30))
        );*/
        List<Burger> dinners = Arrays.asList(
                alice_dinner,
                bob_dinner,
                charles_dinner
        );
        for (Burger dinner : dinners) {
            System.out.println(dinner);
        }
    }


}