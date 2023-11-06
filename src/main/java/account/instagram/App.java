package account.instagram;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class App {

    WebDriver driver;
    String BASE_URL_01 = "https://www.instagram.com/accounts/emailsignup/";
    String BASE_URL_02 = "https://mail.tm/tr/";
    By copyEmailAddressLocator = new By.ByCssSelector("input[title='Geçici e-posta adresinizi panoya kopyalamak için tıklayın!']");
    By inputEmailAddressLocator = new By.ByClassName("_aa48");

    By instagramLogoLocator = new By.ByCssSelector("div[role='button']");

    private void waitFor(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public App(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL_02);
    }

    public String copyMailAddress(){
        waitFor(copyEmailAddressLocator);
        driver.findElement(copyEmailAddressLocator).click();
        System.out.println("mail adres " );
        return "";
    }

    public void navigateToInstagram(){
        driver.get(BASE_URL_01);
    }

    public void inputEmailAddress(String mail){
        //waitFor(instagramLogoLocator);
        driver.findElements(inputEmailAddressLocator).get(0).sendKeys(mail);
        driver.get(BASE_URL_02);
    }


    public static void main(String[] args){

        App app = new App();
        app.copyMailAddress();
        //app.navigateToInstagram();
        //app.inputEmailAddress(app.copyMailAddress());

    }

}

