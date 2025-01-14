package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class AutoTest1 {

    private static WebDriver driver;

    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        System.out.println("Driver Install");
        System.out.println("Test 1 : Open Browser Success");
    }

    void inputText() throws InterruptedException{
        driver.findElement(By.id("name")).sendKeys("QA Maung Maung");
        Thread.sleep(2000);
        driver.findElement(By.id("name")).clear();

        String [] user = {"QA In Jing", "qa@ams.com.mm", "9778656503"};
        List<WebElement> elements = driver.findElements(By.cssSelector("input[placeholder^='Enter']"));

        for(int i = 0; i < elements.size(); i++){
            elements.get(i).sendKeys(user[i]);
        }

        driver.findElement(By.id("textarea")).sendKeys("Yangon, Myanmar");

        System.out.println("Test 2 : Input Text Success");

//        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("qa@ams.com.mm");
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("input[placeholder='Enter Phone']")).sendKeys("9778656503");
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("input[placeholder='Enter Phone']")).clear();
//        driver.findElement(By.cssSelector("input[placeholder='Enter Phone']")).sendKeys("9250506976");
//        Thread.sleep(2000);
   }

   void radioTest() throws InterruptedException{
        driver.findElement(By.id("female")).click();
        Thread.sleep(2000);
       System.out.println("Test 3: Radio Test Success");
   }

   void checkboxTest(){
        List<WebElement> checkbox = driver.findElements(By.className("form-check-input"));
       System.out.println("Number of checkboxes: " + checkbox.size());

       for(int i = 2; i < checkbox.size(); i +=2){
        checkbox.get(i).click();
       }
       System.out.println("Test 4 : checkbox success");
   }

   void select() throws InterruptedException{
        //       Select country = new Select(driver.findElement(By.id("country")));
//       Thread.sleep(3000);
//       country.selectByIndex(2);
        new Select(driver.findElement(By.id("country"))).selectByValue("japan");

        Select color = new Select(driver.findElement(By.id("colors")));
        color.selectByValue("red");
        Thread.sleep(3000);
        color.selectByValue("yellow");
        Thread.sleep(3000);

        Select animals = new Select(driver.findElement(By.id("animals")));
        animals.selectByValue("dog");
        Thread.sleep(3000);
        animals.selectByValue("cat");
       System.out.println("Test 5 : Select Success");
   }

   void datePicker() throws InterruptedException {
        //data picker 1
        driver.findElement(By.id("datepicker")).sendKeys("07/29/1997", Keys.ENTER);
        Thread.sleep(3000);

        //data picker 2
       driver.findElement(By.id("txtDate")).click();
       Thread.sleep(3000);

       //year
       driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[2]/td[4]/a")).click();

       //data picker 3
       driver.findElement(By.id("start-date")).sendKeys("04/25/1997");
       Thread.sleep(3000);

       driver.findElement(By.id("end-date")).sendKeys("01/14/2025");
       Thread.sleep(3000);

       driver.findElement(By.className("submit-btn")).click();

       String result = driver.findElement(By.id("result")).getText();
       System.out.println(result);

       Thread.sleep(3000);
       driver.findElement(By.className("home-link")).click();

   }
    public static void main(String[] args) throws InterruptedException {
        AutoTest1 a = new AutoTest1();
        a.setUp();
        a.inputText();
        a.radioTest();
        a.checkboxTest();
        a.select();
        a.datePicker();

        Thread.sleep(5000);
        driver.quit();

    }


}
