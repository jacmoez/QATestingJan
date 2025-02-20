package ibanking;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

class IBankingTopUp {
    private static WebDriver driver;
    public static String acc_number ="0001010200028482";
    void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        System.out.println("Testing: Open Browser Success!");
    }

    void logIn() throws InterruptedException {
        String username = "ThitKhwa";
        String password = "Aa@12345";
        driver.get("https://ibanking.abdev.net/");

        driver.findElement(By.id("UserName")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.name("Password")).sendKeys(password);
        Thread.sleep(2000);
        //09421020561
        //09421022637
//        String captcha = JOptionPane.showInputDialog("Enter Captcha");
//        driver.findElement(By.id("CaptchaCode")).sendKeys(captcha);

        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(2000);

        System.out.println("Login Successful!");
    }

    void checkTransitionHistory() throws InterruptedException {
        // click dashboard
        driver.findElement(By.xpath("/html/body/div[1]/aside/section/form/ul/li[1]/a/span")).click();
        Thread.sleep(2000);
        // dashboard transition history
        driver.findElement(By.xpath("/html/body/div[1]/aside/section/form/ul/li[3]/a/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("btnSearch")).click();
        Thread.sleep(2000);
        List<WebElement> transitionList=driver.findElements(By.xpath("/html/body/div[1]/div[2]/section[2]/section/div/div[1]/div[2]/table/tbody/tr"));
        System.out.println("Transition History Count : "+transitionList.size());


        // /html/body/div[1]/div[2]/section[2]/section/div/div[1]/div[2]/table/tbody/tr[1]
        // /html/body/div[1]/div[2]/section[2]/section/div/div[1]/div[2]/table/tbody/tr[2]
    }
    void TopUp() throws InterruptedException {
        //Click Top Up icon
        // dashboard
        driver.findElement(By.xpath("/html/body/div[1]/aside/section/form/ul/li[1]/a/span")).click();
        Thread.sleep(5000);
        topUpWithBlank();
        topupWithCancel();
        topupWithRealNumber();
    }

    public  String findAccAndAmount(){

        List<WebElement> accounts=driver.findElements(By.cssSelector(".panel-body"));

//        for(WebElement account : accounts){
//            String account_number=account.findElement(By.cssSelector(".lg-item-text")).getText().trim();
//            System.out.println("Account number : "+account_number);
//
//            String amount=account.findElement(By.cssSelector(".pull-right .lg-item-text")).getText().trim();
//            System.out.println("Amount : "+amount);
//
//            System.out.println("---------------------------");
//        }

        for(WebElement account : accounts){
            String account_number=account.findElement(By.cssSelector(".lg-item-text")).getText().trim();
            String amount=account.findElement(By.cssSelector(".pull-right .lg-item-text")).getText().trim();
            if(account_number.equals(acc_number)){
                return  amount;
            }
        }
        return  null;
    }



    public static void topUpWithBlank() throws InterruptedException {

        //dashboard top up
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/section/div/div/div[1]/a[4]/div/div/div/h5")).click();

        Thread.sleep(2000);
        // Check mandatory field
        driver.findElement(By.id("btnTopup")).click();

        String err1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/form/section/div/div/div[1]/div/div[1]/div[1]/span[2]/span")).getText();
        Thread.sleep(2000);

        String err2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/form/section/div/div/div[1]/div/div[1]/div[3]/span[2]/span")).getText();
        Thread.sleep(2000);

        String err3 =driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/form/section/div/div/div[1]/div/div[2]/div[1]/span")).getText();

        System.out.println(err1);
        System.out.println(err2);
        System.out.println(err3);
    }

    public  static  void topupWithCancel() throws InterruptedException {
        // Click acc number dropdown
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/form/section/div/div/div[1]/div/div[1]/div[1]/span[1]/span[1]/span/span[2]")).click();
        System.out.println("Showing the setup accounts");

        // Choose one acc number
        // saving 48
        //driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[3]")).click();
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(acc_number,Keys.ENTER);
        Thread.sleep(2000);

        //Enter mobile number
        driver.findElement(By.id("MobileNo")).sendKeys("09964233241");
        Thread.sleep(3000);

        //Click amount drop down
        driver.findElement(By.id("select2-ddlamount-container")).click();
        Thread.sleep(5000);

        //Click amount drop down
        driver.findElement(By.id("select2-ddlamount-container")).click();
        Thread.sleep(5000);


        //Choose Amount
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("3000", Keys.ENTER);
        Thread.sleep(3000);


        //Click Cancel button
        driver.findElement(By.id("btnCancel")).click();
        System.out.println("Cancel Button success");
    }


    public  static void topupWithRealNumber() throws InterruptedException {
        //Click topup button
        driver.findElement(By.id("btnTopup")).click();
        Thread.sleep(3000);

        // Click acc number dropdown
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/form/section/div/div/div[1]/div/div[1]/div[1]/span[1]/span[1]/span/span[2]")).click();
        System.out.println("Showing the setup accounts");

        // Choose one acc number
//        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[3]")).click();
//        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(acc_number,Keys.ENTER);
        Thread.sleep(2000);

        String beforebal = driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/form/section/div/div/div[1]/div/div[1]/div[2]/div")).getText();

        //Enter mobile number
        driver.findElement(By.id("MobileNo")).sendKeys("09964233241");
        Thread.sleep(3000);

        //Click amount drop down
        driver.findElement(By.id("select2-ddlamount-container")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("select2-ddlamount-container")).click();

        //Choose Amount
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("3000", Keys.ENTER);
        Thread.sleep(3000);

        //Click topup button
        driver.findElement(By.id("btnTopup")).click();
        Thread.sleep(3000);

        //Click Confirm button
        driver.findElement(By.id("confirm")).click();
        Thread.sleep(3000);

        // Net Amount
        String netAmt=driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/form[1]/section/div/div/div/div/div[1]/div[6]/div[2]/div")).getText();

        System.out.println("Net Amount "+netAmt);

        //Enter transaction pin
        driver.findElement(By.id("password-field")).sendKeys("112233", Keys.ENTER);
        Thread.sleep(3000);

        driver.findElement(By.id("btn_OK")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[1]/aside/section/form/ul/li[1]/a")).click();
        Thread.sleep(2000);



        String afterbal = driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/section/div/div/div[2]/div[1]/div/a[1]/div/div[3]/div")).getText();

        System.out.println("Balance Check");
        System.out.println("Topup Amount: 3000" );
        System.out.println("Before Balance: " + beforebal);
        System.out.println("After Balance: " + afterbal);


        if(!beforebal.equals(afterbal)){
            System.out.println("Amount deduct successfully");
        } else {
            System.out.println("Error");
        }
    }
    public static void main(String[] args) throws InterruptedException{
        IBankingTopUp i = new IBankingTopUp();
        i.setUp();
        i.logIn();
        String amt=i.findAccAndAmount();
        System.out.println("Before Amount : "+amt);
        i.checkTransitionHistory();
        i.TopUp();
        i.checkTransitionHistory();
        // --- need to click dashboard ---
        System.out.println("After Amount : "+amt);
        Thread.sleep(5000);
    }

}
