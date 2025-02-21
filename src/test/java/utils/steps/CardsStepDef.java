package utils.steps;

import common.Session;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CharacterPage;
import pages.CreateCardPage;
import pages.FooterSection;
import pages.MainPage;
import utils.Constants;


public class CardsStepDef {
    MainPage mainPage = new MainPage();
    CharacterPage characterPage = new CharacterPage();
    FooterSection footerSection = new FooterSection();
    CreateCardPage createCardPage=new CreateCardPage();

    @Before("@UI")
    public void beforeUISetup(){

    }


    @Given("I am at the {string} page")
    public void iAmAtThePage(String arg0) {
        Session.getInstance().getDriver().get(Constants.BASE_URL.value);
        mainPage.clickOnRunProject();
    }

    @When("I want to examine all cards")
    public void iWantToExamineAllCards() {
    }

    @Then("I want to review the name, image and link of each of them")
    public void iWantToReviewTheNameImageAndLinkOfEachOfThem() {
        mainPage.checkAllCardsContentInMainPage();
    }

    @When("I click on the details of the first card")
    public void iClickOnTheDetailsOfTheFirstCard() throws InterruptedException {
        mainPage.clickOnTheFirstCard();
    }

    @Then("I see the details of the first card")
    public void iSeeTheDetailsOfTheFirstCard() {
        characterPage.checkCharacterDetails();
    }

    @And("^I click on the (home|top|add) button to go to the (.*) page$")
    public void iClickTheHomeButtonToGoToTheHomePage(String buttonName, String pageName) {
        footerSection.clickOn(buttonName);
    }

    @Then("I see the home page")
    public void iSeeTheHomePage() {
        Assert.assertTrue(mainPage.charactersHomeLabel.isControlDisplayed());
    }

    @Then("I see a form with fields to create a new card")
    public void iSeeAFormWithFieldsToCreateANewCard() {
        Assert.assertTrue("Creation form is not displayed.", createCardPage.characterName.isControlDisplayed() &&
                createCardPage.characterGender.isControlDisplayed() &&
                createCardPage.characterSpecie.isControlDisplayed() &&
                createCardPage.characterStatus.isControlDisplayed());
    }

    @And("I scroll down to the bottom")
    public void iScrollDownToTheBottom() {
        mainPage.scrollDownToTheBottom();
    }

    @Then("I see the top label of the home page")
    public void iSeeTheTopLabelOfTheHomePage() {
        mainPage.charactersHomeLabel.isControlDisplayed();
    }
}
