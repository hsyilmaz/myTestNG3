package Gun07;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_SoftAssertvsHardAssert {

    @Test
    void hardAssert(){
        String s1="Merhaba";

        System.out.println("HardAssert oncesi");
        Assert.assertEquals(s1,"Merhaba 123","HardAssert Sonucu");
        System.out.println("hardAssert sonrasi");// burasi calismayacak
    }

    @Test
    void softAssert(){


    }
}
