package com.example.davidebelvedere.testfragment.data;

import java.util.List;

/**
 * Created by davidebelvedere on 22/02/18.
 */

public class MainSingleton {
    private static List<Pizza> PIZZAS;
    private static MainSingleton mySingleton = new MainSingleton();

    private MainSingleton() {

    }

    public static MainSingleton getInstance() {
        return mySingleton;
    }

    public List<Pizza> getPizzaArray() {
        return PIZZAS;
    }

    public void setPizzaArray(List<Pizza> array) {
        PIZZAS = array;
    }
}
