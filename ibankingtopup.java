package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import javax.swing.*;


class Ibankingtopup {
    private static WebDriver driver;
    void setUp(){
        driver = new ChromeDriver();
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



        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(2000);

        System.out.println("Login Successful!");
    }

    void TopUp() throws InterruptedException {
        //Click Top Up icon

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/section/div/div/div[1]/a[4]/div/div/div")).click();
        Thread.sleep(2000);

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

        String sendAccount1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/form/section/div/div/div[1]/div/div[1]/div[2]/div")).getText();

        //Enter mobile number
        driver.findElement(By.id("MobileNo")).sendKeys("09964233241");

        Thread.sleep(3000);

        //Click amount drop down
        driver.findElement(By.id("select2-ddlamount-container")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("select2-ddlamount-container")).click();

        //Choose Amount
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("3000", Keys.ENTER);

        Thread.sleep(3000);

        //Click topup button
        driver.findElement(By.id("btnTopup")).click();
        Thread.sleep(3000);

        //Click Confirm button
        driver.findElement(By.id("confirm")).click();

        Thread.sleep(3000);
        //Enter transaction pin
        driver.findElement(By.id("password-field")).sendKeys("124124", Keys.ENTER);

        String checkStatus = driver.getPageSource();
        if(checkStatus.contains("Successful!")){
            System.out.println("Topup Success");
        } else {
            System.out.println("Topup Fail");
        }
        Thread.sleep(3000);
        driver.findElement(By.id("btn_OK")).click();

        Thread.sleep(3000);

        //balance check
        String sendAccount2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/form/section/div/div/div[1]/div/div[1]/div[2]/div")).getText();

        System.out.println(sendAccount1);
        System.out.println(sendAccount2);
        System.out.println("===================Balance Check================================");
        if(!sendAccount1.equals(sendAccount2)){
            System.out.println("Success Full Don");
        } else {
            System.out.println("Success Full Don");
        }
    }


    public static void main(String[] args) throws InterruptedException{

        Ibankingtopup i = new Ibankingtopup();
        i.setUp();
        i.logIn();
        i.TopUp();
        Thread.sleep(5000);
    }

}
//Phone: 09964233241
