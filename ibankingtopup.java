import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import javax.swing.*;

public class ibankingtopup {
    private static WebDriver driver;
void setUp(){
    driver = new EdgeDriver();
    driver.manage().window().maximize();
    System.out.println("Testing: Open Browser Success!");
}

void logIn() throws InterruptedException {
    String username = "xan002";
    String password = "Abank@123";
    driver.get("https://ibanking.abdev.net/");

    driver.findElement(By.id("UserName")).sendKeys(username);
    Thread.sleep(2000);
    driver.findElement(By.name("Password")).sendKeys(password);
    Thread.sleep(2000);

    String captcha = JOptionPane.showInputDialog("Enter Captcha");
    driver.findElement(By.id("CaptchaCode")).sendKeys(captcha);

    driver.findElement(By.id("btnLogin")).click();
    Thread.sleep(2000);

    System.out.println("Login Successful!");
}

void TopUp() throws InterruptedException {
    //Click Top Up icon

    driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/section/div/div/div[1]/a[4]/div/div/div")).click();
    Thread.sleep(2000);
    /*
    driver.findElement(By.id("myButton")).click();
    Thread.sleep(5000); */
// Check mandatory field
    driver.findElement(By.id("btnTopup")).click();

    String err1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/form/section/div/div/div[1]/div/div[1]/div[1]/span[2]/span")).getText();
    Thread.sleep(2000);

    String err2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/form/section/div/div/div[1]/div/div[1]/div[3]/span[2]/span")).getText();
    Thread.sleep(2000);

    String err3 =driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/form/section/div/div/div[1]/div/div[2]/div[1]/span")).getText();

    System.out.println(err1);
    System.out.println(err2);
    System.out.println(err3);



//Click cancel button (to close error msgs)
    driver.findElement(By.id("btnCancel")).click();
    Thread.sleep(2000);

// Click acc number dropdown
driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/form/section/div/div/div[1]/div/div[1]/div[1]/span[1]/span[1]/span/span[2]")).click();
System.out.println("Showing the setup accounts");

// Choose one acc number
    driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[4]")).click();
    Thread.sleep(2000);
}


public static void main(String[] args) throws InterruptedException{

    ibankingtopup i = new ibankingtopup();
    i.setUp();
    i.logIn();
    i.TopUp();
    Thread.sleep(5000);
}

}