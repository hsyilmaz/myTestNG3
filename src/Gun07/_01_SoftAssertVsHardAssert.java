package Gun07;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {

    @Test
    void hardAssert()
    {
        String s1="Merhaba";

        System.out.println("Hard assert öncesi");
        Assert.assertEquals("Merhaba 123", s1, "HardAssert Sonucu");
        System.out.println("Hard assert sonrası"); // hard assert hata verdiğinde sonrası çalışmaz
    }

    @Test
    void softAssert()
    {
        String strHomePage="www.facebook.com/homepage";
        String strCartPage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccountpage";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals (strHomePage, "www.facebook.com/homepage", "comparison");
        System.out.println("assert 1");

        softAssert.assertEquals (strCartPage,"www.facebook.com/profile");  // fail
        System.out.println("assert 2");

        softAssert.assertEquals (strEditAccount,"www.facebook.com/settings");  // fail
        System.out.println("assert 3");


        softAssert.assertAll(); // bütün assert sonuçlarını işleme koyuyor.

        System.out.println("Aktiflik sonrası");
        // bu bölüm assertAll dan sonra olduğu ve öncesinde hata oluştuğu için yazılamadı.
    }


}
