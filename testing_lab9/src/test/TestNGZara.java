import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestNGZara {
    @Test
    public void SearchWomanJeans() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.zara.com/by/");
    WebElement searchBtnElement = driver
            .findElement(By
                    .xpath("//span[text()='Search']"));
    searchBtnElement.click();
    new WebDriverWait(driver, Duration.ofSeconds(20))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("search-products-form-combo-input")));

    WebElement searchInputElement = driver.findElement(By.id("search__basic"));
    searchInputElement.sendKeys("A5");
    searchInputElement.sendKeys(Keys.ENTER);
    new WebDriverWait(driver, Duration.ofSeconds(30))
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
                    .xpath("//span[@class='sc-fznKkj dTlhdB']")));
    List<WebElement> searchResults = driver
            .findElements(By.xpath("//span[@class='sc-fznKkj dTlhdB']"));
    System.out.println("Search results number for requested term: " + searchResults.size());

    Assert.assertTrue(searchResults.size() > 0, "Search results are empty!");
    driver.quit();
}
}