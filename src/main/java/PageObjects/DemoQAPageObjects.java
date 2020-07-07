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
}
