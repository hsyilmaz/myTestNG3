package Gun03;
 /*
   interview: testlere öncelikleri nasıl verirsin ?
   priority, dependency;   Nasıl kullanırsın ?
   1- priority =1 gibi sıralı rakamlar vererek bununla çalışma sırasını belirtirim.
   2- dependOnMethods : bununla kendinden önce hangi metod çalışması gerekiyor ise onu belirtirim.
      bir metodu direkt çalıştırdığınızda kendinden önce bağımlı 1  metod var ise otomatik olarak
      önce onu çağırıp sonra kendisi çalışır. Fakat 2 veya daha fazla tane var ise bağımlı olduğu metod ozaman çalışamaz.
 */


import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {
    @Test
    void startCar()
    {
        System.out.println("Car started");
    }

    @Test(dependsOnMethods = {"startCar"}) // bu testin çalışması, startCar ın hatasız çalışmasına bağımlı
    void driveCar()
    {
        System.out.println("car drove");
//        Assert.fail(); // buraya SKIP odurumunu görebilmek için kondu
    }

    @Test( dependsOnMethods = {"startCar", "driveCar"}) // bu testin çalışması için verilen 2 testin hatasız bitmesi lazım
    void parkCar()
    {
        System.out.println("car parked");
    }

    @Test( dependsOnMethods = "parkCar", alwaysRun = true) //alwaysRun = true bağımlılıkları var ama hata çıkarsa da yine çalıştır
    void stopCar()
    {
        System.out.println("car stopped");
    }
}

