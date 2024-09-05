import org.example.CreateIndustry;
import org.junit.jupiter.api.*;

public class MainPageTest extends TestBase {
    @BeforeEach
    public void login() {
        signInPage.SignInSuccessful("olga", "Dimapovrez123");
    }
    @Test
    public void createIndustryTest() throws InterruptedException {
        CreateIndustry createIndustry1 = mainPage.createIndustry();
        String text = createIndustry1.getTextButton();
        Assertions.assertEquals("Save", text);
        createIndustry.inputIndustryName("IndustryName9");
        createIndustry.inputIndustryDescription("Description8");
        createIndustry.selectLeadType();
        createIndustry.pressButtonSave();
        createIndustry.addFeatureToIndustry();
        createIndustry.pressAddFeatureButton();
        createIndustry.inputFeatureName("NewFeature11");
        createIndustry.pressButtonSave();
        Assertions.assertTrue(createIndustry.checkResultPhrase());
        mainPage.chooseIndustryFromMenu();
        Thread.sleep(3000);
        mainPage.selectIndustryName("Industry_AutoTest12");
        Thread.sleep(3000);
      //  mainPage.deleteCreatedSiteAndIndustry();
        Thread.sleep(3000);
    }
    @AfterEach
    public void TearDown() {
        webDriver.quit();
    }
}

