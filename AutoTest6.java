package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class Main {

    static WebDriver driver = new ChromeDriver();
    void setUp(){
        driver.get("https://testautomationpractice.blogspot.com/");
        System.out.println("Driver Install");
    }

    void pagination() throws InterruptedException {

        WebElement pagination = driver.findElement(By.id("pagination"));
        List<WebElement> buttons = pagination.findElements(By.tagName("a"));

        for(WebElement button : buttons){
            button.click();
            Thread.sleep(2000);

            WebElement table = driver.findElement(By.id("productTable"));
            List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"));
            for(int i = 1; i < 6; i ++ ){
                String check = "/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div[5]/div[1]/div/table/tbody/tr["+ i +"]/td[4]/input";

                driver.findElement(By.xpath(check)).click();
                Thread.sleep(2000);
            }
            for(WebElement row : rows){
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for(WebElement cell : cells ){
                    System.out.print(cell.getText() + "\t ");
                }
                System.out.println();
            }
            System.out.println("Click Page: " + button.getText());


        }
    }

    void searchField() throws InterruptedException {
        driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Myanmar");
        Thread.sleep(1000);
        driver.findElement(By.className("wikipedia-search-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"wikipedia-search-result-link\"]/a")).click();
    }

    void dynamicButton() throws InterruptedException {
        driver.findElement(By.name("start")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("stop")).click();
        System.out.println("Dynamic Button Success");
    }

    void tab() throws InterruptedException {
        Thread.sleep(3000);
        WebElement alertBtn = driver.findElement(By.id("alertBtn"));
        alertBtn.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //Confirm Alert
        WebElement confirmBtn = driver.findElement(By.id("confirmBtn"));
        confirmBtn.click();
        Thread.sleep(2000);

        alert = driver.switchTo().alert();
        alert.accept();

        String result = driver.findElement(By.id("demo")).getText();
        System.out.println(result);

        confirmBtn.click();
        Thread.sleep(2000);

        alert = driver.switchTo().alert();
        alert.dismiss();

         result = driver.findElement(By.id("demo")).getText();
        System.out.println(result);

        Thread.sleep(2000);

        WebElement popUpBtn = driver.findElement(By.id("promptBtn"));
        popUpBtn.click();
        Thread.sleep(5000);

        alert = driver.switchTo().alert();
        alert.sendKeys("Thiri");
        alert.accept();

        result = driver.findElement(By.id("demo")).getText();
        System.out.println(result);



    }

    void newTab() throws InterruptedException{
        Thread.sleep(2000);
        WebElement newTabBtn = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/aside/div/div[4]/div[1]/button"));
        newTabBtn.click();
        Thread.sleep(3000);

        List<String> pageChange = List.copyOf(driver.getWindowHandles());
        driver.switchTo().window(pageChange.get(1));
        driver.close();

        driver.switchTo().window(pageChange.getFirst());

        Thread.sleep(2000);

        //driver.findElement(By.id("PopUp")).click();
    }

    void hoverBtn() throws InterruptedException{
        WebElement dropBtn = driver.findElement(By.className("dropbtn"));
        dropBtn.click();
        Thread.sleep(1500);
         driver.findElement(By.linkText("Mobiles")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("field1")).clear();
        Thread.sleep(2000);

        driver.findElement(By.id("field1")).sendKeys("Hello Thrir");



    }

    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
        m.setUp();
//        m.pagination();
//        m.searchField();
//        m.dynamicButton();
        //m.tab();
        m.newTab();
        m.hoverBtn();
        Thread.sleep(5000);
        driver.quit();
    }
}
