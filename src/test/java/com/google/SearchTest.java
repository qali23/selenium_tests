package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
        m = 3000;//To speed up
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


        sleep(3000);
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


        sleep(3000);
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


    @Test(groups = {"ultimateqa tests"})
    public void ultimateTitleLink() {
        //open test page
        String url = "https://ultimateqa.com/automation";
        driver.get(url);

        WebElement companyLogo = driver.findElement(By.xpath("/html//div[@id='main-menu']//a[@href='https://ultimateqa.com/']/img"));
        String initialURL = driver.getCurrentUrl();
        companyLogo.click();
        sleep(3000);
        String afterURL = driver.getCurrentUrl();

        Assert.assertEquals(afterURL, "https://ultimateqa.com/");
        Assert.assertNotEquals(initialURL, afterURL);

        sleep(10000);
    }



    @Test(groups = { "Recipes Webpage" })
    public void recipesHomepage() {
        //open test page
        String url = "http://localhost:3000/";
        driver.get(url);
        Actions actions = new Actions(driver);

        //Hover mouse over image
        WebElement homepageLink = driver.findElement(By.id("recipesHomepage"));
        homepageLink.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://localhost:3000/recipe_homepage", "Link not working properly");

        sleep(3000);
    }

    @Test(groups = { "Recipes Webpage" })
    public void allRecipesPage() {
        //open test page
        String url = "http://localhost:3000/";
        driver.get(url);
        Actions actions = new Actions(driver);

        //Hover mouse over image
        WebElement allRecipesLink = driver.findElement(By.id("allRecipes"));
        allRecipesLink.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://localhost:3000/", "Link not working properly");

        sleep(5000);
    }

    @Test(groups = { "Recipes Webpage" })
    public void ingredientsPage() {
        //open test page
        String url = "http://localhost:3000/";
        driver.get(url);
        Actions actions = new Actions(driver);

        //Hover mouse over image
        WebElement ingredientsLink = driver.findElement(By.id("ingredients"));
        ingredientsLink.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://localhost:3000/ingredients", "Link not working properly");

        sleep(5000);
    }

    @Test(groups = { "Recipes Webpage" })
    public void chefsPage() {
        //open test page
        String url = "http://localhost:3000/";
        driver.get(url);
        Actions actions = new Actions(driver);

        //Hover mouse over image
        WebElement chefsLink = driver.findElement(By.id("chefs"));
        chefsLink.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://localhost:3000/chefs", "Link not working properly");

        sleep(5000);
    }

    @Test(groups = { "Recipes Webpage" })
    public void imageHover() {
        //open test page
        String url = "http://localhost:3000/";
        driver.get(url);
        Actions actions = new Actions(driver);

        //Hover mouse over image
        WebElement yzmaImage = driver.findElement(By.id("yzma"));
        String initialSource = yzmaImage.getAttribute("src");
        actions.moveToElement(yzmaImage).perform();
        String hoverSource = yzmaImage.getAttribute("src");

        Assert.assertNotEquals(initialSource, hoverSource, "Hovering over Yzma image does not change it.");


        sleep(3000);
    }

    @Test(groups = { "Recipes Webpage" })
    public void newDishSection() {
        //open test page
        String url = "http://localhost:3000/";
        driver.get(url);
        Actions actions = new Actions(driver);

        //Check if new recipe is added successfully
        WebElement dishNameInput = driver.findElement(By.id("fname"));
        dishNameInput.sendKeys("Rick-ar-Dough Shires Bread Recipe");
        WebElement recipeInput = driver.findElement(By.id("lname"));
        recipeInput.sendKeys("450g flour + 350ml water + 1 tsp yeast + 1 tsp salt. Mix and leave for 8ish hours. Bake for 50ish mins.");
        WebElement submitButton = driver.findElement(By.id("submit_button"));
        submitButton.click();


        Assert.assertNotNull(driver.findElement(By.id("Rick-ar-Dough Shires Bread Recipe")));

        sleep(3000);
    }

    @Test( dependsOnMethods = { "newDishSection" }, groups = { "Recipes Webpage" })
    public void newDishLink() {
        //open test page
        String url = "http://localhost:3000/";
        driver.get(url);
        Actions actions = new Actions(driver);

        //Check if new recipe link is added successfully
        WebElement dishNameInput = driver.findElement(By.id("fname"));
        dishNameInput.sendKeys("Rick-ar-Dough Shires Bread Recipe");
        WebElement recipeInput = driver.findElement(By.id("lname"));
        recipeInput.sendKeys("450g flour + 350ml water + 1 tsp yeast + 1 tsp salt. Mix and leave for 8ish hours. Bake for 50ish mins.");
        WebElement submitButton = driver.findElement(By.id("submit_button"));
        submitButton.click();
        WebElement newLink = driver.findElement(By.id("Rick-ar-Dough Shires Bread Recipe_link"));
        newLink.click();

        Assert.assertNotNull(driver.findElement(By.id("Rick-ar-Dough Shires Bread Recipe")));

        sleep(3000);
    }
    @Test(dependsOnMethods = { "newDishSection", "newDishLink" }, groups = { "Recipes Webpage" })
    public void multipleNewDish() {
        //open test page
        String url = "http://localhost:3000/";
        driver.get(url);
        Actions actions = new Actions(driver);

        WebElement dishNameInput = driver.findElement(By.id("fname"));
        WebElement recipeInput = driver.findElement(By.id("lname"));
        WebElement submitButton = driver.findElement(By.id("submit_button"));

        //Check if many new recipes are added successfully
        for(int i =0; i<5; i++){
            dishNameInput.sendKeys("Rick-ar-Dough Shires Bread Recipe"+ i);
            recipeInput.sendKeys("450g flour + 350ml water + 1 tsp yeast + 1 tsp salt. Mix and leave for 8ish hours. Bake for 50ish mins." + i);
            submitButton.click();
            WebElement newLink = driver.findElement(By.id("Rick-ar-Dough Shires Bread Recipe" + i + "_link"));
            newLink.click();
            Assert.assertNotNull(driver.findElement(By.id("Rick-ar-Dough Shires Bread Recipe"+i)));
            sleep(3000);
            dishNameInput.clear();
            recipeInput.clear();
        }
        sleep(3000);
    }

    @AfterMethod(alwaysRun = true)
    private void tearDown(){
        //close browser
        driver.quit();
    }
}
