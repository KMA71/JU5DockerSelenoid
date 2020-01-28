package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;

public class SetupEnv {
    public static RemoteWebDriver driver;

    @BeforeEach
    public void openDriver() throws Exception {
//        final DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
        final DesiredCapabilities capabilities = new DesiredCapabilities().chrome();

        capabilities.setBrowserName("chrome");
        capabilities.setVersion("78.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability("screenResolution", "1920x1080x24");

        driver = new RemoteWebDriver(
                URI.create("http://10.77.51.11:4443/wd/hub").toURL(),
                capabilities
        );

        driver.manage().window().setSize(new Dimension(1920, 1080));

    }

    @AfterEach
    public void tearsDown() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
