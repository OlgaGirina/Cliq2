import org.example.SchedulerPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShedulerPageTest extends TestBase {
    @BeforeEach
    public void login() {
        signInPage.SignInSuccessful("olga", "Dimapovrez123");
    }
    @Test
    public void createDeliveryScheduler() throws InterruptedException {
        mainPage.chooseFromMenu();
        mainPage.chooseScheduler();
        Thread.sleep(3000);
        schedulerPage.inputFilterIndustry("IMN Dating");
        Thread.sleep(3000);
        schedulerPage.findMessageToSent("Roman Test");
        Thread.sleep(3000);
        SchedulerPage schedulerPage1 = schedulerPage.newDelivery();
        Thread.sleep(3000);
    /*    String text = schedulerPage1.getTextSchedulerSite();
        Assert.assertEquals("sites", text);*/
        Thread.sleep(3000);
        schedulerPage.activateCheckBoxRetentionUsers();
        Thread.sleep(3000);
        schedulerPage.inputSiteName("PlentyOfFlirt (AOS) Mob pure.pentfli.click");
        Thread.sleep(3000);
        //      schedulerPage.choosePeriodForRuleScheduler();
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
    }
    @AfterEach
    public void TearDown() {
        webDriver.quit();
    }
}
