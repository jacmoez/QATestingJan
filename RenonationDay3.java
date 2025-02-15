package com.example;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

class RenonationDay2 {
    static WebDriver driver = new EdgeDriver();


    void setUp(){
        driver.get("https://web-staging.renonation.sg/");
        driver.manage().window().maximize();
        System.out.println("Driver Install");
    }

        void singUp() throws InterruptedException{
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/header/div/div[2]/div/button[2]")).click();
            Thread.sleep(2000);

            //mobile number
            WebElement mobileInput = driver.findElement(By.name("mobile"));
            mobileInput.sendKeys("8311");

            Random rand = new Random();
            StringBuilder num = new StringBuilder();
            for(int i = 0; i < 4; i++){
                num.append(rand.nextInt(10));
            }
            mobileInput.sendKeys(num.toString());
            Thread.sleep(2000);

           
            driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
            Thread.sleep(2000);

            //OTP Code
            driver.findElement(By.name("otp")).sendKeys("232323");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/form[2]/div/div/button")).click();
            Thread.sleep(2000);
        }

        void stepOne() throws InterruptedException{
            //First Name
            driver.findElement(By.id("firstName")).sendKeys("QA");
            Thread.sleep(2000);
            
            //Last Name
            driver.findElement(By.id("lastName")).sendKeys("Thiri");
            Thread.sleep(2000);

            //Email
            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("thiri");

            Random rand= new Random();
            StringBuilder num = new StringBuilder();
            for(int i = 0; i < 3; i++){
                num.append(rand.nextInt(10));
            }
            email.sendKeys(num.toString(),"@qa.com");
            Thread.sleep(2000);

            //Next
            driver.findElement(By.xpath("//*[@id=\"submitBtnPortal\"]/button")).click();
            Thread.sleep(2000);
        }

        void stepTwo() throws InterruptedException{
            //Property type *
            driver.findElement(By.xpath("//*[@id=\"dreamHome\"]/div/div[2]/div/div[1]/div/fieldset[1]/div/button[3]")).click();
            Thread.sleep(2000);

            //No. of Bedrooms
            driver.findElement(By.cssSelector("button[value=\"4\"]")).click();
            Thread.sleep(2000);

            //Property Status *
            driver.findElement(By.cssSelector("button[value=\"Resale\"]")).click();
            Thread.sleep(2000);

            //Have you collected your keys? *
            driver.findElement(By.cssSelector("button[value=\"false\"]")).click();
            Thread.sleep(2000);

            //What is the estimated key collection period? *
            driver.findElement(By.xpath("//*[@id=\"dreamHome\"]/div/div[2]/div/div[1]/div/div[2]/div/fieldset[1]/div/div/div/div[2]")).click();
            Thread.sleep(1000);

            //month
            driver.findElement(By.xpath("//*[text()=\"Jul - Sep\"]")).click();
            Thread.sleep(1000);

            //year
            driver.findElement(By.xpath("//*[@id=\"dreamHome\"]/div/div[2]/div/div[1]/div/div[2]/div/fieldset[2]/div/div/div/div[2]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[text()=\"2026\"]")).click();
            Thread.sleep(1000);

            String img = "C:/Users/DELL/Pictures/flower3.jpg";
            //Upload File
            driver.findElement(By.name("floorPlanImages")).sendKeys(img);
            Thread.sleep(1000);
            //Next
            driver.findElement(By.xpath("//*[@id=\"submitBtnPortal\"]/button")).click();
        }

        public static void main(String[] args)throws InterruptedException {
        RenonationDay2 r = new RenonationDay2();
        r.setUp();
        r.singUp();
        r.stepOne();
        r.stepTwo();
        Thread.sleep(5000);
        driver.quit();
    }
}
