import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class AssertTest {
    @Test
    public void test() throws InterruptedException {
        int a = 2;
        int b = 3;
        String a1 = "Hi";
        String b1 = "Hi";

  //  Assertions.assertSame(a,b);
 // Assertions.assertNotSame(a,b);
 // Assertions.assertEquals(a1,b1,"Строки одинаковы");
    //    int [] ar1 = new int[] {1,2,3};
    //    int [] ar2 = new int[] {1,2,3};
   //     Assertions.assertArrayEquals(ar1,ar2);
    //    ArrayList<String> li1 = new ArrayList<>(Arrays.asList("one","two"));
    //    ArrayList<String> li2 = new ArrayList<>(Arrays.asList("one","two"));
    //    Assertions.assertLinesMatch(li1,li2);
     //   Assertions.assertNull("hjhkjh");
     //   Assertions.assertNotNull("hjhkjh");
        Assertions.assertTrue(true);
        Assertions.assertFalse(false);
    // Время выполнения тестов
    // Продолжительность выполнения тестов.
    Thread.sleep(500);


}}
