package com.example.davidebelvedere.testfragment.data;

/**
 * Created by davidebelvedere on 22/02/18.
 */

public class Pizza {
    private String nome;
    private String desc;


    public Pizza(String nome, String desc) {
        this.nome = nome;
        this.desc=desc;
    }

    public String getName() {
        return nome;
    }

    public String getDesc(){return desc;}

}
