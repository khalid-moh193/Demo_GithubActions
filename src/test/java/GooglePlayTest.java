import Pages.GooglePlayPage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("categories Functionality")
public class GooglePlayTest extends BaseTestClass {
    GooglePlayPage googlePlay;


    @Test(description = "select Educational categories and assert on that ")
    public void googlePlayFunctionality() {
        googlePlay = new GooglePlayPage(driver);
        googlePlay.navigateToGooglePlay()
                .selectApps();
        doAssertEqual(googlePlay.getCurrentUrl(), "https://play.google.com/store/apps", "wrong URL");

        googlePlay.selectCategory("EDUCATION");
        doAssertEqual(googlePlay.getCurrentUrl(), "https://play.google.com/store/apps/category/EDUCATION", "wrong URL");

        softAssert.assertAll();
    }

}
