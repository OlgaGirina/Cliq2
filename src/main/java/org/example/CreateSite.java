package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateSite extends BasePage {
    public CreateSite(WebDriver webDriver) {
        super(webDriver);
    }

    private By SelectSiteManagement = By.xpath("//a/span[text()='Site Management']");
    private By SiteMenu = By.xpath("//li/a[@href=\"/sites\"]");
    private final By buttonCreateSite1 = By.xpath("//a[@href='/site/create']");
    private By text2 = By.xpath("//a[text() = \"  CLIQ Admin\"]");
    private final By buttonCancel = By.xpath("//div/a[@href='/site/index']");
    private final By buttonSave = By.xpath("//button[@type='submit']");
    private By siteNewChooseIndustry = By.xpath("//span[@dir='ltr'][1]");
    private By inputSiteNameNew = By.xpath("//input[@role='textbox']");
    private By chooseSiteIndustryFromList = By.xpath("//li[@role='treeitem']");
    private By siteTypeSelect = By.xpath("//select[@id='site-site_type']");
    private By siteTypeMobileApp = By.xpath("//select[@name='Site[site_type]']/option[@value='7']");
    private By inputSiteName1 = By.xpath("//input[@id='site-name']");
    private By domainForMobileAppSite = By.xpath("//input[@id='site-domain']");
    private By domainTrackForMobileAppSite = By.xpath("//input[@id='site-track_domain']");
    private By domainCdnForMobileAppSite = By.xpath("//input[@id='site-cdn_domain']");
    private By textCheckCreatedSite = By.xpath("//label[text()='Traffic Source']");
    private By firstPageMobileSiteCreated = By.xpath("//button[@data-dismiss=\"alert\"]");
    private By SelectPushNotification = By.xpath("//a[text()='Push notifications']");
    private By checkTextForAddPush = By.xpath("//a[text()='Push notifications']");
    private By checkBox1 = By.xpath("//div[@class='form-group field-site-settings-push_notifier_enabled']/div/div/input[@type=\"checkbox\"]");
    private By checkBox2 = By.xpath("//div[@class='form-group field-site-settings-push_notifier_back_link_enabled']/div/div/input[@type=\"checkbox\"]");
    private By pushApplicationVariant = By.xpath("//span[text()=\"Select ...\"]");
    private By inputForApp = By.xpath("//input[@role='textbox']");
    private By chooseApp = By.xpath("//li[@role='treeitem']");
    //div[@class='form-group field-site-settings-push_notifier_enabled form-group-has-success']/div[@class="col-xs-5"]/div/input[@value=0]

    public String getTextCancel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonCancel));
        return webDriver.findElement(buttonCancel).getText();
    }

    public CreateSite createSite() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(text2));
        webDriver.findElement(buttonCreateSite1).click();
        return new CreateSite(webDriver);
    }

    public CreateSite inputSiteIndustry(String createSiteNameIndustry) {
        WebElement chooseIndustry = wait.until(ExpectedConditions.visibilityOfElementLocated(siteNewChooseIndustry));
        chooseIndustry.click();
        webDriver.findElement(inputSiteNameNew).sendKeys(createSiteNameIndustry);
        webDriver.findElement(chooseSiteIndustryFromList).click();
        return this;
    }

    public CreateSite selectSiteType() {
        WebElement chooseSiteType = wait.until(ExpectedConditions.visibilityOfElementLocated(siteTypeSelect));
        chooseSiteType.click();
        webDriver.findElement(siteTypeMobileApp).click();
        return this;
    }

    public CreateSite inputSiteName(String siteNameNew) {
        webDriver.findElement(inputSiteName1).sendKeys(siteNameNew);
        return this;
    }

    public CreateSite inputDomainNew(String domainNew) {
        webDriver.findElement(domainForMobileAppSite).sendKeys(domainNew);
        return this;
    }

    public CreateSite inputTrackDomainNew(String trackDomainNew) {
        webDriver.findElement(domainTrackForMobileAppSite).sendKeys(trackDomainNew);
        return this;
    }

    public CreateSite inputCdnDomainNew(String cdnDomainNew) {
        webDriver.findElement(domainCdnForMobileAppSite).sendKeys(cdnDomainNew);
        return this;
    }

    public CreateSite clickSaveButton() {
        webDriver.findElement(buttonSave).click();
        return new CreateSite(webDriver);
    }

    public String getTextCheckCreate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonCancel));
        return webDriver.findElement(buttonCancel).getText();
    }

    //   public CreateSite
    public boolean checkResultPhrase() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(firstPageMobileSiteCreated));
            return true;
        } catch (TimeoutException timeoutException) {
            return false;
        }
    }

    public CreateSite changeTab() {
        webDriver.findElement(SelectPushNotification).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkTextForAddPush));
        return this;
    }

    public CreateSite activateCheckboxEnabledPushNotifications() {
        webDriver.findElement(checkBox1).click();
        return this;
    }

    public CreateSite activateCheckboxBackLink() {
        webDriver.findElement(checkBox2).click();
        return this;
    }

    public CreateSite inputPushApplication(String variantPushApplication) {
        WebElement chooseIndustry = wait.until(ExpectedConditions.visibilityOfElementLocated(pushApplicationVariant));
        chooseIndustry.click();
        webDriver.findElement(inputForApp).sendKeys(variantPushApplication);
        webDriver.findElement(chooseApp).click();
        return this;
    }


}


