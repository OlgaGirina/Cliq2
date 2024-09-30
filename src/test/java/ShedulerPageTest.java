import org.example.BasePage;
import org.example.SchedulerPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShedulerPageTest extends TestBase {
    public String createdRuleName;

    @BeforeEach
    public void login() {
        signInPage.SignInSuccessful("olga", "Dimapovrez123");
       TestBase.setZoom(webDriver,75);
    }
    // @Test
    @ParameterizedTest
    @CsvSource({
            "IMN Dating,Test message, PlentyOfFlirt (AOS) Mob pure.pentfli.click",
            "IMN Dating,Test3, PlentyOfFlirt (AOS) Mob pure.pentfli.click"
    })

    public void createDeliveryScheduler(String industryName, String ruleName, String siteName) throws InterruptedException {

        mainPage.chooseFromMenu();
        TestBase.setZoom(webDriver,75);
        mainPage.chooseScheduler();
        TestBase.setZoom(webDriver,75);
        Thread.sleep(3000);
        schedulerPage.inputFilterIndustry(industryName);
        Thread.sleep(3000);
        schedulerPage.findMessageToSent(ruleName);
        Thread.sleep(3000);
        SchedulerPage schedulerPage1 = schedulerPage.newDelivery();
        Thread.sleep(3000);
        schedulerPage.activateCheckBoxRetentionUsers();
        Thread.sleep(3000);
        schedulerPage.inputSiteName(siteName);
        Thread.sleep(3000);
        schedulerPage.chooseTimeForRule();
        Thread.sleep(3000);
        String text = schedulerPage1.getTextSchedulerSite();
        Assertions.assertEquals("sites", text);
        Thread.sleep(3000);
        schedulerPage.creationNewPush();
        Thread.sleep(5000);
        Assertions.assertTrue(schedulerPage.checkRuleCreateCorrect());
        Thread.sleep(5000);
        schedulerPage.deleteJustCreatedRule(ruleName);
        schedulerPage.pressDeleteButton();
        Thread.sleep(5000);
        Assertions.assertTrue(schedulerPage.checkRuleDeleteCorrect(createdRuleName));
    }
    @AfterEach
    public void TearDown() {
        webDriver.quit();
    }
}
