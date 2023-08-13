package java;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Mock
    Animal animal;
    @Test
    public void eatMeat() throws Exception {
        Feline cats = new Feline();
        Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedResult = animal.getFood("Хищник");
        List<String> result = cats.eatMeat();
        assertEquals(result,expectedResult);
    }
    @Test
    public void getFamily(){
        Feline cats = new Feline();
        String expectedResult = "Кошачьи";
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
        System.out.println(cats.getKittens(x));
        assertEquals(result,x);
    }
}