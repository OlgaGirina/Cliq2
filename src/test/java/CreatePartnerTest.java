import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
        createPartner.inputPartnerName("NewPartnerName7");
        createPartner.pressButtonAddReferrer();
        Thread.sleep(3000);
        createPartner.addReferrerDomain("autotest.cliq-track-master.sb.cliqonline.com");
        createPartner.saveNewPartnerForm();
        Assertions.assertTrue(createPartner.checkResultPhrasePartnerCreate());
        createPartner.choosePartnerFromMenu();
        createPartner.chooseCreatedPartnerInFilter("NewPartnerName7");
        createPartner.pressApplyInFilter();
        createPartner.pressDeletePartnerButton();
        Thread.sleep(5000);
    }
  /*  @Test
    public void deletePartnerTest() throws  InterruptedException {
        createPartner.choosePartnerFromMenu();
        createPartner.chooseCreatedPartnerInFilter("NewPartnerName7");
        createPartner.pressApplyInFilter();
        createPartner.pressDeletePartnerButton();
        Thread.sleep(5000);

   }  */
@AfterEach
    public void TearDown() {
        webDriver.quit();
    }
}