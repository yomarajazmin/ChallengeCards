package common.locators;

public enum Locators {

    RUN_PROJECT_BUTTON("//button[contains(@onclick,'runProject')]"),
    CHARACTES_HOME_LABEL("//main/div/h1[contains(text(), 'Personajes')]"),
    CARDS_TABLE("//div[contains(@class,'grid')]"),
    HOME_BUTTON("//a[@href='/']"),
    TOP_BUTTON("//button[contains(text(), 'Top')]"),
    ADD_BUTTON("//a[@href='/new']"),

    CHARACTER_NAME("//section/h1"),
    CHARACTER_GENDER("//section/p[contains(.,'Gender')]"),
    CHARACTER_SPECIE("//section/p[contains(.,'Specie')]"),
    CHARACTER_STATUS("//section/p[contains(.,'Status')]"),
    CHILD("./child::"),
    DIV("div"),
    CHILD_CARD_IMAGE("img[@src]"),
    CHILD_CARD_NAME("div/span"),
    FIRST_CARD_LINK("//a[@href]"),
//    CHILD_CARD_LINK("div/a[contains(text(), 'Ver detalle')]"),

    NEW_CHARACTER_NAME(""),
    NEW_CHARACTER_GENDER(""),
    NEW_CHARACTER_SPECIE(""),
    NEW_CHARACTER_STATUS(""),;

    public final String xPath;

    private Locators(String xPath) {
        this.xPath = xPath;
    }

}
