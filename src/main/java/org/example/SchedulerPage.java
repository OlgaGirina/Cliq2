package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SchedulerPage extends BasePage {
    public SchedulerPage(WebDriver webDriver) {
        super(webDriver);
    }
    int v = 30;
    private By pushSystemMenu = By.xpath("//i[@class=\"fa fa-bell\"]");
    private By schedulerMenu = By.xpath("//li/a[@href=\"/push-notification/scheduler\"]");
    private By checkSiteText = By.xpath("//div/label[text()='Sites']");
    private By chooseSiteName = By.xpath("//li[text()='Top5hookupssites']");
    private By siteInput = By.xpath("//label[text()= \"Sites\"]/following-sibling::div[1]/span/span[1]/span/ul/li/input");
    private By checkBoxReturnUsers = By.xpath("//label[text()=\"Return Users\"]");
    private By inputFindTextMessage = By.xpath("//input[@id='pushnotificationmessagesearch-name']");
    private By buttonSearchTextMessageForSend = By.xpath("//div[@class=\"tab-pane active\"]/div/div/form/div/div/div/button[@class='btn btn-sm btn-primary']");
    private By schedulerMessageChooseDate = By.xpath("//input[@id='pushnotificationdelivery-daterange']");
    private By startDate = By.xpath("//tr/td[@class='today active start-date active end-date available']");
    private By endDate = By.xpath("//tr/td[@class='today active start-date available']");
    private By applyDate = By.xpath("//div/button[@class=\"applyBtn btn btn-sm btn-success\"]");
    private By chooseTime = By.xpath("//form[@id='delivery-form']/div[12]/div/div/div/span/span/span/ul/li/input");
    private By chooseTime1 = By.xpath("//li[@role=\"option\"]");
    private By testStart = By.xpath("//li[@title=\"12:00 AM\"]");
    private By sendRuleForm = By.xpath("//button[@form=\"delivery-form\"]");
    private By ruleCreated = By.xpath("//div[text()='Scheduler']");
    private By selectChooseIndustry = By.xpath("//span[@id = \"select2-schedulerfiltermodel-industry_id-container\"]");
    private By inputIndustry = By.xpath("//span/input[@class='select2-search__field']");
    private By industryExample = By.xpath("//ul/li[@class=\"select2-results__option select2-results__option--highlighted\"]");
    private By applyToDelete = By.xpath("//button[@class=\"btn btn-warning\"]");

    public String getTextSchedulerSite() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkSiteText));
        return webDriver.findElement(checkSiteText).getText();
    }

    public SchedulerPage inputFilterIndustry(String industryName) {
        WebElement chooseIndustry = wait.until(ExpectedConditions.visibilityOfElementLocated(selectChooseIndustry));
        chooseIndustry.click();
        webDriver.findElement(inputIndustry).sendKeys(industryName);
        webDriver.findElement(industryExample).click();
        return this;
    }

    public SchedulerPage findMessageToSent(String messageText) {
        webDriver.findElement(inputFindTextMessage).sendKeys(messageText);
        WebElement searchMessageForSend = wait.until(ExpectedConditions.visibilityOfElementLocated((buttonSearchTextMessageForSend)));
        searchMessageForSend.click();
        return this;
    }

    public SchedulerPage newDelivery() {
        WebElement messageRule = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='w3']/div/div/div[@class=\"message-body\"]/div/div[1]")));
        WebElement dayScheduler = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[contains(@class,'today ')]")));
        Actions actions = new Actions(webDriver);
        actions.dragAndDrop(messageRule, dayScheduler).build().perform();
        return new SchedulerPage(webDriver);
    }

    public SchedulerPage activateCheckBoxRetentionUsers() {
        WebElement checkBoxReturnUsersActivate = wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxReturnUsers));
        checkBoxReturnUsersActivate.click();
        return this;
    }

    public SchedulerPage inputSiteName(String siteName) {
        WebElement chooseSite = wait.until(ExpectedConditions.visibilityOfElementLocated(siteInput));
        chooseSite.click();
        chooseSite.sendKeys(siteName);
        chooseSite.sendKeys(Keys.ENTER);
        return this;

    }

    public SchedulerPage chooseTimeForRule() throws InterruptedException {
        WebElement b = wait.until(ExpectedConditions.visibilityOfElementLocated(chooseTime));
        b.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(chooseTime1));
        List<WebElement> timeVariants = webDriver.findElements(chooseTime1);
        for (int i = 0; i < timeVariants.size(); i++) {
            List<WebElement> timeVariants1 = webDriver.findElements(chooseTime1);
            timeVariants1.get(i).click();
            WebElement c = wait.until(ExpectedConditions.visibilityOfElementLocated(testStart));
            c.click();
        }
        return this;
    }

    public SchedulerPage creationNewPush() throws InterruptedException {
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(sendRuleForm));
        saveButton.click();
        Thread.sleep(1000);
        return new SchedulerPage(webDriver);
    }

    public boolean checkRuleCreateCorrect() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ruleCreated));
            return true;
        } catch (TimeoutException timeoutException) {
            return false;
        }
    }
    public SchedulerPage deleteJustCreatedRule(String createdRuleName) throws InterruptedException {
        WebElement deleteIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' - " + createdRuleName + "']/..//i[@class='fa fa-trash-o']")));
        deleteIcon.click();
        Thread.sleep(1000);
        return this;
    }
    public SchedulerPage pressDeleteButton(){
        WebElement deleteRule = wait.until(ExpectedConditions.visibilityOfElementLocated(applyToDelete));
        deleteRule.click();
        return this;
    }
    public boolean checkRuleDeleteCorrect(String createdRuleName) {
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()=' - " + createdRuleName + "']/..//i[@class='fa fa-trash-o']")));;
       return true;
    }
}

