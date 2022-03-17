package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends Page {
    public By firstResultText = By.xpath("//div[@class='V3FYCf']//div[@class='g']//div//a//h3");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getResultText() {
        return getElementText(firstResultText);
    }

}
