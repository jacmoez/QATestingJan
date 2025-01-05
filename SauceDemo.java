import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SauceDemo {
    private static WebDriver driver;

    void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        System.out.println("Testing 1: Open Browser Success!");
    }

    void logIn() throws InterruptedException{
        String userName = "standard_user";
        String password = "secret_sauce";
        driver.get("https://www.saucedemo.com/");
        //xpath, id, name,  placeholder,  class, value

        driver.findElement(By.id("user-name")).sendKeys(userName);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        String err1 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();


        Thread.sleep(2000);

        // Error1 close
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3/button")).click();
        Thread.sleep(2000);
        //Password Error
        driver.findElement(By.name("password")).sendKeys("123");
        Thread.sleep(2000);

        //btn click
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        Thread.sleep(2000);

        //Err2 Message
        String err2 =driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Thread.sleep(2000);

        // Error2 close
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3/button")).click();
        Thread.sleep(2000);

        //Password True
        driver.findElement(By.name("password")).clear();
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(2000);

        //btn click
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        Thread.sleep(2000);

        System.out.println(err1);
        System.out.println(err2);
        System.out.println("Login Success!");
    }

    void inventory() throws InterruptedException{
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[6]/div[2]/div[2]/button")).click();
        System.out.println("Inventory success");
    }

    void removeInventory() throws InterruptedException{
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        Thread.sleep(2000);
        System.out.println("Remove Item Success!");
    }

    void viewCard() throws InterruptedException {
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);
        String url = "https://www.saucedemo.com/cart.html";
        String result = (url.equals(driver.getCurrentUrl()))? "View Cart Success": "Not Found";
        System.out.println(result);

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div")).click();
        Thread.sleep(2000);

        //Remove Click
        driver.findElement(By.id("remove")).click();
        Thread.sleep(2000);

        //Shopping Click
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);
    }

    void checkout() throws InterruptedException{
        driver.findElement(By.name("checkout")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("first-name")).sendKeys("QA");
        Thread.sleep(2000);
        driver.findElement(By.name("lastName")).sendKeys("Testing");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("1111");
        Thread.sleep(2000);
        driver.findElement(By.id("continue")).click();
        System.out.println("Check Out Successk");
    }

    void payment() throws InterruptedException {
        String totalItem = driver.findElement(By.className("summary_subtotal_label")).getText();
        String totalTax = driver.findElement(By.className("summary_tax_label")).getText();
        String totalPrice = driver.findElement(By.className("summary_total_label")).getText();

        System.out.println(totalItem);
        System.out.println(totalTax);
        System.out.println(totalPrice);
    }

    void fishi() throws InterruptedException{
        driver.findElement(By.cssSelector(".btn.btn_action.btn_medium.cart_button")).click();
        Thread.sleep(2000);
        String result = driver.findElement(By.tagName("h2")).getText();
        driver.findElement(By.id("back-to-products")).click();
        Thread.sleep(2000);
        System.out.println(result);
    }
    public static void main(String[] args) throws InterruptedException {

        SauceDemo s = new SauceDemo();
        s.setUp();
        s.logIn();
        s.inventory();
        s.removeInventory();
        s.viewCard();
        s.checkout();
        s.payment();
        s.fishi();
        Thread.sleep(5000);
        driver.quit();

    }
}

//txt, pdf, excel, html
//robot

//xpath, id, name, class, placeholder, css sector, tage name