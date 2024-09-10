package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreatePartner extends BasePage {
    public CreatePartner(WebDriver webDriver) {
        super(webDriver);
    }

    private By partnerMenu = By.xpath("//li/a[@href=\"/partner\"]");
    private By createPartner = By.xpath("//a[@href='/partner/create']");
    private By partnerNameInput = By.xpath("//input[@name='Partner[name]']");
    private By chooseIndustryInForm = By.xpath("//span[@id = \"select2-partner-industry_id-container\"]");
    private By inputIndustryFormPartnerCreating = By.xpath("//span/input[@class= \"select2-search__field\"]");
    private By chooseIndustryInFormPartnerCreating = By.xpath("//ul/li[@class= \"select2-results__option select2-results__option--highlighted\"]");





    public CreatePartner choosePartnerFromMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(partnerMenu)).click();
        return this;
    }
    public CreatePartner pressButtonCreatePartner(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(createPartner)).click();
        return this;
    }


public CreatePartner chooseIndustryForNewPartner(String newIndustryAuto){
    WebElement chooseIndustry = wait.until(ExpectedConditions.visibilityOfElementLocated(chooseIndustryInForm));
    chooseIndustry.click();
    webDriver.findElement(inputIndustryFormPartnerCreating).sendKeys(newIndustryAuto);
  //  webDriver.findElement(chooseIndustryInFormPartnerCreating).click();
    return this;
}

    public CreatePartner inputPartnerName(String partnerName) {
        WebElement newPartnerFormCreating = wait.until(ExpectedConditions.visibilityOfElementLocated(partnerNameInput));
        newPartnerFormCreating.click();
        newPartnerFormCreating.sendKeys(partnerName);
        newPartnerFormCreating.sendKeys(Keys.ENTER);
        return this;
    }


}