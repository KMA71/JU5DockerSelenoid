package e2e;

import base.SetupEnv;
import landing.CarLoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import rolepages.GozMain;
import roles.GozRole;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class GozCreateDeal extends SetupEnv {

    @Test
    @DisplayName("Заведение заявки ГОЗ-ом")
    void createDeal() {

        CarLoginPage carLoginPage = new CarLoginPage(driver);
        GozMain gozMain = carLoginPage.auth("sale_point", "sale_point", new GozRole());

        gozMain.createDealClick();
        assertTrue(true);
    }

}
