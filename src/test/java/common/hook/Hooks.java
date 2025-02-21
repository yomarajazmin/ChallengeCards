package common.hook;

import common.Session;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Hooks {

    @Before
    public void setup() {
        System.out.println("Launching browser and setting up test data...");
        Session.getInstance();
    }

    @After
    public void teardown() {
        System.out.println("Closing browser and cleaning up...");
        Session.getSession().closeSession();
    }
}
