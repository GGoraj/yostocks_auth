package com.gg.dls.service.authentication.model;

public class Stock {

    private String name;



    public Stock(){
        // empty
    }


    public Stock(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
