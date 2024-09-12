import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreatePartnerTest extends TestBase {
    @BeforeEach
    public void login() {
        signInPage.SignInSuccessful("olga", "Dimapovrez123");
    }

    @Test
    public void createPartnerTest() throws InterruptedException {
        createPartner.choosePartnerFromMenu();
        createPartner.pressButtonCreatePartner();
        Thread.sleep(2000);
        createPartner.chooseIndustryForNewPartner("NewIndustryAuto");
        createPartner.inputPartnerName("NewPartnerName5");
        createPartner.pressButtonAddReferrer();
        Thread.sleep(3000);
        createPartner.addReferrerDomain("autotest.cliq-track-master.sb.cliqonline.com");
        createPartner.saveNewPartnerForm();
    }
    @AfterEach
    public void TearDown() {
        webDriver.quit();
    }
}