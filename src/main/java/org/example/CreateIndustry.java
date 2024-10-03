package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateIndustry extends BasePage  {

    public CreateIndustry(WebDriver webDriver) {
        super(webDriver);
    }

    private final By buttonCreateIndustry = By.xpath("//button[@type='submit']");
    private By industryNameField = By.xpath("//input[@id = \"industry-name\"]");
    private By industryDescriptionField = By.xpath("//input[@id = \"industry-description\"]");
    private By successfullyCreatedIndustryNotification = By.xpath("//div[@id = \"w5-success-0\"]");
    private By chooseLeadType1 = By.xpath("//div[@class='row'][3]//span[@role='combobox']");
    private By chooseLeadType2 = By.xpath("//li[text()='Lead']");
    private By addFeature = By.xpath("//a[text()='Features']");
    private By buttonAddFeature = By.xpath("//span[text()='Add Feature']");
    private By inputNameFeature = By.xpath("//input[@type='text']");

    public String getTextButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonCreateIndustry));
        return webDriver.findElement(buttonCreateIndustry).getText();
    }
    public CreateIndustry inputIndustryName(String industryName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(industryNameField)).sendKeys(industryName);
        return this;
    }
    public CreateIndustry inputIndustryDescription(String industryDescription) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(industryDescriptionField)).sendKeys(industryDescription);
        return this;
    }
    public CreateIndustry pressButtonSave() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonCreateIndustry)).click();
        return this;
    }
    public CreateIndustry selectLeadType() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(chooseLeadType1)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(chooseLeadType2)).click();
        return this;
    }
    public CreateIndustry addFeatureToIndustry() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addFeature)).click();
        return this;
    }
    public CreateIndustry pressAddFeatureButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddFeature)).click();
        return this;
    }
    public CreateIndustry inputFeatureName(String featureName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputNameFeature)).sendKeys(featureName);
        return this;
    }

    public boolean checkResultPhrase() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successfullyCreatedIndustryNotification));
            return true;
        } catch (TimeoutException timeoutException) {
            return false;
        }

    }
}


