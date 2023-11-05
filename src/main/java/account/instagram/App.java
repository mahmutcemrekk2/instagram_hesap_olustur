package account.instagram;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {

    WebDriver driver;
    String BASE_URL_01 = "https://www.instagram.com/accounts/emailsignup/";
    String BASE_URL_02 = "https://mail.tm/tr/";

    By copyEmailAddressLocator = new By.ByCssSelector("input[type='email']");
    By inputEmailAddressLocator = new By.ByClassName("_aa48");

    By instagramLogoLocator = new By.ByCssSelector("div[role='button']");

    private void waitFor(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public App(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get(BASE_URL_02);
    }

    public String copyMailAddress(){
        waitFor(copyEmailAddressLocator);
        String mailAddress = driver.findElement(copyEmailAddressLocator).getText();
        System.out.println("mail adres " + mailAddress);
        return mailAddress;
    }

    public void navigateToInstagram(){
        driver.get(BASE_URL_01);
    }

    public void inputEmailAddress(String mail){
        //waitFor(instagramLogoLocator);
        //driver.findElements(inputEmailAddressLocator).get(0).sendKeys(mail);
        driver.get(BASE_URL_02);
    }


    public static void main(String[] args){

        App app = new App();
        app.copyMailAddress();
        //app.navigateToInstagram();
        //app.inputEmailAddress(app.copyMailAddress());

    }

}

