package com.example;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

class RenonationDay4 {
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

        void stepThree() throws InterruptedException{
            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@id=\"preferredStyles\"]/div/div[2]/div/div[1]/div/ul/li[2]/div[1]/div/img")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"submitBtnPortal\"]/button")).click();
            System.out.println("Step Three Success");
        }

        void logOut() throws InterruptedException{
            Thread.sleep(3000);
            //logout icon
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/header/div/div[2]/div/div[2]/div/div/div")).click();
            Thread.sleep(3000); 

            //Logout link
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/header/div/div[2]/div/div[2]/div/div[2]/div")).click();
            Thread.sleep(3000); 

            //Logout Button
            driver.findElement(By.xpath("//*[@id=\"radix-:rk:\"]/form/div/div/button[2]")).click();
            Thread.sleep(2000);
        }
        void search() throws InterruptedException{
            Thread.sleep(3000);
            WebElement element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[4]/section/div[2]/div/a/div[2]"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[4]/section/div[3]/a[2]")).click();
            Thread.sleep(2000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[2]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[3]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[4]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[5]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[6]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[7]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[8]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[9]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[10]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[11]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[12]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[13]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[14]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[15]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[16]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[17]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[18]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[19]/img")));
            Thread.sleep(1000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/section/div[2]/div[1]/div[2]/figure[20]/img")));
           
            
        }
        public static void main(String[] args)throws InterruptedException {
        RenonationDay2 r = new RenonationDay2();
        r.setUp();
        // r.singUp();
        // r.stepOne();
        // r.stepTwo();
        // r.stepThree();
        // r.logOut();
        r.search();
        Thread.sleep(5000);
        driver.quit();
    }
}
