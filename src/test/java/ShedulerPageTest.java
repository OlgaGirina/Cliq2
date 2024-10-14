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
        schedulerPage.inputFilterIndustry(industryName);
        schedulerPage.findMessageToSent(ruleName);
        SchedulerPage schedulerPage1 = schedulerPage.newDelivery();
        schedulerPage.activateCheckBoxRetentionUsers();
        schedulerPage.inputSiteName(siteName);
        schedulerPage.chooseTimeForRule();
        String text = schedulerPage1.getTextSchedulerSite();
        Assertions.assertEquals("sites", text);
        schedulerPage.creationNewPush();
        Assertions.assertTrue(schedulerPage.checkRuleCreateCorrect());
        schedulerPage.deleteJustCreatedRule(ruleName);
        schedulerPage.pressDeleteButton();

        Assertions.assertTrue(schedulerPage.checkRuleDeleteCorrect(createdRuleName));
    }
    @AfterEach
    public void TearDown() {
        webDriver.quit();
    }
}
