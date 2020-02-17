package rolepages;

import base.Page;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class GozMain extends Page {


    public GozMain(RemoteWebDriver driver) {
        super(driver);

        PageFactory.initElements(this.driver, this);
    }
}