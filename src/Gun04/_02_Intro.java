package Gun04;

import org.testng.annotations.*;

public class _02_Intro {
    /*
     @BeforeSuit
       @BeforeTest
         @BeforeGroup
           @BeforeClass
             @BeforeMethod
               @Test
               @Test
             @AfterMethod
           @AfterClass
        @AfterGroup
     @AfterTest
   @AfterSuit
    */

    @BeforeSuite
    void bSuit(){ System.out.println("Before Suit"); }

    @BeforeTest
    void bTest(){ System.out.println("Before Test"); }

    @BeforeGroups
    void bGroups(){ System.out.println("Before Groups"); }

    @BeforeClass
    void bClass(){ System.out.println("Before Class"); }

    @BeforeMethod
    void bMethod(){ System.out.println("Before Method"); }

    @Test
    void intro1_1(){ System.out.println("Test intro 1_1"); }

    @Test
    void intro1_2(){ System.out.println("Test intro 1_2"); }

    @AfterMethod
    void aMethod(){ System.out.println("After Method"); }

    @AfterClass
    void aClass(){ System.out.println("After Class"); }

    @AfterGroups
    void aGroups(){ System.out.println("After Groups"); }

    @AfterTest
    void aTest(){ System.out.println("After Test"); }

    @AfterSuite
    void aSuit(){ System.out.println("After Suit"); }




}
