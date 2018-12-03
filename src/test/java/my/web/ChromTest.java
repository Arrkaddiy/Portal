package my.web;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.io.IOException;

public class ChromTest {

        private static ChromeDriverService service;
        public static WebDriver driver;

    @BeforeClass
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\webdraiver\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver(service);
        driver.get("http://localhost:8080/");
    }

    @Test
    public void singInTest() throws InterruptedException {

        login();
        assert driver.getCurrentUrl().equals("http://localhost:8080/main");
    }

    @Test
    public void addInoice() throws InterruptedException {

        login();
        driver.findElement(By.name("date")).sendKeys("2");
        driver.findElement(By.name("point")).sendKeys("2");
        driver.findElement(By.id("3")).submit();
    }

    private void login() {
        driver.findElement(By.linkText("Sing In")).click();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.id("1")).submit();
    }


    @After
    public void tearDown(){
        driver.quit();
    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

}
