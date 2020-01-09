package smoketests;

import base.SetupEnv;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import startpages.StartPage;

import static org.junit.jupiter.api.Assertions.*;

public class DemoTests extends SetupEnv {

    @Test
    @DisplayName("DEMO: Input string with pause")
    void startPageTest() {
        StartPage startPage = new StartPage(driver);
        startPage.fillSearchField("abrakadabra");

        //this only for opportunity to see runtime tests on GUI
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(true);

    }

}
