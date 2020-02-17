package rolepages;

import base.Page;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class UnderMain extends Page {


    public UnderMain(RemoteWebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }
}
