import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class ImmediateFineRegistration {
    ChromeDriver driver;
    // global object from chrome driver .
    @Test
    public void registerFine() throws InterruptedException {
        driver=OpenAndCloseBrowser.driver();
        System.out.println(driver);
        driver.findElement(By.cssSelector("#IcoMainText3 > a")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("lnkAddNew")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("FineRegistration1_txtLicNumAlfa_txtFL_txt")).sendKeys("ن");
        driver.findElement(By.id("FineRegistration1_txtLicNumAlfa_txtSL_txt")).sendKeys("و");
        driver.findElement(By.id("FineRegistration1_txtLicNumAlfa_txtTL_txt")).sendKeys("م");
        driver.findElement(By.id("FineRegistration1_txtLicNumAlfa_txtD_txt")).sendKeys("157");
        driver.findElement(By.id("FineRegistration1_txtGovCode_txt")).sendKeys("02"); // governorate code .
        WebElement list=driver.findElement(By.id("FineRegistration1_ddlGovernment"));
        list.click();
        new Select(list).selectByIndex(1);  // القاهـــرة
        driver.findElement(By.id("FineRegistration1_txtFinePlace_txt")).sendKeys("مدينة نصر");
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        driver.findElement(By.id("FineRegistration1_dtmFineDateed")).sendKeys(date);
        driver.findElement(By.id("FineRegistration1_rblFineCategory_rdlList_1")).click();
        driver.findElement(By.id("FineRegistration1_txtOfficer_txt")).sendKeys("سيد شعبان");
        driver.findElement(By.id("FineRegistration1_txtOtherInfo_txt")).sendKeys("القيادة بدون وعى");
        driver.findElement(By.id("FineRegistration1_FineItems1_btnNewFineItem")).click();
        Thread.sleep(2000);
        WebElement fineDescription =driver.findElement(By.id("FineRegistration1_FineItems1_cgvFineItems_0_1"));
        fineDescription.sendKeys("77");
        fineDescription.sendKeys(Keys.TAB);
        Thread.sleep(1000);
        driver.findElement(By.id("btnSaveFine")).click();
    }

}
