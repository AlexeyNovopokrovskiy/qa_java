package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class) // запустили этот класс с Mockito
public class CatTest {

  @Mock
   Feline domesticCat;


    @Test
    public void getFood() throws Exception {
        Cat cat = new Cat(domesticCat);
        Mockito.when(domesticCat.eatMeat()).thenReturn(List.of("Animals", "Birds", "Fish"));
        List<String> expectedResult = List.of("Animals", "Birds", "Fish");
        List<String> result = cat.getFood();
        assertEquals(result, expectedResult);
    }

    @Test
    public void getSound() {
        Cat cat = new Cat(domesticCat);
        String catSays = cat.getSound();
        String catShouldSay = "Meow";
        assertEquals(catShouldSay,catSays);
    }
/* Мне кажется через spy было бы лучше, но не уверен что это соответствует тз
   @Spy
   Feline domesticCat = new Feline();

    @Test
    public void getSound() {
        Cat cat = new Cat(domesticCat);
        String catSays = cat.getSound();
        String catShouldSay = "Мяу";
        assertEquals(catShouldSay,catSays);
    }


    @Test
    public void getFood() throws Exception {
        Cat cat = new Cat(domesticCat);
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> result = cat.getFood();
        assertEquals(result, expectedResult);
    }
*/
}