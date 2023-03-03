package webui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class GenericPage {
    public WebDriver driver;
    private static final String ALPHA_STRING = "abcdefghijklmnoprstuvwxyz";

    public GenericPage(WebDriver driver) {
        this.driver = driver;
//        documentReady();
    }

    public void fluentWaitForElementDisplayed(WebElement elementToBeDisplayed) {
        new FluentWait<>(elementToBeDisplayed)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(WebElement::isDisplayed);
    }

    public void documentReady() {
        boolean readyStateComplete = false;
        while (!readyStateComplete) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("window.scrollTo(0, document.body.offsetHeight)");
            readyStateComplete = executor.executeScript("return document.readyState").equals("complete");
        }
    }

    @Step("Get page title.")
    public String getPageTitle() {
        String title = driver.getTitle();
        System.out.println("The page title is " + title + ".");
        return title;
    }

    public void mouseClickByLocator( WebElement cssLocator ) {
        Actions builder = new Actions(driver);
        builder.moveToElement(cssLocator);
        builder.perform();
    }

    public String getTextFromWebElement (WebElement webElement) {
        return webElement.getText();
    }

    public static String randomAlphaString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_STRING.length());
            builder.append(ALPHA_STRING.charAt(character));
        }
        return builder.toString();
    }

}