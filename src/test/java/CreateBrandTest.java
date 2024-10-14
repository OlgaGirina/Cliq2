import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateBrandTest extends TestBase {
    @BeforeEach
    public void login() {
        signInPage.SignInSuccessful("olga", "Dimapovrez123");
    }
    @Test
    public void createBrandTest() throws InterruptedException {
        createBrand.chooseBrandFromMenu();
        createBrand.pressButtonCreateBrand();
        createBrand.chooseIndustryForNewBrand("NewIndustryAuto");
        Thread.sleep(2000);
        createBrand.choosePartnerForNewBrand("newPartnerName10");
        Thread.sleep(2000);
        createBrand.inputBrandName("BrandAuto1");
        createBrand.clickSaveBrand();
        Assertions.assertTrue(createBrand.checkBrandSaved());
        createBrand.cleanFieldIndustryFromMenu();
        createBrand.chooseIndustryInFilter("NewIndustryAuto");
        createBrand.chooseBrandInFilter("BrandAuto1");
        createBrand.pressApplyInFilter();
}
    @AfterEach
    public void TearDown() {
        webDriver.quit();
    }}