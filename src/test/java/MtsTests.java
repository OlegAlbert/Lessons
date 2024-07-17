import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mts.by");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[normalize-space(text()[1])='Онлайн пополнение' and normalize-space(text()[2])='без комиссии']"));
        assertNotNull(blockTitle, "Блок 'Онлайн пополнение без комиссии' не найден");
    }

    @Test
    public void testPaymentSystemsLogos() {
        List<WebElement> logos = driver.findElements(By.xpath("//div[contains(@class, 'pay__partners')]//img"));
        assertTrue(logos.size() > 0, "Платежные системы отсутствуют");
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Логотип не отображается");
        }
    }

    @Test
    public void testMoreInfoLink() {
        WebElement cookieWrapper = driver.findElement(By.xpath("//button[contains(@class, 'cookie__cancel') and contains(@class, 'cookie__cancel')]"));
        cookieWrapper.click();

        WebElement moreInfoLink = driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']"));
        moreInfoLink.click();

        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    public void testFormSubmission() {
        WebElement cookieWrapper = driver.findElement(By.xpath("//button[contains(@class, 'cookie__cancel') and contains(@class, 'cookie__cancel')]"));
        cookieWrapper.click();

        WebElement serviceTypeDropdown = driver.findElement(By.xpath("//span[contains(@class, 'select__arrow')]"));
        serviceTypeDropdown.click();

        serviceTypeDropdown = driver.findElement(By.xpath("//p[contains(@class, 'select__option') and text() = 'Услуги связи']"));
        serviceTypeDropdown.click();

        WebElement phoneNumberInput = driver.findElement(By.xpath("//input[contains(@class, 'phone') and @id='connection-phone']"));
        phoneNumberInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.xpath("//input[contains(@class, 'total_rub') and @id='connection-sum']"));
        sumInput.sendKeys("50");

        WebElement emailInput = driver.findElement(By.xpath("//input[contains(@class, 'email') and @id='connection-email']"));
        emailInput.sendKeys("asd@mail.ru");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement resultForm = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class, 'bepaid-app')]"))));
        assertTrue(resultForm.isDisplayed(), "Не отображается");
    }
}