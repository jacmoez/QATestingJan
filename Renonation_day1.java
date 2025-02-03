package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Renonation {

    static WebDriver driver = new EdgeDriver();


    void setUp(){
        driver.get("https://www.renonation.sg/");
        driver.manage().window().maximize();
        System.out.println("Driver Install");
    }

    void projectDetail()throws InterruptedException{
        Thread.sleep(3000);

        //Property type
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/section[1]/div[2]/div/form/div[1]/fieldset/div/div/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='DBSS']")).click();
        Thread.sleep(3000);

        //style
        String stylePath = "//*[@id=\"__next\"]/div/main/section[1]/div[2]/div/form/div[2]/div[1]/fieldset/div/div/div/div";

        driver.findElement(By.xpath(stylePath)).click();
        Thread.sleep(3000);

        //Asian
        driver.findElement(By.xpath("//*[text()='Asian']")).click();
        Thread.sleep(3000);

        //style
        driver.findElement(By.xpath(stylePath)).click();
        Thread.sleep(3000);

        //Modern
        driver.findElement(By.xpath("//*[text()='Modern']")).click();
        Thread.sleep(3000);

        //Budget
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/section[1]/div[2]/div/form/div[2]/div[2]/fieldset/div/div/div")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[text()='S$60,001 - S$80,000']")).click();
        Thread.sleep(3000);
        //find
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/section[1]/div[2]/div/form/button")).click();
        System.out.println("Project Detail Success");
        Thread.sleep(3000);

        //Result
        String result  = driver.findElement(By.tagName("h6")).getText();
        System.out.println(result);

        //Project Click
        driver.findElement(By.xpath("//*[@id=\"allProject\"]/div/div[1]/div/div/div[2]")).click();

        //Living Room
        driver.findElement(By.xpath("//*[@id=\"images\"]/div[1]/div/div[1]")).click();
        Thread.sleep(5000);

        //Kitchen
        driver.findElement(By.xpath("//*[@id=\"images\"]/div[1]/div/div[2]")).click();
        Thread.sleep(5000);

        //Dining Room
        driver.findElement(By.xpath("//*[@id=\"images\"]/div[1]/div/div[3]")).click();
        Thread.sleep(5000);

        //Bedroom
        driver.findElement(By.xpath("//*[@id=\"images\"]/div[1]/div/div[4]")).click();
        Thread.sleep(5000);

        //Bathroom
        driver.findElement(By.xpath("//*[@id=\"images\"]/div[1]/div/div[5]")).click();
        Thread.sleep(5000);

        //Study
        driver.findElement(By.xpath("//*[@id=\"images\"]/div[1]/div/div[6]")).click();
        Thread.sleep(5000);

        //Entrance
        driver.findElement(By.xpath("//*[@id=\"images\"]/div[1]/div/div[7]")).click();
        Thread.sleep(5000);

        driver.navigate().back();

    }

    public static void main(String[] args) throws InterruptedException {
        Renonation r = new Renonation();
        r.setUp();
        r.projectDetail();
        Thread.sleep(5000);
        driver.quit();
    }
}
