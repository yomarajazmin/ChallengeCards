package pages;

import common.Session;
import common.control.Button;
import common.control.Grid;
import common.control.Label;
import common.control.Link;
import common.locators.Locators;
import io.cucumber.java.eo.Se;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;
import java.util.List;

import static common.locators.Locators.*;

public class MainPage {


    public Label charactersHomeLabel = new Label(By.xpath(CHARACTES_HOME_LABEL.xPath));
    public Button runProjectButton = new Button(By.xpath(RUN_PROJECT_BUTTON.xPath));
    public Grid gridCards = new Grid(By.xpath(CARDS_TABLE.xPath));
    public Link firstLink = new Link(By.xpath(FIRST_CARD_LINK.xPath));

    public List<WebElement> getAllCardsFromMainPage() {
        Wait<WebDriver> wait = new WebDriverWait(Session.getSession().getDriver(), Duration.ofSeconds(10));
        wait.until(d -> gridCards.isControlDisplayed());
        return Session.getInstance().getDriver().findElement(gridCards.getLocator()).findElements(By.xpath(CHILD.xPath + DIV.xPath));
    }

    public void checkAllCardsContentInMainPage() {
        boolean contentComplete;
        List<WebElement> cardContent;
        List<WebElement> cards = getAllCardsFromMainPage();
        WebElement cardContentImage;
        List<WebElement> cardContentDiv;
        String cardName;
        String cardLink;
        for (int i = 0; i < cards.size(); i++) {
            contentComplete = true;
            cardContent = cards.get(i).findElements(By.xpath(CHILD.xPath + "*"));
            cardContentImage=cardContent.get(0).findElement(By.xpath(CHILD_CARD_IMAGE.xPath));
            cardContentDiv=cardContent.get(2).findElements(By.xpath(CHILD.xPath + "*"));

            cardName =cardContentDiv.get(0).getText();
            cardLink =cardContentDiv.get(1).getText();

            if (cardContentImage == null)
                contentComplete = false;
            if (cardName.isEmpty())
                contentComplete = false;
            if (!cardLink.contains(Constants.VER_DETALLE.value))
                contentComplete = false;

            Assert.assertTrue("Card #" + (i + 1) + " does not have name, image or link.", contentComplete);
        }
    }

    public void clickOnTheFirstCard() throws InterruptedException {
        // //div[contains(@class,'grid')]/./child::div/./child::div/a[contains(text(), 'Ver detalle')]
//        List<WebElement> cards = getAllCardsFromMainPage();
//        CharacterPage characterPage=new CharacterPage();
//        Wait<WebDriver> wait = new WebDriverWait(Session.getSession().getDriver(), Duration.ofSeconds(5));
//        wait.until(d -> characterPage.characterName.isControlDisplayed());
//        if (cards == null || cards.size()==0)
//            cards=Session.getInstance().getDriver().findElement(gridCards.getLocator()).findElements(By.xpath(CHILD.xPath + DIV.xPath));
//        Session.getSession().getDriver().navigate().refresh();/
        Thread.sleep(5000);
        firstLink.click();
    }

    public void scrollDownToTheBottom(){
        JavascriptExecutor js = (JavascriptExecutor) Session.getSession().getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }

    public void clickOnRunProject(){
        Wait<WebDriver> wait = new WebDriverWait(Session.getSession().getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.or(ExpectedConditions.presenceOfElementLocated(charactersHomeLabel.getLocator()), ExpectedConditions.presenceOfElementLocated(runProjectButton.getLocator())));
        if (runProjectButton.isControlDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(runProjectButton.getLocator()));
            runProjectButton.click();
        }
    }
}
