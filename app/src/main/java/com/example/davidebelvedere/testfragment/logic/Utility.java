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
        pizzaList.add(new Pizza("Margherita","buonissima"));
        pizzaList.add(new Pizza("4 formaggi","ottima"));
        pizzaList.add(new Pizza("Capricciosa","eccezionale"));
        pizzaList.add(new Pizza("Calzone","eccelsa"));

        MainSingleton.getInstance().setPizzaArray(pizzaList);
    }
    public static List<Pizza> getDataSourceItemList() {
        return MainSingleton.getInstance().getPizzaArray();
    }
    public static Pizza getPizzaFromPosition(int pos){
       return getDataSourceItemList().get(pos);
    }
}
