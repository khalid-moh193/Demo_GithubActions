package Pages;

import Utils.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    public By searchField = By.name("q");
    public By searchButton = By.className("gNO89b");
    public By englishLanguage = By.linkText("English");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("-Navigate to Google")
    public HomePage navigateToGoogle() {
        openURL(URLs.GOOGLE.getValue());
        chooseEnglishLanguage();
        return this;
    }

    @Step("-Write {0} in search field")
    public HomePage sendTextToSearchField(String Text) {
        sendText(searchField, Text);
        return this;
    }

    @Step("-Click on search button")
    public SearchResultPage clickOnSearchButton() {
        clickElement(searchButton);
        return new SearchResultPage(driver);
    }

    @Step("-choose English language")
    private HomePage chooseEnglishLanguage() { //ToDo: need te enhance this method as it slows down the execution
        if (checkElementIsDisplayed(englishLanguage))
            clickElement(englishLanguage);

        else {
            System.out.println("English language is already selected");
        }
        return this;
    }

}
