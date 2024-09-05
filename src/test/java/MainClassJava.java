import org.junit.jupiter.api.*;

public class MainClassJava {
@Nested
    public class InnerClassTest{
        @BeforeEach
        public void beforeEach() {
            System.out.println("@BeforeEachTestInner");
        }
        @Test
        public void test() {
            System.out.println("@TestInner");
        }
        @Test
        public void test1() {
            System.out.println("@Test1Inner");
        }

        @AfterEach
        public void afterEach() {
            System.out.println("@AfterEachTestInner");
        }
    }
    @BeforeEach
    public void beforeEach() {
        System.out.println("@BeforeEachTest");
    }

    @Test
    public void test() {
        System.out.println("@Test");
    }

    @Test
    public void test1() {
        System.out.println("@Test1");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("@AfterEachTest");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("@AfterAllTest");
    }


}
