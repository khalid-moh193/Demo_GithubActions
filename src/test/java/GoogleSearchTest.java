import Pages.HomePage;
import Pages.SearchResultPage;
import io.qameta.allure.Feature;
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
        doAssertEqual(searchResult.getResultText().contains("Selenium"), true, "Test result Text is not as expected");
        softAssert.assertAll();
    }

}
