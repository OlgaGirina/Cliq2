import org.example.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

public class SignInTest extends TestBase {
    @Test
    public void signInTest() {
        MainPage mainpage = signInPage.SignInSuccessful("olga", "Dimapovrez123");
        String heading = mainpage.getText();
        Assertions.assertEquals("CLIQ Admin", heading);
    }
    @AfterEach
    public void TearDown() {webDriver.quit();
    }
}


