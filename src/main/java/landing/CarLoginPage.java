package landing;

import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import rolepages.GozMain;
import rolepages.UnderMain;
import roles.GozRole;
import roles.Role;

public class CarLoginPage extends Page {

    @FindBy(how = How.ID, using = "login")
    @CacheLookup
    private WebElement login;

    @FindBy(how = How.ID, using = "password")
    @CacheLookup
    private WebElement passw;

    @FindBy(how = How.ID, using = "login-button")
    @CacheLookup
    private WebElement enter;

    public CarLoginPage(RemoteWebDriver driver) {
        super(driver);
        super.driver.get("https://autocredit-front.dev.norma.rnb.com/login");
        super.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));

        PageFactory.initElements(this.driver, this);
    }

    public void setLogin(String usrLogin) {
        this.login.sendKeys(usrLogin);
    }

    public void setPassw(String usrPassword) {
        this.passw.sendKeys(usrPassword);
    }

    public void setEnter() {
        this.enter.click();
    }
//
//    public void auth(String usrLoign, String usrPassword) {
//        setLogin(usrLoign);
//        setPassw(usrPassword);
//        setEnter();
//    }

    public GozMain auth(String usrLoign, String usrPassword, GozRole role) {
        setLogin(usrLoign);
        setPassw(usrPassword);
        setEnter();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class=\"el-loading-mask\"]")));
        return new GozMain(driver);
    }

    public UnderMain auth(String usrLoign, String usrPassword, Role role) {
        setLogin(usrLoign);
        setPassw(usrPassword);
        setEnter();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class=\"el-loading-mask\"]")));
        return new UnderMain(driver);
    }


}
