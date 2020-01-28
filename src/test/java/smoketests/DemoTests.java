package smoketests;

import base.SetupEnv;
import base.utilits.HttpClientR;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import startpages.StartPage;

import java.io.IOException;

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

    @Test
    @DisplayName("send authorization POST request")
    void sendPostTest() {
        HttpClientR req = new HttpClientR();
        try {
            req.getPostResponse("https://car-test.norma24.ru/api/token/create",
                    "{\"username\":\"sale_point\",\"password\":\"sale_point\"}");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(true);
    }
}
