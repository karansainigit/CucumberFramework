package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(xpath = "//span[text()='Dynamic Properties']")
    private WebElement dynamicProperties;

    public WebElement dynamicProperties() {
        return dynamicProperties;
    }

    @FindBy(id = "enableAfter")
    private WebElement firstButton;

    public WebElement firstButton() {
        return firstButton;
    }

    @FindBy(id = "colorChange")
    private WebElement secondButton;

    public WebElement secondButton() {
        return secondButton;
    }

    @FindBy(id = "visibleAfter")
    private WebElement thirdButton;

    public WebElement thirdButton() {
        return thirdButton;
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceForm;

    public WebElement practiceForm() {
        return practiceForm;
    }

    @FindBy(id = "firstName")
    private WebElement firstName;

    public WebElement firstName() {
        return firstName;
    }

    @FindBy(id = "lastName")
    private WebElement lastName;

    public WebElement lastName() {
        return lastName;
    }

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    public WebElement userEmail() {
        return userEmail;
    }

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement maleGender;

    public WebElement maleGender() {
        return maleGender;
    }

    @FindBy(id = "userNumber")
    private WebElement userNumber;

    public WebElement userNumber() {
        return userNumber;
    }

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirth;

    public WebElement dateOfBirth() {
        return dateOfBirth;
    }

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement monthOfDOB;

    public Select monthOfDOB() {
        Select month = new Select(monthOfDOB);
        return month;
    }

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement yearOfDOB;

    public Select yearOfDOB() {
        Select year = new Select(yearOfDOB);
        return year;
    }

    @FindBy(xpath = "//div[@class='react-datepicker__month'] //div[text()='21']")
    private WebElement dateOfDOB;

    public WebElement dateOfDOB() {
        return dateOfDOB;
    }

    @FindBy(id = "subjectsInput")
    private WebElement subjects;

    public WebElement subjects() {
        return subjects;
    }

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement hobbyOne;

    public WebElement hobbyOne() {
        return hobbyOne;
    }

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement hobbyThree;

    public WebElement hobbyThree() {
        return hobbyThree;
    }

    @FindBy(id = "currentAddress")
    private WebElement formCurrentAddress;

    public WebElement formCurrentAddress() {
        return formCurrentAddress;
    }

    @FindBy(xpath = "//div[text()='Select State']")
    private WebElement selectState;

    public WebElement selectState() {
        return selectState;
    }

    @FindBy(css = "#react-select-3-input")
    private WebElement enterState;

    public WebElement enterState() {
        return enterState;
    }

    @FindBy(xpath = "//div[text()='Select City']")
    private WebElement selectCity;

    public WebElement selectCity() {
        return selectCity;
    }

    @FindBy(css = "#react-select-4-input")
    private WebElement enterCity;

    public WebElement enterCity() {
        return enterCity;
    }

    @FindBy(css = "#submit")
    private WebElement submitForm;

    public WebElement submitForm() {
        return submitForm;
    }

    @FindBy(xpath = "//div[@class='modal-header']/div")
    private WebElement successfulSubmit;

    public WebElement successfulSubmit() {
        return successfulSubmit;
    }

    @FindBy(css = "#closeLargeModal")
    private WebElement closeSubmit;

    public WebElement closeSubmit() {
        return closeSubmit;
    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindows;

    public WebElement browserWindows() {
        return browserWindows;
    }

    @FindBy(css = "#tabButton")
    private WebElement newTab;

    public WebElement newTab() {
        return newTab;
    }

    @FindBy(id = "sampleHeading")
    private WebElement newTabHeading;

    public WebElement newTabHeading() {
        return newTabHeading;
    }

    @FindBy(id = "windowButton")
    private WebElement newWindow;

    public WebElement newWindow() {
        return newWindow;
    }

    @FindBy(id = "sampleHeading")
    private WebElement newWindowHeading;

    public WebElement newWindowHeading() {
        return newWindowHeading;
    }

    @FindBy(id = "messageWindowButton")
    private WebElement newWindowMessage;

    public WebElement newWindowMessage() {
        return newWindowMessage;
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alerts;

    public WebElement alerts() {
        return alerts;
    }

    @FindBy(css = "#alertButton")
    private WebElement firstAlert;

    public WebElement firstAlert() {
        return firstAlert;
    }

    @FindBy(css = "#timerAlertButton")
    private WebElement secondAlert;

    public WebElement secondAlert() {
        return secondAlert;
    }

    @FindBy(css = "#confirmButton")
    private WebElement thirdAlert;

    public WebElement thirdAlert() {
        return thirdAlert;
    }

    @FindBy(id = "confirmResult")
    private WebElement thirdAlertResult;

    public WebElement thirdAlertResult() {
        return thirdAlertResult;
    }

    @FindBy(css = "#promtButton")
    private WebElement fourthAlert;

    public WebElement fourthAlert() {
        return fourthAlert;
    }

    @FindBy(id = "promptResult")
    private WebElement fourthAlertResult;

    public WebElement fourthAlertResult() {
        return fourthAlertResult;
    }

    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement frames;

    public WebElement frames() {
        return frames;
    }

    @FindBy(xpath = "//iframe[@id='frame1']")
    private WebElement frame1;

    public WebElement frame1() {
        return frame1;
    }

    @FindBy(id = "sampleHeading")
    private WebElement frame1heading;

    public WebElement frame1heading() {
        return frame1heading;
    }

    @FindBy(xpath = "//iframe[@id='frame2']")
    private WebElement frame2;

    public WebElement frame2() {
        return frame2;
    }

    @FindBy(id = "sampleHeading")
    private WebElement frame2heading;

    public WebElement frame2heading() {
        return frame2heading;
    }

    @FindBy(xpath = "//span[text()='Modal Dialogs']")
    private WebElement modalDialogs;

    public WebElement modalDialogs() {
        return modalDialogs;
    }

    @FindBy(id = "showSmallModal")
    private WebElement smallModal;

    public WebElement smallModal() {
        return smallModal;
    }

    @FindBy(id = "showLargeModal")
    private WebElement largeModal;

    public WebElement largeModal() {
        return largeModal;
    }

    @FindBy(xpath = "//div[@class='modal-header']/div")
    private WebElement smallModalText;

    public WebElement smallModalText() {
        return smallModalText;
    }

    @FindBy(css = "#closeSmallModal")
    private WebElement closeSmallModal;

    public WebElement closeSmallModal() {
        return closeSmallModal;
    }

    @FindBy(xpath = "//div[@class='modal-header']/div")
    private WebElement largeModalText;

    public WebElement largeModalText() {
        return largeModalText;
    }

    @FindBy(css = "#closeLargeModal")
    private WebElement closeLargeModal;

    public WebElement closeLargeModal() {
        return closeLargeModal;
    }

    @FindBy(xpath = "//span[text()='Accordian']")
    private WebElement accordian;

    public WebElement accordian() {
        return accordian;
    }

    @FindBy(id = "section2Heading")
    private WebElement accordianHeading;

    public WebElement accordianHeading() {
        return accordianHeading;
    }

    @FindBy(xpath = "//*[@id='section2Content']/parent::div")
    private WebElement accordianContent;

    public WebElement accordianContent() {
        return accordianContent;
    }

    @FindBy(xpath = "//span[text()='Auto Complete']")
    private WebElement autoComplete;

    public WebElement autoComplete() {
        return autoComplete;
    }

    @FindBy(css = "#autoCompleteMultipleInput")
    private WebElement multipleColors;

    public WebElement multipleColors() {
        return multipleColors;
    }

    @FindBy(css = "#autoCompleteSingleInput")
    private WebElement singleColor;

    public WebElement singleColor() {
        return singleColor;
    }

    @FindBy(xpath = "//div[contains(@class,'auto-complete__multi-value__label')]")
    private List<WebElement> multipleColorsSelected;

    public List<WebElement> multipleColorsSelected() {
        return multipleColorsSelected;
    }

    @FindBy(xpath = "//div[contains(@class,'singleValue')]")
    private WebElement singleColorsSelected;

    public WebElement singleColorsSelected() {
        return singleColorsSelected;
    }

    @FindBy(xpath = "//span[text()='Date Picker']")
    private WebElement datePicker;

    public WebElement datePicker() {
        return datePicker;
    }

    @FindBy(id = "datePickerMonthYearInput")
    private WebElement selectDate;

    public WebElement selectDate() {
        return selectDate;
    }

    @FindBy(xpath = "//div[@class='react-datepicker__week']/div")
    private List<WebElement> selectDay;

    public List<WebElement> selectDay() {
        return selectDay;
    }

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement selectMonth;

    public Select selectMonth() {
        Select month = new Select(selectMonth);
        return month;
    }

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement selectYear;

    public Select selectYear() {
        Select year = new Select(selectYear);
        return year;
    }

    @FindBy(id = "dateAndTimePickerInput")
    private WebElement selectDateAndTime;

    public WebElement selectDateAndTime() {
        return selectDateAndTime;
    }

    @FindBy(xpath = "//span[contains(@class,'selected-month')]")
    private WebElement selectedMonth;

    public WebElement selectedMonth() {
        return selectedMonth;
    }

    @FindBy(xpath = "//button[@aria-label='Next Month']")
    private WebElement nextMonth;

    public WebElement nextMonth() {
        return nextMonth;
    }

    @FindBy(xpath = "//div[@class='react-datepicker__week']/div")
    private List<WebElement> selectDateAndTimeDay;

    public List<WebElement> selectDateAndTimeDay() {
        return selectDateAndTimeDay;
    }

    @FindBy(xpath = "//ul[@class='react-datepicker__time-list']/li")
    private List<WebElement> selectTime;

    public List<WebElement> selectTime() {
        return selectTime;
    }

    @FindBy(xpath = "//span[text()='Slider']")
    private WebElement slider;

    public WebElement slider() {
        return slider;
    }

    @FindBy(xpath = "//input[contains(@class,'slider')]")
    private WebElement sliderWidget;

    public WebElement sliderWidget() {
        return sliderWidget;
    }

    @FindBy(id = "sliderValue")
    private WebElement sliderValue;

    public WebElement sliderValue() {
        return sliderValue;
    }

    @FindBy(xpath = "//span[text()='Progress Bar']")
    private WebElement progressBar;

    public WebElement progressBar() {
        return progressBar;
    }

    @FindBy(id = "startStopButton")
    private WebElement startProgress;

    public WebElement startProgress() {
        return startProgress;
    }

    @FindBy(xpath = "//div[@role='progressbar']")
    private WebElement progressStatus;

    public WebElement progressStatus() {
        return progressStatus;
    }

    @FindBy(xpath = "//span[text()='Tabs']")
    private WebElement tabs;

    public WebElement tabs() {
        return tabs;
    }

    @FindBy(id = "demo-tab-origin")
    private WebElement originTab;

    public WebElement originTab() {
        return originTab;
    }

    @FindBy(id = "demo-tab-more")
    private WebElement moreTab;

    public WebElement moreTab() {
        return moreTab;
    }

    @FindBy(xpath = "//span[text()='Tool Tips']")
    private WebElement toolTips;

    public WebElement toolTips() {
        return toolTips;
    }

    @FindBy(id = "toolTipButton")
    private WebElement hoverOverButton;

    public WebElement hoverOverButton() {
        return hoverOverButton;
    }

    @FindBy(id = "toolTipTextField")
    private WebElement hoverOverTextField;

    public WebElement hoverOverTextField() {
        return hoverOverTextField;
    }

    @FindBy(linkText = "Contrary")
    private WebElement hoverOverText;

    public WebElement hoverOverText() {
        return hoverOverText;
    }

    @FindBy(xpath = "//span[text()='Menu']")
    private WebElement menu;

    public WebElement menu() {
        return menu;
    }

    @FindBy(linkText = "Main Item 2")
    private WebElement menuMainItem2;

    public WebElement menuMainItem2() {
        return menuMainItem2;
    }

    @FindBy(linkText = "SUB SUB LIST »")
    private WebElement menuSubSubList;

    public WebElement menuSubSubList() {
        return menuSubSubList;
    }

    @FindBy(linkText = "Sub Sub Item 2")
    private WebElement menuSubSubItem2;

    public WebElement menuSubSubItem2() {
        return menuSubSubItem2;
    }

    @FindBy(xpath = "//span[text()='Select Menu']")
    private WebElement selectMenu;

    public WebElement selectMenu() {
        return selectMenu;
    }

    @FindBy(xpath = "(//div[contains(@class,'indicator')])[1]")
    private WebElement selectOption;

    public WebElement selectOption() {
        return selectOption;
    }

    @FindBy(xpath = "//div[@id='withOptGroup'] //input[contains(@id,'react-select')]")
    private WebElement enterSelectOption;

    public WebElement enterSelectOption() {
        return enterSelectOption;
    }

    @FindBy(xpath = "(//div[contains(@class,'indicator')])[2]")
    private WebElement selectTitle;

    public WebElement selectTitle() {
        return selectTitle;
    }

    @FindBy(xpath = "//div[@id='selectOne'] //input[contains(@id,'react-select')]")
    private WebElement enterSelectTitle;

    public WebElement enterSelectTitle() {
        return enterSelectTitle;
    }

    @FindBy(id = "oldSelectMenu")
    private WebElement oldStyleSelect;

    public Select oldStyleSelect() {
        Select oldStyle = new Select(oldStyleSelect);
        return oldStyle;
    }

    @FindBy(xpath = "//div[@id='withOptGroup'] //div[contains(@class,'singleValue')]")
    private WebElement verifySelectOption;

    public WebElement verifySelectOption() {
        return verifySelectOption;
    }

    @FindBy(xpath = "//div[@id='selectOne'] //div[contains(@class,'singleValue')]")
    private WebElement verifySelectTitle;

    public WebElement verifySelectTitle() {
        return verifySelectTitle;
    }

    @FindBy(xpath = "//span[text()='Droppable']")
    private WebElement droppable;

    public WebElement droppable() {
        return droppable;
    }

    @FindBy(css = "#draggable")
    private WebElement simpleDraggable;

    public WebElement simpleDraggable() {
        return simpleDraggable;
    }

    @FindBy(css = "#simpleDropContainer #droppable")
    private WebElement simpleDropHere;

    public WebElement simpleDropHere() {
        return simpleDropHere;
    }

    @FindBy(css = "#simpleDropContainer #droppable p")
    private WebElement verifySimpleDragAndDrop;

    public WebElement verifySimpleDragAndDrop() {
        return verifySimpleDragAndDrop;
    }

    @FindBy(css = "a[id*='accept']")
    private WebElement accept;

    public WebElement clickAccept() {
        return accept;
    }

    @FindBy(css = "#acceptDropContainer #acceptable")
    private WebElement acceptableDraggable;

    public WebElement acceptableDraggable() {
        return acceptableDraggable;
    }

    @FindBy(css = "#acceptDropContainer #droppable")
    private WebElement acceptableDropHere;

    public WebElement acceptableDropHere() {
        return acceptableDropHere;
    }

    @FindBy(css = "#acceptDropContainer #droppable p")
    private WebElement verifyAcceptableDragAndDrop;

    public WebElement verifyAcceptableDragAndDrop() {
        return verifyAcceptableDragAndDrop;
    }

    @FindBy(css = "#acceptDropContainer #notAcceptable")
    private WebElement notAcceptableDraggable;

    public WebElement notAcceptableDraggable() {
        return notAcceptableDraggable;
    }

    @FindBy(xpath = "//span[text()='Sortable']")
    private WebElement sortable;

    public WebElement sortable() {
        return sortable;
    }

    @FindBy(css = "div[class*='vertical-list'] div")
    private List<WebElement> verticalList;

    public List<WebElement> verticalList() {
        return verticalList;
    }

    @FindBy(xpath = "//span[text()='Selectable']")
    private WebElement selectable;

    public WebElement selectable() {
        return selectable;
    }

    @FindBy(css = "#verticalListContainer li:nth-child(2)")
    private WebElement select2nd;

    public WebElement select2nd() {
        return select2nd;
    }

    @FindBy(css = "#verticalListContainer li:nth-child(4)")
    private WebElement select4th;

    public WebElement select4th() {
        return select4th;
    }

    @FindBy(xpath = "//span[text()='Resizable']")
    private WebElement resizable;

    public WebElement resizable() {
        return resizable;
    }

    @FindBy(css = "#resizableBoxWithRestriction")
    private WebElement resizableBox;

    public WebElement resizableBox() {
        return resizableBox;
    }

    @FindBy(css = "#resizableBoxWithRestriction span")
    private WebElement resizeBox;

    public WebElement resizeBox() {
        return resizeBox;
    }

    @FindBy(css = "div[class='constraint-area']")
    private WebElement restrictedArea;

    public WebElement restrictedArea() {
        return restrictedArea;
    }

    @FindBy(id = "login")
    private WebElement login;

    public WebElement login() {
        return login;
    }

    @FindBy(id = "userName")
    private WebElement userName;

    public WebElement userName() {
        return userName;
    }

    @FindBy(id = "password")
    private WebElement password;

    public WebElement password() {
        return password;
    }

    @FindBy(css = "#userName-value")
    private WebElement userNameValue;

    public WebElement userNameValue() {
        return userNameValue;
    }

    @FindBy(css = "span[id*='see-book'] a")
    private List<WebElement> allBooks;

    public List<WebElement> allBooks() {
        return allBooks;
    }

    @FindBy(xpath = "//label[text()='Speaking JavaScript']")
    private WebElement bookTitle;

    public WebElement bookTitle() {
        return bookTitle;
    }

    @FindBy(xpath = "//button[starts-with(text(),'Add')]")
    private WebElement addToCollection;

    public WebElement addToCollection() {
        return addToCollection;
    }

    @FindBy(xpath = "//span[text()='Profile']")
    private WebElement profile;

    public WebElement profile() {
        return profile;
    }

    @FindBy(xpath = "//span[starts-with(@id,'see-book')]/a")
    private WebElement bookTitleInProfile;

    public WebElement bookTitleInProfile() {
        return bookTitleInProfile;
    }

    @FindBy(xpath = "//span[@title='Delete']")
    private WebElement deleteBook;

    public WebElement deleteBook() {
        return deleteBook;
    }

    @FindBy(css = "button[id*=ok]")
    private WebElement okToDelete;

    public WebElement okToDelete() {
        return okToDelete;
    }

    @FindBy(xpath = "//button[text()='Log out']")
    private WebElement logOut;

    public WebElement logOut() {
        return logOut;
    }
}