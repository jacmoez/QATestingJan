import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class Main {

    static WebDriver driver = new EdgeDriver();
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

    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
        m.setUp();
        m.pagination();
        m.searchField();
        m.dynamicButton();
        Thread.sleep(5000);
        driver.quit();
    }
}
