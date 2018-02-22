package com.example.davidebelvedere.testfragment.logic;

import android.content.Context;

import com.example.davidebelvedere.testfragment.data.MainSingleton;
import com.example.davidebelvedere.testfragment.data.Pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidebelvedere on 22/02/18.
 */

public class Utility {
    public static void initDataSource(Context context) {
        List<Pizza> pizzaList = new ArrayList<Pizza>();
        pizzaList.add(new Pizza("Margherita"));
        pizzaList.add(new Pizza("4 formaggi"));
        pizzaList.add(new Pizza("Capricciosa"));
        pizzaList.add(new Pizza("Calzone"));

        MainSingleton.getInstance().setPizzaArray(pizzaList);
    }
    public static List<Pizza> getDataSourceItemList() {
        return MainSingleton.getInstance().getPizzaArray();
    }
}
