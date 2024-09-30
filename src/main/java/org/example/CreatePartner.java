package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
    private By addReferrerDomainButton = By.xpath("//button/i[@class=\"fa fa-plus-circle\"]");
    private By referrerAdd = By.xpath("//td/div/div/input[@class=\"form-control\"]");
    private By saveButton = By.xpath("//button[@type=\"submit\"]");
    private By partnerCreatedCheck = By.xpath("//a[text() = \"  CLIQ Admin\"]");
    private By partnerInFilter = By.xpath("//*[@id=\"w0-filters\"]/div[2]/div/span/span[1]/span/ul/li/input");
    private By buttonApply = By.xpath("//button[@type=\"submit\"]");
    private By buttonDeletePartner = By.xpath("//a/span[@class=\"glyphicon glyphicon-trash\"]");
    private By deleteOkButton = By.xpath("//button/span[@class=\"glyphicon glyphicon-ok\"]");
    private By cleanAllPartnersInFilter = By.xpath("//ul/span[@class=\"select2-selection__clear\"]");

    public CreatePartner choosePartnerFromMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(partnerMenu)).click();
        return this;
    }

    public CreatePartner pressButtonCreatePartner() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createPartner)).click();
        return this;
    }

    public CreatePartner chooseIndustryForNewPartner(String newIndustryAuto) {
        WebElement chooseIndustry = wait.until(ExpectedConditions.visibilityOfElementLocated(chooseIndustryInForm));
        chooseIndustry.click();
        WebElement chooseIndustry2 = wait.until(ExpectedConditions.visibilityOfElementLocated(inputIndustryFormPartnerCreating));
        chooseIndustry2.click();
        chooseIndustry2.sendKeys(newIndustryAuto);
        webDriver.findElement(chooseIndustryInFormPartnerCreating).click();
        return this;
    }

    public CreatePartner inputPartnerName(String newPartnerName) {
        WebElement newPartnerFormCreating = wait.until(ExpectedConditions.visibilityOfElementLocated(partnerNameInput));
        newPartnerFormCreating.click();
        newPartnerFormCreating.sendKeys(newPartnerName);
        //   newPartnerFormCreating.sendKeys(Keys.ENTER);
        return this;
    }

    public CreatePartner pressButtonAddReferrer() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addReferrerDomainButton)).click();
        return this;
    }

    public CreatePartner addReferrerDomain(String referrerDomain) {
        WebElement referrerDomainInput = wait.until(ExpectedConditions.visibilityOfElementLocated(referrerAdd));
        referrerDomainInput.click();
        referrerDomainInput.sendKeys(referrerDomain);
        referrerDomainInput.click();
        return this;
    }

    public CreatePartner saveNewPartnerForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton)).click();
        return this;
    }

    public boolean checkResultPhrasePartnerCreate() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(partnerCreatedCheck));
            return true;
        } catch (TimeoutException timeoutException) {
            return false;
        }
    }

    public CreatePartner chooseCreatedPartnerInFilter(String partner) {
        WebElement choosePartnerInFilter = wait.until(ExpectedConditions.visibilityOfElementLocated(partnerInFilter));
        choosePartnerInFilter.click();
        choosePartnerInFilter.sendKeys(partner, Keys.ENTER);

        return this;
    }

    public CreatePartner pressApplyInFilter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonApply)).click();
        return this;
    }

    public CreatePartner pressDeletePartnerButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonDeletePartner)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteOkButton)).click();
        return this;
    }

    public CreatePartner cleanFieldPartnerFromMenu() {
  /*      try {
            WebElement clickElement = webDriver.findElement(cleanAllPartnersInFilter);
            if (clickElement != null) {
                clickElement.click();
            }
            return this;
        }
        catch (TimeoutException timeoutException){
            return null;
        }
    }*/
        if (!webDriver.findElements(cleanAllPartnersInFilter).isEmpty()) {
            WebElement clickElement = webDriver.findElement(cleanAllPartnersInFilter);
            clickElement.click();
            return this;
        } else {
            return this;
        }
    }
}
