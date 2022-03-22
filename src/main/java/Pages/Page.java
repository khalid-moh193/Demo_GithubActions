package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
    }

    protected void openURL(String url) {
        driver.navigate().to(url);
    }

    protected void visibilityWait(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void clickElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    @Step("-Scroll down")
    public void ScrollDownByPixel() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
    }

    protected void sendText(By element, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getElementText(By element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element)).getText();
    }

    public boolean getElementTextContains(String text) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),"+"'" + text + "'" +")]"))).isDisplayed();
    }

    public boolean checkElementIsDisplayed(By element) {
        try {
            visibilityWait(element);
            driver.findElement(element).isDisplayed();
        } catch (Exception e) {
            System.out.println("Couldn't find element" + element);
            return false;
        }
        return true;
    }

}


