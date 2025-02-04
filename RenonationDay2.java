package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class RenonationDay2 {
    static WebDriver driver = new EdgeDriver();


    void setUp(){
        driver.get("https://web-staging.renonation.sg/");
        driver.manage().window().maximize();
        System.out.println("Driver Install");
    }

    void login() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/header/div/div[2]/div/button[2]")).click();
        Thread.sleep(2000);

        //Mobile Number
        driver.findElement(By.name("mobile")).sendKeys("8311");
        Thread.sleep(2000);

        //Mobile btn
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/form[1]/div/div/div[1]/button")).click();

        String err = driver.findElement(By.cssSelector(".flex-1.text-sm.text-error")).getText();
        System.out.println(err);

        //Mobile Number Clear
        driver.findElement(By.name("mobile")).clear();
        //Mobile Number
        driver.findElement(By.name("mobile")).sendKeys("83115546", Keys.ENTER);
        Thread.sleep(2000);

        //OTP Code
        driver.findElement(By.name("otp")).sendKeys("232323");
        Thread.sleep(2000);

        //OTP Btn
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/form[2]/div/div/button")).click();
        Thread.sleep(2000);

    }
    void loginVerify() throws InterruptedException {
        //Profile icon
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/header/div/div[2]/div/div[2]")).click();
        Thread.sleep(2000);

        //My Profile
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/header/div/div[2]/div/div[2]/div/div[2]/a[1]/div/div/div")).click();

        //Profile icon
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/header/div/div[2]/div/div[2]")).click();
        Thread.sleep(2000);

        //My Profile
        String expectedUrl = "https://web-staging.renonation.sg/my-profile";
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl != null;
        System.out.println(currentUrl.equals(expectedUrl)? "Login Success" : "Login Fail");

    }

    void logout() throws InterruptedException {

        //Profile icon
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/header/div/div[2]/div/div[2]")).click();
        Thread.sleep(2000);


        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/header/div/div[2]/div/div[2]")).click();
        Thread.sleep(2000);


        //Logout icon
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/header/div/div[2]/div/div[2]/div/div[2]/div")).click();
        Thread.sleep(2000);

        //Logout Btn
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        Thread.sleep(2000);

    }

    public static void main(String[] args)throws InterruptedException {
        RenonationDay2 r = new RenonationDay2();
        r.setUp();
        r.login();
        r.loginVerify();
        r.logout();
        Thread.sleep(5000);
        driver.quit();
    }
}
