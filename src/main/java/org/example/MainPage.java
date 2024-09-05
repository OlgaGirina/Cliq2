package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By text = By.xpath("//a[text() = \"  CLIQ Admin\"]");
    private By chooseIndustry = By.xpath("//li[@class =\"menu-accordion menu-accordion open\"]/ul/li[1]/a/span[text()=\"Industries\"]");
    private By buttonCreateIndustry = By.xpath("//div/div/a[@class='btn btn btn-success btn-sm btn-icon']");
    private By pushSystemMenu = By.xpath("//i[@class=\"fa fa-bell\"]");
    private By schedulerMenu = By.xpath("//li/a[@href=\"/push-notification/scheduler\"]");
    private By SelectSiteManagement = By.xpath("//a/span[text()='Site Management']");
    private By SiteMenu = By.xpath("//li/ul/li/a[@href=\"/site\"]");
    private By siteNameSelect = By.xpath("//*[@id=\"w0-filters\"]/div[3]/div/span/span[1]/span/ul/li/input");
    private By siteNameMobileApp = By.xpath("//li[@class=\"select2-results__option select2-results__option--highlighted\"]");
    private By submitButton = By.xpath("//button[@type = \"submit\"]");
    private By siteNameCheck = By.xpath("//span[text() = \"NewMobileSiteTest\"]");
    private By deleteButton = By.xpath("//span[@class=\"glyphicon glyphicon-trash\"]");
    private By confirmDeleteButton = By.xpath("//button[@class = \"btn btn-warning\"]");
    private By industryMenu = By.xpath("//a[@href=\"/industry\"]/span[text() = \"Industries\"]");
    private By industrySelect = By.xpath("//input[@role = \"textbox\"]");
    private By submitFindIndustry = By.xpath("//button[@type = \"submit\"]");

    // private By buttonCreateSite = By.xpath("//button[@type='submit']");

    public String getText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(text));
        return webDriver.findElement(text).getText();
    }

    public CreateIndustry createIndustry() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(text));
        webDriver.findElement(chooseIndustry).click();
        webDriver.findElement(buttonCreateIndustry).click();
        return new CreateIndustry(webDriver);
    }


    public MainPage chooseFromMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pushSystemMenu)).click();
        return this;
    }

    public MainPage chooseIndustryFromMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(industryMenu)).click();
        return this;
    }

    public MainPage chooseScheduler() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(schedulerMenu)).click();
        return this;
    }

    public MainPage chooseCreateSiteFromMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectSiteManagement)).click();
        return this;
    }

    public MainPage chooseSiteForCreateFromMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SiteMenu)).click();
        return this;
    }

    public MainPage selectSiteName(String CheckCreatedSiteName) {
        WebElement chooseSiteName = wait.until(ExpectedConditions.visibilityOfElementLocated(siteNameSelect));
        chooseSiteName.click();
        webDriver.findElement(siteNameSelect).sendKeys(CheckCreatedSiteName);
        webDriver.findElement(siteNameMobileApp).click();
        return this;
    }

    public MainPage selectIndustryName(String CheckedInputIndustryName) {
        WebElement chooseIndustry = wait.until(ExpectedConditions.visibilityOfElementLocated(industrySelect));
        chooseIndustry.click();
        webDriver.findElement(industrySelect).sendKeys(CheckedInputIndustryName);
        webDriver.findElement(submitFindIndustry).click();
        return this;
    }

    public MainPage clickSubmitButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton)).click();
        return this;
    }

    public MainPage deleteCreatedSiteAndIndustry() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton)).click();
        return this;
    }

    public MainPage deleteCreatedIndustry() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton)).click();
        return this;
    }
    public boolean checkFinalResultCreateMobileAppSite() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(siteNameCheck));
            return true;
        } catch (TimeoutException timeoutException) {
            return false;
        }
    }

}

