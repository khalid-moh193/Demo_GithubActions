package Pages;

import Utils.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePlayPage extends Page {
    public By appsButton = By.xpath("//span[contains(text(),'Apps')]");
    public By categoriesDDL = By.id("action-dropdown-parent-Categories");


    public GooglePlayPage(WebDriver driver) {
        super(driver);
    }

    @Step("-Navigate to Google Play")
    public GooglePlayPage navigateToGooglePlay() {
        openURL(URLs.GOOGLE_PLAY.getValue());
        return this;
    }

    @Step("-click on Apps from left side menu")
    public GooglePlayPage selectApps() {
        clickElement(appsButton);
        return this;
    }

    @Step("-Select a category")
    public GooglePlayPage selectCategory(String category) {
        clickElement(categoriesDDL);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/store/apps/category/" + category +"']"))).click();
        return this;
    }


}
