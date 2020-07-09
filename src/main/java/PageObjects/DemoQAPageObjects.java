package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DemoQAPageObjects {

    public WebDriver driver;

    public DemoQAPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='Text Box']")
    private WebElement textBox;

    public WebElement textBox() {
        return textBox;
    }

    @FindBy(css = "#userName")
    private WebElement fullName;

    public WebElement fullName() {
        return fullName;
    }

    @FindBy(css = "#userEmail")
    private WebElement email;

    public WebElement email() {
        return email;
    }

    @FindBy(css = "#currentAddress")
    private WebElement currentAddress;

    public WebElement currentAddress() {
        return currentAddress;
    }

    @FindBy(css = "#permanentAddress")
    private WebElement permanentAddress;

    public WebElement permanentAddress() {
        return permanentAddress;
    }

    @FindBy(css = "#submit")
    private WebElement submit;

    public WebElement submit() {
        return submit;
    }

    @FindBy(css = "#output")
    private WebElement outputTextBox;

    public WebElement outputTextBox() {
        return outputTextBox;
    }

    @FindBy(xpath = "//span[text()='Check Box']")
    private WebElement checkBox;

    public WebElement checkBox() {
        return checkBox;
    }

    @FindBy(xpath = "//button[@title='Toggle']")
    private WebElement toggle;

    public WebElement toggle() {
        return toggle;
    }

    @FindBy(xpath = "//label[@for='tree-node-downloads']/span[1]")
    private WebElement downloadsCheckBox;

    public WebElement downloadsCheckBox() {
        return downloadsCheckBox;
    }

    @FindBy(css = "#result span:nth-child(2)")
    private WebElement verifyCheckBox;

    public WebElement verifyCheckBox() {
        return verifyCheckBox;
    }

    @FindBy(xpath = "//span[text()='Radio Button']")
    private WebElement radioButton;

    public WebElement radioButton() {
        return radioButton;
    }

    @FindBy(css = "label[for='impressiveRadio']")
    private WebElement impressiveRadioButton;

    public WebElement impressiveRadioButton() {
        return impressiveRadioButton;
    }

    @FindBy(css = "span.text-success")
    private WebElement verifyRadioButton;

    public WebElement verifyRadioButton() {
        return verifyRadioButton;
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webTables;

    public WebElement webTable() {
        return webTables;
    }

    @FindBy(xpath = "//div[text()='First Name']")
    private WebElement sortFirstName;

    public WebElement sortFirstName() {
        return sortFirstName;
    }

    @FindBy(xpath = "//div[@class='rt-tbody'] //div[@role='row']/div[1]")
    private List<WebElement> firstNameColumn;

    public List<WebElement> firstNameColumn() {
        return firstNameColumn;
    }

    @FindBy(xpath = "//span[text()='Buttons']")
    private WebElement buttons;

    public WebElement buttons() {
        return buttons;
    }

    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickButton;

    public WebElement doubleClickButton() {
        return doubleClickButton;
    }

    @FindBy(id = "rightClickBtn")
    private WebElement rightClickButton;

    public WebElement rightClickButton() {
        return rightClickButton;
    }

    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement clickButton;

    public WebElement clickButton() {
        return clickButton;
    }

    @FindBy(id = "doubleClickMessage")
    private WebElement doubleClickMessage;

    public WebElement doubleClickMessage() {
        return doubleClickMessage;
    }

    @FindBy(id = "rightClickMessage")
    private WebElement rightClickMessage;

    public WebElement rightClickMessage() {
        return rightClickMessage;
    }

    @FindBy(id = "dynamicClickMessage")
    private WebElement dynamicClickMessage;

    public WebElement dynamicClickMessage() {
        return dynamicClickMessage;
    }

    @FindBy(xpath = "//span[text()='Links']")
    private WebElement links;

    public WebElement links() {
        return links;
    }

    @FindBy(id = "created")
    private WebElement createdLink;

    public WebElement createdLink() {
        return createdLink;
    }

    @FindBy(id = "no-content")
    private WebElement noContentLink;

    public WebElement noContentLink() {
        return noContentLink;
    }

    @FindBy(id = "moved")
    private WebElement movedLink;

    public WebElement movedLink() {
        return movedLink;
    }

    @FindBy(id = "bad-request")
    private WebElement badRequestLink;

    public WebElement badRequestLink() {
        return badRequestLink;
    }

    @FindBy(id = "unauthorized")
    private WebElement unauthorizedLink;

    public WebElement unauthorizedLink() {
        return unauthorizedLink;
    }

    @FindBy(id = "forbidden")
    private WebElement forbiddenLink;

    public WebElement forbiddenLink() {
        return forbiddenLink;
    }

    @FindBy(id = "invalid-url")
    private WebElement notFoundLink;

    public WebElement notFoundLink() {
        return notFoundLink;
    }

    @FindBy(id = "linkResponse")
    private WebElement linkResponseMessage;

    public WebElement linkResponseMessage() {
        return linkResponseMessage;
    }

    @FindBy(id = "simpleLink")
    private WebElement homeLink;

    public WebElement homeLink() {
        return homeLink;
    }

    @FindBy(id = "dynamicLink")
    private WebElement homeHkWJsLink;

    public WebElement homeHkWJsLink() {
        return homeHkWJsLink;
    }

    @FindBy(xpath = "//span[text()='Upload and Download']")
    private WebElement uploadAndDownload;

    public WebElement uploadAndDownload() {
        return uploadAndDownload;
    }

    @FindBy(id = "downloadButton")
    private WebElement downloadLink;

    public WebElement downloadLink() {
        return downloadLink;
    }

    @FindBy(id = "uploadedFilePath")
    private WebElement uploadedFilePath;

    public WebElement uploadedFilePath() {
        return uploadedFilePath;
    }
}
