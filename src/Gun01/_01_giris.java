package Gun01;

import org.testng.annotations.Test;

public class _01_giris {
//    public static void main(String[] args) {
//        webSitesiniAc();
//        LoginTestIsleminiYap();
//        driverıKapat();
//    }


    @Test(priority=1)  //annotation lar
    void websitesiniAc(){
        System.out.println("Driver tanimlandi ve web sitesi acildi");


    }

    @Test(priority=2)
    void LoginTestIsleminiYap(){
        System.out.println("Login test islemleri yapildi");
        ///yesil tik hatali assertion yok demektir.


    }

    @Test(priority=3)
    void driveriKapat(){
        System.out.println("driver kapatildi ve cikildi");


    }
}
