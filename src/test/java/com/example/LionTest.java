package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.runners.Parameterized;

import java.lang.reflect.Executable;
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
                {"Самка",false}

        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittens() throws Exception {
        Feline fel = Mockito.mock(Feline.class);
        Lion savannah = new Lion(sex, fel);
        Mockito.when(savannah.getKittens()).thenReturn(1);
        assertEquals(savannah.getKittens(),1);
    }

    @Test
    public void doesHaveMane() throws Exception {
        Feline fel = Mockito.mock(Feline.class);
        Lion savannah = new Lion(sex, fel);
        assertEquals(savannah.doesHaveMane(), mane);

    }

    @Test
    public void getFood() throws Exception {


        Feline fel = Mockito.mock(Feline.class);
        Lion savannah = new Lion(sex, fel);

        Mockito.when(fel.getFood("Predator")).thenReturn(List.of("Animals", "Birds", "Fish"));
        List<String> expectedResult = List.of("Animals", "Birds", "Fish");
        List<String> result = savannah.getFood();
        assertEquals(result, expectedResult);
    }

    @Test (expected = Exception.class)
    public void getExceptionOnWrongSex() throws Exception {

       String s = "Сам";
       Feline fel = Mockito.mock(Feline.class);
       Lion lionFail = new Lion(s, fel);

    }

    /*@Test
    public void getExceptionOnWrongSexV2() {

        try{
            String s = "Сам";
            Feline fel = Mockito.mock(Feline.class);
            Lion lionFail = new Lion(s, fel);
            Assert.fail("Пол должен быть некорректным");
        }catch (Exception e){


            assertEquals("Используйте допустимые значения пола животного - самей или самка",e.getMessage());
        }

    }*/





}


