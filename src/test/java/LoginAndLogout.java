import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginAndLogout {
    ChromeDriver driver=null;
    WebElement login;      // login button is global .
    // get the path for the project and concatenate with chrome driver path && navigate to the sight needed .

    @Test
    public void loginWithValidData()throws InterruptedException{
        driver=OpenAndCloseBrowser.driver();
        // catch login username text box and send valid data to it.
        WebElement userBox = driver.findElement(By.id("login1_txtUserName_txt"));
        userBox.sendKeys("admin");
        // catch login password text box and send valid data to it.
        WebElement passBox = driver.findElement(By.id("login1_txtPassword_txt"));
        passBox.sendKeys("1234");
        // catch login button and click on it.
        login = driver.findElement(By.id("login1_btnOK"));
        login.click();
        // click ok on alert message .
        driver.switchTo().alert().accept();
    }

    @Test
    public void selectValidProsecution() throws InterruptedException {
        WebElement list = driver.findElement(By.id("login1_ddlSites_ddl"));
        list.click();
        new Select(list).selectByIndex(1);  //نيابة مرور القاهرة الكلية
        //click on login .
        login.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        String actualResult =driver.findElement(By.id("ExLabel1")).getText();
        String expectedResult="مرحبا بكم فى نظام نيابات المرور";
        Assert.assertTrue(actualResult.contains(expectedResult),"Error Message: U R not in the welcome page");
        Thread.sleep(3000);
    }

    // check that user can't Log in with invalid credentials .
    @Test
    public void loginWithInvalidData() throws InterruptedException {
        // catch login username text box and send valid data to it.
        WebElement userBox = driver.findElement(By.id("login1_txtUserName_txt"));
        userBox.sendKeys("sayed111");
        // catch login password text box and send valid data to it.
        WebElement passBox = driver.findElement(By.id("login1_txtPassword_txt"));
        passBox.sendKeys("1234");
        // catch login button and click on it.
        WebElement login = driver.findElement(By.id("login1_btnOK"));
        login.click();
        String expectedAlertText="خطأ في الاسم او كلمة السر";
        String actualAlertText=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        //Assert.assertEquals(actualAlertText.contains(expectedAlertText),true);
        Assert.assertTrue(actualAlertText.contains(expectedAlertText));
    }

    // check that user can't Log in with invalid credentials .
    @Test
    public void selectInvalidProsecution(){
        WebElement list = driver.findElement(By.id("login1_ddlSites_ddl"));
        list.click();
        new Select(list).selectByIndex(0);  // ------------
        //click on login .
        login.click();
        String expectedAlertText="من فضلك اختر الموقع";
        String actualAlertText=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        //Assert.assertEquals(actualAlertText.contains(expectedAlertText),true);
        Assert.assertTrue(actualAlertText.contains(expectedAlertText));

    }

    @Test
    public void logOut(){
        driver.findElement(By.id("lnkLogOut")).click();
    }

}
