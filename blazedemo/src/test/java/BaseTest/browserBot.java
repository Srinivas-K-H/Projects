package BaseTest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class browserBot {
    public static WebDriver driver;
    public static final int WAIT_TIME_SHORTDURATION = 15;
    public static final int WAIT_TIME = 40;

    public browserBot(WebDriver driver) throws Exception {
        browserBot.driver = configuration.driver;
    }

    public enum type {
        xpath, id
    }

    public static By getWebDriverBy(String elementName, String locatorStrategy) throws Exception {
        By webdriverby = null;

        switch (type.valueOf(locatorStrategy)) {
            case xpath:
                webdriverby = By.xpath(elementName);
                break;
            case id:
                webdriverby = By.id(elementName);
                break;
        }
        return webdriverby;
    }

    public WebElement getElement(String elementName, String locatorStrategy) throws Exception {
        WebElement element = driver.findElement(getWebDriverBy(elementName, locatorStrategy));
        return element;
    }
    public void waitForElementAppearance(String elementName, String locatorStrategy) throws Exception {
        new WebDriverWait(driver, WAIT_TIME_SHORTDURATION)
                .until(ExpectedConditions.presenceOfElementLocated(getWebDriverBy(elementName, locatorStrategy)));
    }
    public WebElement waitForElementIsVisible(String elementName, String locatorStrategy) throws Exception {
        WebElement element = getElement(elementName, locatorStrategy);
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void sendKeys(String elementName, String locatorStrategy, String keys) throws Exception {
        waitForElementIsVisible(elementName, locatorStrategy);
        getElement(elementName, locatorStrategy).clear();
        getElement(elementName, locatorStrategy).sendKeys(keys);
    }

    public void waitForElementToBeClickable(String elementName, String locatorStrategy) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(getElement(elementName, locatorStrategy)));
    }

    public void click(String elementName, String locatorStrategy) throws Exception {
        waitForElementToBeClickable(elementName, locatorStrategy);
        getElement(elementName, locatorStrategy).click();
    }

    public void verifyTextIsPresent(String elementName, String locatorStrategy, String errorMessage) throws Exception {
        assertTrue(isElementPresent(elementName, locatorStrategy), errorMessage);
    }

    public boolean isElementPresent(String elementName, String locatorStrategy) {
        try {
            if (driver.findElements(getWebDriverBy(elementName, locatorStrategy)).size() != 0) {
                return true;

            } else {
                return false;
            }
        } catch (WebDriverException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

}
