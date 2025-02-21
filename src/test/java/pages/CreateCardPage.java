package pages;

import common.control.Label;
import common.control.TextBox;
import common.locators.Locators;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CreateCardPage {

    public TextBox characterName = new TextBox(By.xpath(Locators.NEW_CHARACTER_NAME.xPath));
    public TextBox characterGender = new TextBox(By.xpath(Locators.NEW_CHARACTER_GENDER.xPath));
    public TextBox characterSpecie = new TextBox(By.xpath(Locators.NEW_CHARACTER_SPECIE.xPath));
    public TextBox characterStatus = new TextBox(By.xpath(Locators.NEW_CHARACTER_STATUS.xPath));
}
