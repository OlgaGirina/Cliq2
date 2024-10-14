package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateBrand extends BasePage {
    public CreateBrand(WebDriver webDriver) {
        super(webDriver);
    }
    private By brandMenu = By.cssSelector("ul.sub-menu li:nth-child(3) a[href=\"/brand\"]");
    private By createBrand = By.xpath("//a[@href='/brand/create']");
    private By industryInFormBrandCreating = By.xpath("//span[@id = \"select2-brand-industry_id-container\"]");
    private By inputIndustryInFormBrandCreating = By.xpath("//span/input[@class= \"select2-search__field\"]");
    private By chooseIndustryInFormPartnerCreating = By.xpath("//ul/li[@class= \"select2-results__option select2-results__option--highlighted\"]");
   private By partnerInFormBrandCreating = By.cssSelector("span#select2-partner_id-container span");
    private By inputPartnerInFormBrandCreating = By.cssSelector("input.select2-search__field");
    private By choosePartnerInFormBrandCreating = By.cssSelector("ul.select2-results__options li");
    private By createBrandName = By.cssSelector("input#brand-name");
    private By saveBrandButton = By.cssSelector("div.col-xs-12 button");
    private By brandCreatedCheck = By.xpath("");
    private By cleanAllIndustryInFilter = By.xpath("//ul/span[@class=\"select2-selection__clear\"]");

    private By industryInFilter = By.xpath("//*[@id=\"w0-filters\"]/div[1]/div/span/span[1]/span/ul/li/input");

    private By brandInFilter = By.xpath("//*[@id=\"w0-filters\"]/div[5]/div/span/span[1]/span/ul/li/input");
    private By buttonApply = By.cssSelector("button.btn.btn-success.btn-icon.js-apply-grid-filter");
    public CreateBrand chooseBrandFromMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(brandMenu)).click();
        return this;
    }
    public CreateBrand pressButtonCreateBrand(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(createBrand)).click();
        return this;
    }
    public CreateBrand chooseIndustryForNewBrand(String newIndustryAuto){
        WebElement chooseIndustry = wait.until(ExpectedConditions.visibilityOfElementLocated(industryInFormBrandCreating));
        chooseIndustry.click();
        WebElement chooseIndustry2 = wait.until(ExpectedConditions.visibilityOfElementLocated(inputIndustryInFormBrandCreating));
        chooseIndustry2.click();
        chooseIndustry2.sendKeys(newIndustryAuto);
        webDriver.findElement(chooseIndustryInFormPartnerCreating).click();
        return this;
    }
    public CreateBrand inputBrandName(String newBrandName) {
        WebElement newBrandFormCreating = wait.until(ExpectedConditions.visibilityOfElementLocated(createBrandName));
        newBrandFormCreating.click();
        newBrandFormCreating.sendKeys(newBrandName);
        //   newPartnerFormCreating.sendKeys(Keys.ENTER);
        return this;
    }
    public CreateBrand choosePartnerForNewBrand(String partnerAuto){
        WebElement choosePartner = wait.until(ExpectedConditions.visibilityOfElementLocated(partnerInFormBrandCreating));
        choosePartner.click();
        WebElement choosePartner2 = wait.until(ExpectedConditions.visibilityOfElementLocated(inputPartnerInFormBrandCreating));
        choosePartner2.click();
        choosePartner2.sendKeys(partnerAuto);
        webDriver.findElement(choosePartnerInFormBrandCreating).click();
        return this;
    }
    public CreateBrand clickSaveBrand(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBrandButton)).click();
        return this;
    }
    public boolean checkBrandSaved() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(createBrand));
            return true;
        } catch (TimeoutException timeoutException) {
            return false;
        }
    }
    public CreateBrand cleanFieldIndustryFromMenu() {
     if (!webDriver.findElements(cleanAllIndustryInFilter).isEmpty()){
        WebElement clickElement = webDriver.findElement(cleanAllIndustryInFilter);
        clickElement.click();
        return this;
    }
        else
    {
        return this;
    }
}
    public CreateBrand chooseIndustryInFilter (String industry){
        WebElement chooseIndustryInFilter2 = wait.until(ExpectedConditions.visibilityOfElementLocated(industryInFilter));
        chooseIndustryInFilter2.click();
        chooseIndustryInFilter2.sendKeys(industry, Keys.ENTER);
        return this;
    }
    public CreateBrand chooseBrandInFilter (String brand){
        WebElement chooseBrandInFilter2 = wait.until(ExpectedConditions.visibilityOfElementLocated(brandInFilter));
        chooseBrandInFilter2.click();
        chooseBrandInFilter2.sendKeys(brand, Keys.ENTER);
        return this;
    }
    public CreateBrand pressApplyInFilter(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonApply)).click();
        return this;
    }
}
