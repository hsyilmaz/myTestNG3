package Gun09FPrj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class senarioelements {

    public senarioelements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(css = "[value='Log in']")
    public WebElement login;

    @FindBy(linkText = "Log out")
    public WebElement loginvalidate;

    @FindBy(className = "validation-summary-errors")
    public WebElement hatamsg;

    @FindBy(css= "[value='Add to cart']")
    public List<WebElement>Adding;

    @FindBy(id = "giftcard_2_RecipientName")
    public WebElement recp_name;

    @FindBy(id = "giftcard_2_RecipientEmail")
    public WebElement recp_email;

    @FindBy(id = "add-to-cart-button-2")
    public WebElement addtocart;

    @FindBy(linkText = "Shopping cart")
    public WebElement shopingcart;

    @FindBy(id = "termsofservice")
    public WebElement termservice;

    @FindBy(id = "checkout")
    public WebElement checkoutbtn;

    @FindBy(id = "billing-address-select")
    public WebElement newaddress;

    @FindBy(id = "BillingNewAddress_CountryId")
    public WebElement country;

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    public WebElement state;

    @FindBy(id = "BillingNewAddress_City")
    public WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    public WebElement address;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement postalcode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement number;

    @FindBy(xpath = "(//input[@value='Continue'])[1]")
    public WebElement continue1;

    @FindBy(xpath = "(//input[@value='Continue'])[2]")
    public WebElement continue2;

    @FindBy(xpath = "(//input[@value='Continue'])[3]")
    public WebElement continue3;

    @FindBy(css = "[value='Confirm']")
    public WebElement confrim;

    @FindBy(css = ".title>strong")
    public WebElement txtvalidate;



















}
