package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    protected RemoteWebDriver driver;
    protected WebDriverWait wait;

    public Page(RemoteWebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getPageTitle() {
        return this.driver.getTitle();
    }
}