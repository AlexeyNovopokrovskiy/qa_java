package com.example;



import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;



public class FelineTest {


    @Test
    public void eatMeat() throws Exception {
        Feline cats = new Feline();
        List<String> expectedResult = List.of("Animals", "Birds", "Fish");
        List<String> result = cats.eatMeat();
        assertEquals(result,expectedResult);
    }
    @Test
    public void getFamily(){
        Feline cats = new Feline();
        String expectedResult = "Feline";
        String result = cats.getFamily();
        assertEquals(result,expectedResult);
    }
    @Test
    public void getKittens(){
        Feline cats = new Feline();
        int result = cats.getKittens();
        assertEquals(result,1);
    }
    @Test
    public void getKittensX(){
        Feline cats = new Feline();
        int x = 10;
        int result = cats.getKittens(x);
        assertEquals(result,x);
    }
}