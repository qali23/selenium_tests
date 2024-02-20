package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;


public class SearchTest {
    private WebDriver driver;
    //@Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    private void setUP(@Optional("chrome") String browser){
        //create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //maximize browser window
        driver.manage().window().maximize();
    }
    private void sleep(long m){
        try{
            Thread.sleep(m);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }


    @Test(groups = { "searching" })
    public void positiveSearchTest() {
        //open test page
        String url = "http://google.com/";
        driver.get(url);
        new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement acceptCookies = driver.findElement(By.id("L2AGLb"));
        acceptCookies.click();

        WebElement searchBar = driver.findElement(By.id("APjFqb"));
        searchBar.sendKeys("IM BATMAN");
        searchBar.sendKeys(Keys.ENTER);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, url, "Searching an item and pressing enter does not change the URL?");


        sleep(10000);
    }

    @Test(groups = { "searching" })
    public void searchButtonTest() {
        //open test page
        String url = "http://google.com/";
        driver.get(url);

        //Accept Cookies
        WebElement acceptCookies = driver.findElement(By.id("L2AGLb"));
        acceptCookies.click();

        WebElement searchBar = driver.findElement(By.id("APjFqb"));
        searchBar.sendKeys("IM BATMAN");
        new WebDriverWait(driver, Duration.ofSeconds(5));

//        WebElement googleSearchButton = driver.findElement(By.xpath("/html/body//form[@role='search']//div[@class='A8SBwf']/div[@class='FPdoLc lJ9FBc']/center/input[1]"));
//        googleSearchButton.click();
        List<WebElement> allElementsOfClass = driver.findElements(By.className("gNO89b"));
        for(WebElement element : allElementsOfClass){
            if (element.getAttribute("aria-label").equals("Google Search")){
                element.click();
                break;
            }
        }

        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, url, "Searching an item and clicking Google Search does not change the URL?");


        sleep(10000);
    }

    @Test
    public void imFeelingLuckyButtonTest() {
        //open test page
        String url = "http://google.com/";
        driver.get(url);

        //Accept Cookies
        WebElement acceptCookies = driver.findElement(By.id("L2AGLb"));
        acceptCookies.click();

        WebElement searchBar = driver.findElement(By.id("APjFqb"));
        searchBar.sendKeys("IM BATMAN");

        WebElement clickAwayPlace = driver.findElement(By.xpath("/html//form[@role='search']/div[1]"));
        clickAwayPlace.click();
        new WebDriverWait(driver, Duration.ofSeconds(5));

        //WebElement imFeelingLuckyButton = driver.findElement(By.id("gbqfbb"));
        WebElement imFeelingLuckyButton = driver.findElement(By.xpath("/html/body//form[@role='search']//div[@class='A8SBwf emcav']/div[2]//input[@name='btnI']"));
        imFeelingLuckyButton.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, url, "Searching an item and clicking Google Search does not change the URL?");


        sleep(10000);
    }

    @Test
    public void gmailTest() {
        //open test page
        String url = "http://google.com/";
        driver.get(url);

        //Accept Cookies
        WebElement acceptCookies = driver.findElement(By.id("L2AGLb"));
        acceptCookies.click();

        List<WebElement> allElementsOfClass = driver.findElements(By.className("gb_H"));
        for(WebElement element : allElementsOfClass){
            if (element.getAttribute("aria-label").equals("Search for Images (opens a new tab)")){
                element.click();
                break;
            }
        }

        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, url, "Clicking Gmail does not change the URL?");


        sleep(10000);
    }

    @AfterMethod(alwaysRun = true)
    private void tearDown(){
        //close browser
        driver.quit();
    }
}
