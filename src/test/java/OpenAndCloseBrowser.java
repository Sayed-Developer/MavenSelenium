import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenAndCloseBrowser {
    private static ChromeDriver driver=null;    // global object from chrome driver .
    // get the path for the project and concatenate with chrome driver path && navigate to the sight needed .
    @BeforeTest
    public void openBrowser(){
        //first step get the project path and concatenate with chromedriver path .
        String path =System.getProperty("user.dir");
        //user.dir => C:\Users\sayed\IdeaProjects\MavenSelenium   && //chrome driver inside the project => Resources\Chrome\chromedriver.exe .
        String chromePath=path + "Resources\\Chrome\\chromedriver.exe";
        System.setProperty("webdriver.chrome.drive",chromePath);
        //second step & word of driver mean mouse and keyboard .
        driver=new ChromeDriver();
        //Navigate to Traffic (PIC) login page .
        driver.navigate().to("http://10.0.0.31/Traffic/Fines/GUI/Pages/Home.aspx?US=1489073672");
        // to maximize the window .
        driver.manage().window().maximize();
    }

    // to get driver value;
    public static ChromeDriver driver()
    {
        return driver;
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
        System.out.println("driver is closed");
    }


}
