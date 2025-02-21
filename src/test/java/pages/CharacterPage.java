package pages;

import common.Session;
import common.control.Label;
import common.locators.Locators;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CharacterPage {

    public Label characterName = new Label(By.xpath(Locators.CHARACTER_NAME.xPath));
    public Label characterGender = new Label(By.xpath(Locators.CHARACTER_GENDER.xPath));
    public Label characterSpecie = new Label(By.xpath(Locators.CHARACTER_SPECIE.xPath));
    public Label characterStatus = new Label(By.xpath(Locators.CHARACTER_STATUS.xPath));

    public void checkCharacterDetails() {
        Assert.assertTrue("Some details of the character are empty.", checkCharacterName() &&
                checkCharacterGender() && checkCharacterSpecie() && checkCharacterStatus());
    }

    public boolean checkCharacterName() {
        Wait<WebDriver> wait = new WebDriverWait(Session.getSession().getDriver(), Duration.ofSeconds(10));
        wait.until(d -> characterName.isControlDisplayed());
        return !characterName.getAttribute("textContent").isEmpty();
    }

    public boolean checkCharacterGender() {
        String gender = characterGender.getAttribute("textContent");
        gender = gender.replace("Gender:", "");
        return !gender.trim().isEmpty();
    }

    public boolean checkCharacterSpecie() {
        String specie = characterSpecie.getAttribute("textContent");
        specie = specie.replace("Specie:", "");
        return !specie.trim().isEmpty();
    }

    public boolean checkCharacterStatus() {
        String status = characterStatus.getAttribute("textContent");
        status = status.replace("Status:", "");
        return !status.trim().isEmpty();
    }
}
