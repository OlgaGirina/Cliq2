import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class CreatePartnerTest extends TestBase {
    @BeforeEach
    public void login() {
        signInPage.SignInSuccessful("olga", "Dimapovrez123");
    }

    @Order(1)
    @Test
    public void createPartnerTest() throws InterruptedException {
        createPartner.choosePartnerFromMenu();
        createPartner.pressButtonCreatePartner();
        Thread.sleep(2000);
        createPartner.chooseIndustryForNewPartner("NewIndustryAuto");
        createPartner.inputPartnerName("NewPartnerName22");
        createPartner.pressButtonAddReferrer();
        Thread.sleep(3000);
        createPartner.addReferrerDomain("autotest1.cliq-track-master.sb.cliqonline.com");
        createPartner.saveNewPartnerForm();
        Assertions.assertTrue(createPartner.checkResultPhrasePartnerCreate());
        Thread.sleep(3000);
     /*   createPartner.choosePartnerFromMenu();
        createPartner.chooseCreatedPartnerInFilter("NewPartnerName10");
        createPartner.pressApplyInFilter();
     //   createPartner.pressDeletePartnerButton();
        Thread.sleep(5000);*/
    }

    @Order(2)
    @Test
    public void deletePartnerTest() throws InterruptedException {

        Thread.sleep(3000);
        createPartner.choosePartnerFromMenu();
        Thread.sleep(5000);
        createPartner.cleanFieldPartnerFromMenu();
        Thread.sleep(5000);
        createPartner.chooseCreatedPartnerInFilter("NewPartnerName22");
        Thread.sleep(5000);
        createPartner.pressApplyInFilter();
        Thread.sleep(5000);
        createPartner.pressDeletePartnerButton();
        Thread.sleep(5000);
    }

    @AfterEach
    public void TearDown() {
        webDriver.quit();
    }
}