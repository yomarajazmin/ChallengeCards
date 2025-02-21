package pages;

import common.Session;
import common.control.Button;
import common.locators.Locators;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static common.locators.Locators.*;

public class FooterSection {


    public Button homeButton = new Button(By.xpath(Locators.HOME_BUTTON.xPath));
    public Button topButton = new Button(By.xpath(Locators.TOP_BUTTON.xPath));
    public Button addButton = new Button(By.xpath(Locators.ADD_BUTTON.xPath));

    public void clickOn(String option){
        Button optionButton=new Button(By.xpath(Locators.HOME_BUTTON.xPath));;
        switch (option) {
            case "home" -> optionButton=homeButton;
            case "top" -> optionButton=topButton;
            case "add" -> optionButton=addButton;
        }
        Wait<WebDriver> wait = new WebDriverWait(Session.getSession().getDriver(), Duration.ofSeconds(10));
        Button finalOptionButton = optionButton;
        wait.until(d -> finalOptionButton.isControlDisplayed());
        optionButton.click();
    }
}
