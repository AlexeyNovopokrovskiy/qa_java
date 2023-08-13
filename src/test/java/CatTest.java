package java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class) // запустили этот класс с Mockito


public class CatTest {

    @Mock
    Feline domesticCat;
    @Test
    public void getSound() {
        //Feline domesticCat = new Feline();
        Cat cat = new Cat(domesticCat);
        String catShouldSay = cat.getSound();
        String catSays = "Мяу";
        assertEquals(catShouldSay,catSays);
        System.out.println(cat.getSound());
    }


    @Test
    public void getFood() throws Exception {
        Cat cat = new Cat(domesticCat);
        Mockito.when(cat.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        System.out.println(cat.getFood());
        List<String> expectedResult = cat.getFood();
        List<String> result = domesticCat.eatMeat();
        assertEquals(result, expectedResult);
    }


}