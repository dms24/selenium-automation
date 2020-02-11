import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;


public class FirstTest {
    @BeforeMethod
    public void beforeTest(){
        System.out.println("before");
    }
    @AfterMethod
    public void afterTest(){
        System.out.println("after");
    }
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test2() {
        System.out.println("test2");
    }
    @Test
    public void login(){
        System.setProperty("webdriver.gecko.driver", "src/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement loginBtn = driver.findElement(By.id("SubmitLogin"));

        wait.until(ExpectedConditions.visibilityOf(email));

        email.sendKeys("nw@test.com");
        password.sendKeys("test1");
        loginBtn.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("account"))));
        Assert.assertEquals(driver.findElement(By.className("account")).getText(),"test test");

        driver.quit();
    }

}
