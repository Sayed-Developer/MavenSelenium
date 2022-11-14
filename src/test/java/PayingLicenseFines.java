import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.format.DateTimeFormatter;

public class PayingLicenseFines {

    ChromeDriver driver=null;    // global object from chrome driver .

    @Test
    public void payingLicFines() throws InterruptedException {
        driver=OpenAndCloseBrowser.driver();
        driver.findElement(By.id("grouptab_3")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("lnkPayFines")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("BrowseNew_txtLicNumAlfa_txtFL_txt")).sendKeys("ن");
        driver.findElement(By.id("BrowseNew_txtLicNumAlfa_txtSL_txt")).sendKeys("و");
        driver.findElement(By.id("BrowseNew_txtLicNumAlfa_txtTL_txt")).sendKeys("م");
        driver.findElement(By.id("BrowseNew_txtLicNumAlfa_txtD_txt")).sendKeys("157");
        driver.findElement(By.id("BrowseNew_btnSearch")).click();
    }

    @Test
    public void payPOSLicFines() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.name("btnPay_POS")).click();  // Pay POS Button .
        Thread.sleep(2000);
        driver.findElement(By.id("ViewLicense_FinesValueTobePayed1_btnPayAll")).click();   //Pay Button .
        System.out.println("Confirmation Popup Message was clicked 👍👍👍");
        driver.switchTo().alert().accept();  // click on ok from alert message .
        Thread.sleep(2000);
        driver.findElement(By.id("ViewLicense_FinesValueTobePayed1_btnExist")).click();  // Click on Exit Button .
    }
}
