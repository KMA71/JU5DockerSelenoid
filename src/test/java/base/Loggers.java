package base;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;

public class Loggers {

    public static void getScreenShot(RemoteWebDriver driver, Object o) {

        String dName = o.getClass().getEnclosingMethod().getAnnotation(DisplayName.class).value();
        try {

            Files.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).toPath(),
                    new File(".\\src\\test\\screenshots\\"
                    + (System.currentTimeMillis()) + "_" + dName + ".png").toPath());
        } catch (
                IOException e) {
            e.printStackTrace();
            System.out.println("Со скриншотом что-то не задалось...");
            System.out.println(e.getMessage());
        }
    }
}
