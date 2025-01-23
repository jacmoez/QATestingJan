import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.List;

class Main {

    private static WebDriver driver;

    //String img1 = "C:/Users/DELL/Pictures/flower1.jpg";
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
        singleFile.sendKeys(img1);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#singleFileForm button")).click();
        Thread.sleep(3000);
        WebElement multipleFiles = driver.findElement(By.id("multipleFilesInput"));
        multipleFiles.sendKeys(img1,"\n",img2,"\n",img3);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#multipleFilesForm button")).click();
        System.out.println("File Success");

    }


    void tableData(){
        WebElement table = driver.findElement(By.name("BookTable"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

       for(WebElement row : rows){
           List<WebElement> cells = row.findElements(By.tagName(row == rows.getFirst() ? "th" : "td"));
           for(WebElement cell : cells){
               System.out.print(cell.getText() + "\t ");
           }
           System.out.println();
       }
        System.out.println("=".repeat(55));
    }

    void pagination() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"pagination\"]/li[1]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"pagination\"]/li[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"pagination\"]/li[3]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"pagination\"]/li[4]/a")).click();

    }


    public static void main(String[] args) throws InterruptedException {
        Main a = new Main();
        a.setUp();
        a.fileUpload();
        a.tableData();
        a.pagination();
        //a.searchField();
        //a.dynamicButton();

        Thread.sleep(5000);
        driver.quit();

    }


}
