import Pages.HomePage;
import Pages.SearchResultPage;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

@Feature("Search Functionality")
public class GoogleSearchTest extends BaseTestClass {
    HomePage home;
    SearchResultPage searchResult;

    @Test(description = "search by any keyword, then check that it's existed in the search result ")
    public void verifySearchFunctionality() {
        System.out.println("################# test is started");
        home = new HomePage(driver);
        home.navigateToGoogle()
                .sendTextToSearchField("Selenium WebDriver")
                .clickOnSearchButton();

        searchResult = new SearchResultPage(driver);
        doAssertEqual(searchResult.getCurrentUrl().contains("Selenium"), true, "URL doesn't contain the search keyword");
        try {
            doAssertEqual(searchResult.getResultText().contains("Selenium"), true, "Test result Text is not as expected");
        }catch (NoSuchElementException noSuchElementException) {
            doAssertEqual(driver.findElement(By.xpath("//h3[contains(text(),'Selenium Webdrive')]")).isDisplayed(), true, "Test result Text is not as expected");
        }
        softAssert.assertAll();
    }

}
