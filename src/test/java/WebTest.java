import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.*;

public class WebTest {

    @Test
    public void testMenuStartTitle() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";

        System.setProperty(chromeDriver, driverPath);
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']")
        );
        menuBrowseLanguages.click();

        WebElement menuStart = driver.findElement(
                xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );
        menuStart.click();

        WebElement h2 = driver.findElement(
                xpath("//body/div[@id='wrap']/div[@id='main']/h2")
        );

        String actualResult = h2.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testHeaderText() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";

        driver.get(url);

        WebElement headerText = driver.findElement(xpath("//body/div[@id='wrap']/div[@id='header']/h1"));

        String actualResult = headerText.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testSubmitNewLanguageButtonText() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit new Language";

        driver.get(url);
        WebElement submitNewLangButton = driver.findElement(
                xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );

        String actualResult = submitNewLangButton.getText();
        Assert.assertEquals((actualResult.toLowerCase()), (expectedResult.toLowerCase()));

        driver.quit();
    }

    @Test
    public void testSubmitNewLanguageSubmenuHeader() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";

        driver.get(url);

        WebElement submitNewLangButton = driver.findElement(
                xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );
        submitNewLangButton.click();

        WebElement submitSubMenuHeader = driver.findElement(
                xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']")
        );
        String actualResult = submitSubMenuHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testBrowseLanguagesFirstSubmenu() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        String url = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResult = "0-9";

        driver.get(url);

        WebElement submenuFirst = driver.findElement(
                xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='0.html']")
        );
        String actualResult = submenuFirst.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testCreatorsNames() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        String url = "https://www.99-bottles-of-beer.net/";
        String[] expectedResult = new String[]{"Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"};

        driver.get(url);

        WebElement teamPage = driver.findElement(
                xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']")
        );
        teamPage.click();

        String[] actualResult = new String[3];
        for (int i = 0; i < actualResult.length; i++) {
            actualResult[i] = driver
                    .findElement(xpath("//body/div[@id='wrap']/div[@id='main']/h3[" + (i + 1) + "]"))
                    .getText();
        }

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testTitleSearchKeywordJava() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        String url = "https://www.99-bottles-of-beer.net/search.html";
        String expectedResult = "99 Bottles of Beer | Search results for \"Java\"";

        driver.get(url);

        WebElement searchBox = driver.findElement(
                xpath("//body/div[@id='wrap']/div[@id='main']/form[@action='search.html']/p/input[@name='search']")
        );
        WebElement searchButton = driver.findElement(
                xpath("//body/div[@id='wrap']/div[@id='main']/form[@action='search.html']/p/input[@name='submitsearch']")
        );
        searchBox.sendKeys("Java");
        searchButton.click();

        String actualResult = driver.getTitle();
        System.out.println(actualResult);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testSubmitEmptyForm(){
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        String url = "https://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        driver.get(url);

        WebElement submitButton = driver.findElement(
                xpath("//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type='submit']")
        );
        submitButton.click();

        WebElement submitButtonResponse = driver.findElement(
                xpath("//body/div[@id='wrap']/div[@id='main']/p")
        );

        String actualResult = submitButtonResponse.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
