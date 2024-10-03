import org.example.CreateSite;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateSiteTest extends TestBase {
    @BeforeEach
    public void login() {
        signInPage.SignInSuccessful("olga", "Dimapovrez123");
    }

    @Test
    public void createSiteTest() throws InterruptedException {
        mainPage.chooseCreateSiteFromMenu();
        mainPage.chooseSiteForCreateFromMenu();
        Thread.sleep(2000);
        CreateSite createSite1 = createSite.createSite();
        Thread.sleep(2000);
        String text3 = createSite1.getTextCancel();
        Assertions.assertEquals("Cancel", text3);
        Thread.sleep(5000);
        createSite.inputSiteIndustry("IMN Dating");
        Thread.sleep(5000);
        createSite.selectSiteType()
                .inputSiteName("NewMobileSiteTest")
                .inputDomainNew("autoTest.cliq-track-master.sb.cliqonline.com")
                .inputTrackDomainNew("autoTest.cliq-track-master.sb.cliqonline.com")
                .inputCdnDomainNew("autoTest.cliq-track-master.sb.cliqonline.com")
                .clickSaveButton();
        Thread.sleep(5000);
        Assertions.assertTrue(createSite.checkResultPhrase());
        createSite.changeTab();
        Thread.sleep(3000);
        createSite.activateCheckboxEnabledPushNotifications()
                //.activateCheckboxBackLink()
                .inputPushApplication("Joker Lucky Wheel")
                .clickSaveButton();
        Thread.sleep(3000);
        Assertions.assertTrue(createSite.checkResultPhrase());
        Thread.sleep(3000);
        mainPage.chooseSiteForCreateFromMenu();
        Thread.sleep(3000);
        mainPage.selectSiteName("NewMobileSiteTest")
                .clickSubmitButton();
        Assertions.assertTrue(mainPage.checkFinalResultCreateMobileAppSite());
        Thread.sleep(3000);
        mainPage.deleteCreatedSiteAndIndustry();
    }

    @AfterEach
    public void TearDown() {
        webDriver.quit();
    }

}
