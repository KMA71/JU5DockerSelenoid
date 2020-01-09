package base;

import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class Page {
    protected RemoteWebDriver driver;

    public Page(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return this.driver.getTitle();
    }
}
