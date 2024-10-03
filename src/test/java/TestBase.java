import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.MainPage;
import org.example.SignInPage;
import org.example.CreateIndustry;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.example.CreateSite;
import org.example.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.*;

import java.time.Duration;

public class TestBase {
    WebDriver webDriver;
    SignInPage signInPage;
    MainPage mainPage;
    CreateIndustry createIndustry;
    CreateSite createSite;
    SchedulerPage schedulerPage;
    CreatePartner createPartner;
    CreateBrand createBrand;
    static WebDriverWait wait;

    @BeforeEach
    public void SetUp() {
          WebDriverManager.chromedriver().setup();
       // WebDriverManager.firefoxdriver().setup();
       // webDriver = new FirefoxDriver();
          webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        webDriver.get("http://short:short@cliq-backend-r102283.sb.cliqonline.com");
        //Set Up Pages
        signInPage = new SignInPage(webDriver);
        mainPage = new MainPage(webDriver);
        createIndustry = new CreateIndustry(webDriver);
        schedulerPage = new SchedulerPage(webDriver);
        createSite = new CreateSite(webDriver);
        createPartner = new CreatePartner(webDriver);
        createBrand = new CreateBrand(webDriver);
    }
    public static void setZoom (WebDriver driver, int zoomPercentage) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='" + zoomPercentage + "%'");
    }
}


