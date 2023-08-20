package com.example;

import java.util.List;

public class Animal {

    public List<String> getFood(String animalKind) throws Exception {
        if ("Травоядное".equals(animalKind)) {
            return List.of("Трава", "Различные растения");
        } else if ("Predator".equals(animalKind)) {
            return List.of("Animals", "Birds", "Fish");
        } else {
            throw new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }

    public String getFamily() {
        return "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    }
}