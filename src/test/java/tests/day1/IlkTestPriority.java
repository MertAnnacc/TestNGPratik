package tests.day1;

import org.testng.annotations.Test;

public class IlkTestPriority {

    @Test (priority = 6)
    public void ilkTest(){
        System.out.println("Ilk test calisti");
    }

    @Test
    public void ikinciTest(){
        System.out.println("Ikinci test calisti");
    }


    @Test(priority = -9)
    public void ucuncuTest(){
        System.out.println("Ucuncu test calisti");
    }


}


