

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.List;

public class AutoTest {

    private static WebDriver driver;

    void setUp(){
        driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        System.out.println("Driver Install");
        System.out.println("Test 1 : Open Browser Success");
    }

    void fileUpload() throws InterruptedException {
        String img1 = "C:/Users/DELL/Pictures/flower1.jpg";
        String img2 = "C:/Users/DELL/Pictures/flower2.jpg";
        String img3 = "C:/Users/DELL/Pictures/flower3.jpg";

        WebElement singleFile = driver.findElement(By.id("singleFileInput"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", singleFile);
        singleFile.sendKeys(img1);
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id=\"singleFileForm\"]/button")).click();
        driver.findElement(By.cssSelector("#singleFileForm button")).click();

        Thread.sleep(3000);

        WebElement multipleFiles = driver.findElement(By.id("multipleFilesInput"));
        multipleFiles.sendKeys(img1+"\n", img2, "\n"+ img3);
        driver.findElement(By.cssSelector("#multipleFilesForm button")).click();

        System.out.println("File Upload Success!");

    }

    void tableData(){
        WebElement table = driver.findElement(By.name("BookTable"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName(row == rows.getFirst()? "th" : "td"));
                for(WebElement cell : cells){
                    System.out.println(cell.getText() + "\t");
                }
            System.out.println();
        }
        System.out.println("=".repeat(55));
    }

    void pagination() throws InterruptedException{
        WebElement table = driver.findElement(By.id("productTable"));
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for(WebElement cell : cells){
                System.out.println(cell.getText() + "\t");
            }
            System.out.println();
        }

        WebElement pagination = driver.findElement(By.id("pagination"));
        List<WebElement> buttons = pagination.findElements(By.tagName("a"));

        for(WebElement button : buttons){
            button.click();
            Thread.sleep(4000);
        }
        driver.findElement(By.xpath("//*[@id=\"productTable\"]/tbody/tr[1]/td[4]/input")).click();
        System.out.println("Pagination Success");
    }

    void searchField() throws InterruptedException {
        driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Myanmar");
        Thread.sleep(2000);

        driver.findElement(By.className("wikipedia-search-button")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id=\"wikipedia-search-result-link\"]/a")).click();

        driver.findElement(By.linkText("Myanmar")).click();
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        Thread.sleep(3000);
        driver.close();
        Thread.sleep(3000);
       driver.switchTo().window(handles.getFirst());
//        Thread.sleep(2000);

        //driver.close();

        System.out.println("Search Field Success");

    }

    void dynamicButton() throws InterruptedException {
        driver.findElement(By.name("start")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("stop")).click();
    }

    public static void main(String[] args) throws InterruptedException {
        AutoTest a = new AutoTest();
        a.setUp();
        //a.fileUpload();
        //a.tableData();
        //a.pagination();
        a.searchField();
        a.dynamicButton();

        Thread.sleep(5000);
        driver.quit();

    }


}
