package com.example;

import java.util.List;

public class Cat extends com.example.Feline {

    com.example.Predator predator;

    public Cat(com.example.Feline feline) {
        this.predator = feline;
    }

    public String getSound() {
        return "Мяу";
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

}
