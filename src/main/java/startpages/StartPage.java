package startpages;

import base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends Page {

    @FindBy(how = How.NAME, using = "q")
    @CacheLookup
    public WebElement searchField;

    public StartPage(RemoteWebDriver driver) {
        super(driver);
        driver.get("https://google.com");

        PageFactory.initElements(this.driver, this);
    }

    public void fillSearchField(String searchText) {
        searchField.sendKeys(searchText);
    }

}
