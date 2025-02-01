package Selenium;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Sleeper;


public class AutoTest2 {
    static WebDriver driver = new EdgeDriver();
    void setUp(){
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        System.out.println("Driver Install");
    }

    void doubleClick() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("field1")).clear();

        Thread.sleep(2000);
        driver.findElement(By.id("field1")).sendKeys("မဂ်လာပါ သီရီ");
        Thread.sleep(2000);

        WebElement doubleClick =  driver.findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"));

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).perform();
        Thread.sleep(2000);

        String result = driver.findElement(By.id("field2")).getAttribute("value");
        System.out.println(result);

        Thread.sleep(3000);
        System.out.println("Double Click Success");
    }

    void dragDrop() throws InterruptedException{
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);

        actions.dragAndDrop(draggable, droppable).perform();
        Thread.sleep(3000);
    }

    void slider() throws InterruptedException{
        Actions actions = new Actions(driver);
        WebElement slider1 = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));
        WebElement slider2 = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[2]"));

        actions.dragAndDropBy(slider1, -75,0).perform();
        Thread.sleep(1000);
        actions.dragAndDropBy(slider2, -300,0).perform();
        Thread.sleep(1000);
        System.out.println("Slider Success");
    }

    void label() throws InterruptedException {
        //driver.findElement(By.id("comboBox")).sendKeys("item 10", Keys.ENTER);
        driver.findElement(By.id("apple")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.findElement(By.id("lenovo")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        driver.findElement(By.id("dell")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(5000);
    }

    public static void main(String[] args) throws InterruptedException {
        AutoTest2 a = new AutoTest2();
        a.setUp();
        //a.doubleClick();
        a.dragDrop();
        a.slider();
        a.label();
        driver.quit();
    }
}
