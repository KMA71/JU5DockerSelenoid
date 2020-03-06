package rolepages;

import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GozMain extends Page {

    @FindBy(how = How.ID, using = "createDeal")
    @CacheLookup
    private WebElement createDeal;

    public GozMain(RemoteWebDriver driver) {
        super(driver);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class=\"el-loading-mask\"]")));
        PageFactory.initElements(this.driver, this);
    }

    public void createDealClick() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class=\"el-loading-mask\"]")));
        createDeal.click();
    }
}