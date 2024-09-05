package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }
    private By loginInput = By.xpath("//div/input[@name='login-form[login]']");
    private By passwordInput = By.xpath("//div//input[@name='login-form[password]']");
    private By submitButton = By.xpath("//button[@type='submit']");

    public MainPage SignInSuccessful(String login, String password){
        webDriver.findElement(loginInput).sendKeys(login);
        webDriver.findElement(passwordInput).sendKeys(password);
        WebElement button = webDriver.findElement(submitButton);
        button.submit();

        return new MainPage(webDriver);
    }
}
