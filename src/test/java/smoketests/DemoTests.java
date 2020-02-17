package smoketests;

import base.Loggers;
import base.SetupEnv;
import base.utilits.HttpClientR;
import landing.CarLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.opentest4j.AssertionFailedError;
import startpages.StartPage;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class DemoTests extends SetupEnv {

    @Test
    @DisplayName("Демонстрационный тест для отладки")
    void startPageTest() {
        System.out.println(Thread.currentThread().getName());
        StartPage startPage = new StartPage(driver);
        startPage.fillSearchField("abrakadabra");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


/*
        Object o = new Object(){};

        Loggers.getScreenShot(driver, o);
*/
        try {
            assertTrue(true);
        } catch (AssertionFailedError e) {
            Object o = new Object(){};
            e.printStackTrace();
            Loggers.getScreenShot(driver, o);
            throw e;
        }

    }

    @ParameterizedTest
    @DisplayName("login")
    @CsvSource({"underwriter,underwriter","sale_point,sale_point"})
    //void loginTest(String login, String password) {
    //@Test
    void loginTest(String username, String password) {
        WebElement tmp;
        CarLoginPage carLoginPage = new CarLoginPage(driver);

        carLoginPage.auth(username, password);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName());
        assertTrue(true);
    }

    @Test
    @DisplayName("smoke api test send authorization POST request")
    void sendPostTest() {
        System.out.println(Thread.currentThread().getName());
        HttpClientR req = new HttpClientR();
        HttpResponse<String> responseStr = null;
        try {
            responseStr = req.getPostResponse("https://car-test.norma24.ru/api/token/create",
                    "{\"username\":\"sale_point\",\"password\":\"sale_point\"}");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(true);

        System.out.println();
        System.out.println(responseStr.statusCode());
        System.out.println(responseStr.body());
        System.out.println(responseStr.headers());
        System.out.println(responseStr.uri());
        System.out.println(responseStr.version());
        System.out.println(responseStr.sslSession());
/*

        ObjectMapper mapper = new ObjectMapper();
        Auth auth = null;
        try {
            auth = mapper.readValue(responseStr.body(), Auth.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(auth.getResult());

*/

    }


}
