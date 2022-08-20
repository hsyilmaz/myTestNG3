package Gun07;

import Utils.GenelWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Bu sayfadaki bütün elemenalrın driverlar bağlantısı gerekiyor
// bunun için aşağıdaki consructor eklendi ve PageFactory ile
// driver üzerinden bu (this) sayfadaki bütün elemnalar ilşkilendirildi.
// Böylece Sayfa dan nesne türetildiği zaman değil, kullanıldığı
// anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
// aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
// gelmiş oluyor. buna yapıya Page Object Model (POM) adı veriliyor.

public class _03_PlaceOrderElements {
public _03_PlaceOrderElements(WebDriver driver)
{ PageFactory.initElements(driver,this); }

    @FindBy(name="search")
    public WebElement searchInput;

    @FindBy(css="#search  button")
    public WebElement searchbutton;

    @FindBy(linkText="iPod Classic")
    public WebElement iPod;

    @FindBy(css="button#button-cart")
    public WebElement addtoCart;

    @FindBy(linkText = "Checkout")
    public WebElement Checkout;

    @FindBy(id = "button-payment-address")
    public WebElement contin;

    @FindBy(id = "button-shipping-address")
    public WebElement contin2;

    @FindBy(id = "button-shipping-method")
    public WebElement contin3;

    @FindBy(name="agree")
    public WebElement agree;

    @FindBy(id = "button-payment-method")
    public WebElement contin4;

    @FindBy(id="button-confirm")
    public WebElement confirmOrder;

    @FindBy(css="#content>h1")
    public WebElement h1;


}
