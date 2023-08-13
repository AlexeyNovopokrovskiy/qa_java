package java;

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
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    /*Feline fel = Mockito.mock(Feline.class);
    Lion savannah;

    {
        try {
            savannah = new Lion(sex, fel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

    @Test
    public void getKittens() {
        Feline fel = Mockito.mock(Feline.class);
        Lion savannah;

        {
            try {
                savannah = new Lion(sex, fel);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        Mockito.when(savannah.getKittens()).thenReturn(1);
        assertEquals(savannah.getKittens(),1);
    }

    @Test
    public void doesHaveMane() {
        Feline fel = Mockito.mock(Feline.class);
        Lion savannah;

        {
            try {
                savannah = new Lion(sex, fel);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        assertEquals(savannah.doesHaveMane(), mane);
        //System.out.println(savannah.doesHaveMane());



    }

    @Test
    public void getFood() {
        Feline fel = Mockito.mock(Feline.class);
        Lion savannah;

        {
            try {
                savannah = new Lion(sex, fel);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Mockito.when(savannah.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            System.out.println(savannah.getFood());
            List<String> expectedResult = savannah.getFood();
            List<String> result = fel.getFood("Хищник");
            assertEquals(result, expectedResult);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}