package Day_17;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountTest {
    private  Account acc;

    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("Before class annotaion called : setting up the class level resources");

    }
    @Before
    public  void setUP(){
        acc=new Account(5000);
        System.out.println("@Before annotation called for setting up the account for each test  ");
    }

    @Test
    public void TestDeposit(){
        acc.deposite(1000);
        Assert.assertEquals(6000,acc.getBalanceAmount(),0.001);
    }

    @Test
    public void TestWithDrow(){
        acc.withDrow(2000.00);
        Assert.assertEquals(3000,acc.getBalanceAmount(),0.0001);

    }
    public void tearDown(){
        System.out.println(" Clean up process after each test");
    }
    public static void tearDownClass(){
        System.out.println(" Realising the class resources");
    }
}
