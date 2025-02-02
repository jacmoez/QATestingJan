package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import javax.swing.plaf.TableHeaderUI;

public class AutoTest8 {
    static WebDriver driver = new EdgeDriver();


    void setUp(){
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        System.out.println("Driver Install");
    }

    void brokenCode() throws InterruptedException{

        for (int i = 1;  i <= 8; i++){
            System.out.println("Click link: " + i);
            driver.findElement(By.xpath("//*[@id=\"broken-links\"]/a["+ i +"]")).click();
            Thread.sleep(2000);
            System.out.println("Page Title: " + driver.getTitle());

            //Go Back to Page
            driver.navigate().back();
            Thread.sleep(3000);
        }

        System.out.println("Brock Code Success");
        String visitor = driver.findElement(By.id("Stats1_totalCount")).getText();
        System.out.println("Visitor : " + visitor);
    }

    void form() throws  InterruptedException{

        String [] input  = {"QA ခိုင်", "QA သီရီ", "QA အင်ဂျင်း"};
        Thread.sleep(2000);

        for(int i = 1; i < 4 ; i++){
            driver.findElement(By.id("input"+ i )).sendKeys(input[i-1]);
            Thread.sleep(2000);
            driver.findElement(By.id("btn"+i)).click();
            Thread.sleep(200);
        }
        System.out.println("Form Success!");
    }

    void hiddenElementAndAjax() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.linkText("Hidden Elements & AJAX")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("toggleInput")).click();
        String result = driver.findElement(By.id("statusLabel")).getText();
        System.out.println(result);
        Thread.sleep(2000);

        driver.findElement(By.id("toggleCheckbox")).click();
        String result1 = driver.findElement(By.id("statusLabel")).getText();
        System.out.println(result1);
        Thread.sleep(2000);

        driver.findElement(By.id("loadContent")).click();
        Thread.sleep(3000);
        String result2 = driver.findElement(By.id("ajaxContent")).getText();
        Thread.sleep(5000);
        System.out.println(result2);
    }

    void downloadFile() throws InterruptedException{
        Thread.sleep(2000);

        driver.findElement(By.linkText("Download Files")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("inputText")).sendKeys("ဟလို သီရီ မဂ်လာပါ၊");
        Thread.sleep(2000);

        driver.findElement(By.id("generateTxt")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("txtDownloadLink")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("generatePdf")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("pdfDownloadLink")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"post-body-7103635191948372757\"]/button[3]")).click();
        Thread.sleep(3000);
        System.out.println("Download Success");
    }
    public static void main(String[] args) throws InterruptedException {
        AutoTest8 a = new AutoTest8();
        a.setUp();
        //a.brokenCode();
        //a.form();
        //a.hiddenElementAndAjax();
        a.downloadFile();
        driver.quit();
    }
}
