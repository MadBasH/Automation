package Maven_Projects;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.*;


import java.time.Duration;

public class MainTest {
    ReadData dataReader = new ReadData();
    String[][] testData = dataReader.getData("login");
    String email = testData[0][0]; // E-posta değeri
    String password = testData[0][1]; // Şifre değeri
    String url = testData[0][2]; // url

    private WebDriver driver;
    private Main mainPage;

    public MainTest() throws IOException {
    }

    @Before
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver","E://jarfiles//chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
//      driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.trendyol.com/");
        driver.get(url);
        mainPage = new Main(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void openTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.cookie)).click();
        String expectedTitle = "En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }
    @Test
    public void samsungSearch() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.cookie)).click();
        wait.until(ExpectedConditions.visibilityOf(mainPage.girisYap)).click();

        wait.until(ExpectedConditions.visibilityOf(mainPage.ePosta)).sendKeys(email);
        mainPage.sifre.sendKeys(password);
//        wait.until(ExpectedConditions.visibilityOf(mainPage.ePosta)).sendKeys("byr0ckd4r@gmail.com");
//        mainPage.sifre.sendKeys("TestingAutomation1.");


        String initialUrl = driver.getCurrentUrl();
        mainPage.girisButonu.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(initialUrl)));
        wait.until(ExpectedConditions.visibilityOf(mainPage.searchBar)).sendKeys("Samsung");
        mainPage.searchButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.android)).click();
        boolean found = false;
        for (WebElement samsung : mainPage.samsungs) {
            String productText = samsung.getText();
            if (productText.toLowerCase().contains("samsung")) {
                found = true;
                break;
            }
        }
    }
    @Test
    public void besinciUrun() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.cookie)).click();
        wait.until(ExpectedConditions.visibilityOf(mainPage.girisYap)).click();

        wait.until(ExpectedConditions.visibilityOf(mainPage.ePosta)).sendKeys(email);
        mainPage.sifre.sendKeys(password);
//        wait.until(ExpectedConditions.visibilityOf(mainPage.ePosta)).sendKeys("byr0ckd4r@gmail.com");
//        mainPage.sifre.sendKeys("TestingAutomation1.");


        String initialUrl = driver.getCurrentUrl();
        mainPage.girisButonu.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(initialUrl)));
        wait.until(ExpectedConditions.visibilityOf(mainPage.searchBar)).sendKeys("Samsung");
        mainPage.searchButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.android)).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 2500);");
        wait.until(ExpectedConditions.urlContains("pi=2"));
        String expectedURL = "https://www.trendyol.com/sr?q=samsung&qt=Samsung&st=Samsung&lc=164461&os=1&pi=2";
        String currentURL = driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
        System.out.println(expectedURL);
        if (currentURL.equals(expectedURL)) {
            System.out.println("Sayfa URL'si beklenen URL ile eşleşiyor.");
        }
        js.executeScript("arguments[0].click();", mainPage.besinciUrun);
    }
    @Test
    public void urunListeyeEklendi() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.cookie)).click();
        wait.until(ExpectedConditions.visibilityOf(mainPage.girisYap)).click();

        wait.until(ExpectedConditions.visibilityOf(mainPage.ePosta)).sendKeys(email);
        mainPage.sifre.sendKeys(password);
//        wait.until(ExpectedConditions.visibilityOf(mainPage.ePosta)).sendKeys("byr0ckd4r@gmail.com");
//        mainPage.sifre.sendKeys("TestingAutomation1.");


        String initialUrl = driver.getCurrentUrl();
        mainPage.girisButonu.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(initialUrl)));
        wait.until(ExpectedConditions.visibilityOf(mainPage.searchBar)).sendKeys("Samsung");
        mainPage.searchButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.android)).click();
        wait.until(ExpectedConditions.urlContains("164461"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 2500);");
        wait.until(ExpectedConditions.urlContains("pi=2"));
        js.executeScript("arguments[0].click();", mainPage.besinciUrun);
        String parentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String tiklanmisUrun = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-detail-container div.flex-container:nth-child(2) div.product-container div.container-right-content div.product-detail-wrapper div.pr-in-w:nth-child(1) div:nth-child(1) div.pr-in-cn div:nth-child(1) h1.pr-new-br > span:nth-child(2)"))).getText();
        js.executeScript("arguments[0].click();", mainPage.favoriButonu);
        String classAttribute = driver.findElement(By.className("i-heart-orange")).getAttribute("class");
        System.out.println(classAttribute);
        if (classAttribute.contains("i-heart-orange")){
            System.out.println("favorilere eklendi");
        }
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.favoriList)).click();
        String listeTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.favorites-wrapper div.infinite-scroll-v2 div.favored-product-container div.p-card-wrppr div.prdct-campaign-wrapper a.p-card-chldrn-cntnr div.prdct-desc-cntnr-wrppr div.prdct-desc-cntnr > span.prdct-desc-cntnr-name.no-white-space"))).getText();
        if (listeTest.equals(tiklanmisUrun)) {
            System.out.println("Eklenen ürün doğru");
        }
        js.executeScript("arguments[0].scrollIntoView();", mainPage.sepeteEkle);
        js.executeScript("arguments[0].click();", mainPage.sepeteEkle);
        String sepetButonu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='container']/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[3]"))).getAttribute("class");
        if (sepetButonu.contains("success")) {
            System.out.println("Sepete eklendi");
        }
        js.executeScript("arguments[0].scrollIntoView();", mainPage.sepet);
        js.executeScript("arguments[0].click();", mainPage.sepet);
        js.executeScript("arguments[0].scrollIntoView();", mainPage.kaldir);
        mainPage.anladim.click();
        mainPage.kaldir.click();
        String kaldirmaMesaji = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div:nth-child(2) div:nth-child(1) div.pb-wrapper div.pb-basket-item-removed-item-information-label.single > p:nth-child(1)"))).getText();
        if (kaldirmaMesaji.contains("sepetinden kaldırıldı")) {
            System.out.println("Sepetten kaldırıldı");
        }
    }
}