package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    @Parameterized.Parameter
    public String sex;
    @Parameterized.Parameter(1)
    public boolean mane;



    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] param() {
        return new Object[][]{
                {"Самец",true},
                {"Самка",false},
                {"else",false}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittens() {
        Feline fel = Mockito.mock(Feline.class);
        Lion savannah;

        {
            try {
                savannah = new Lion(sex, fel);

                Mockito.when(savannah.getKittens()).thenReturn(1);
                assertEquals(savannah.getKittens(),1);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    @Test
    public void doesHaveMane() {
        Feline fel = Mockito.mock(Feline.class);
        Lion savannah;

        {
            try {
                savannah = new Lion(sex, fel);
                assertEquals(savannah.doesHaveMane(), mane);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    @Test
    public void getFood() {
        Feline fel = Mockito.mock(Feline.class);
        Lion savannah;


        try {
            savannah = new Lion(sex, fel);

            Mockito.when(fel.getFood("Хищник")).thenReturn(List.of("Animals", "Birds", "Fish"));
            List<String> expectedResult = List.of("Animals", "Birds", "Fish");
            List<String> result = savannah.getFood();
            assertEquals(result, expectedResult);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
/*
 @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittens() {
        Feline spyFel = Mockito.spy(new Feline());
        Lion savannah;

        {
            try {
                savannah = new Lion(sex, spyFel);
                assertEquals(savannah.getKittens(),1);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    @Test
    public void doesHaveMane() {
        Feline spyFel = Mockito.spy(new Feline());
        Lion savannah;

        {
            try {
                savannah = new Lion(sex, spyFel);
                assertEquals(savannah.doesHaveMane(), mane);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    @Test
    public void getFood() {
        Feline spyFel = Mockito.spy(new Feline());
        Lion savannah;


        try {
        savannah = new Lion(sex, spyFel);
            List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
            List<String> result = savannah.getFood();
            assertEquals(result, expectedResult);
            //System.out.println(savannah.getFood());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
*/


}