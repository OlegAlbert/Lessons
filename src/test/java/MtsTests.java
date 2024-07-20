import io.qameta.allure.Description;
import io.qameta.allure.Step;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTests {
    private WebDriver driver;

    @BeforeEach
    @Step("Setting up the browser and navigating to the website")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://mts.by");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

        WebElement cookieWrapper = driver.findElement(By.xpath(
                "//button[contains(@class, 'cookie__cancel') and contains(@class, 'cookie__cancel')]"));
        cookieWrapper.click();
    }

    @AfterEach
    @Step("Closing the browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    //Проверка заполненности полей при выборе "Услуги связи"
    @Test
    @Description("Verify placeholders for fields under 'Connection Services'")
    @DisplayName("Test Connection Services Placeholders")
    public void testEmptyFieldsPlaceholderForConnection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement selectArrow = wait.until(ExpectedConditions.visibilityOfElementLocated((By
                .xpath("//span[contains(@class, 'select__arrow')]"))));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", selectArrow);
        selectArrow.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//p[contains(@class, 'select__option') and text() = 'Услуги связи']")))
                .click();

        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        assertEquals("Номер телефона", phoneInput.getAttribute("placeholder"));

        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        assertEquals("Сумма", sumInput.getAttribute("placeholder"));

        WebElement emailInput = driver.findElement(By.id("connection-email"));
        assertEquals("E-mail для отправки чека", emailInput.getAttribute("placeholder"));
    }

    //Проверка заполненности полей при выборе "Домашний интернет"
    @Test
    @Description("Verify placeholders for fields under 'Home Internet'")
    @DisplayName("Test Home Internet Placeholders")
    public void testEmptyFieldsPlaceholderForInternet() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement selectArrow = wait.until(ExpectedConditions.visibilityOfElementLocated((By
                .xpath("//span[contains(@class, 'select__arrow')]"))));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", selectArrow);
        selectArrow.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//p[contains(@class, 'select__option') and text() = 'Домашний интернет']")))
                .click();

        WebElement phoneInput = driver.findElement(By.id("internet-phone"));
        assertEquals("Номер абонента", phoneInput.getAttribute("placeholder"));

        WebElement sumInput = driver.findElement(By.id("internet-sum"));
        assertEquals("Сумма", sumInput.getAttribute("placeholder"));

        WebElement emailInput = driver.findElement(By.id("internet-email"));
        assertEquals("E-mail для отправки чека", emailInput.getAttribute("placeholder"));
    }

    //Проверка заполненности полей при выборе "Рассрочка"
    @Test
    @Description("Verify placeholders for fields under 'Instalment'")
    @DisplayName("Test Instalment Placeholders")
    public void testEmptyFieldsPlaceholderForInstalment() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement selectArrow = wait.until(ExpectedConditions.visibilityOfElementLocated((By
                .xpath("//span[contains(@class, 'select__arrow')]"))));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", selectArrow);
        selectArrow.click();

        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//p[contains(@class, 'select__option') and text() = 'Рассрочка']")))
                .click();

        WebElement phoneInput = driver.findElement(By.id("score-instalment"));
        assertEquals("Номер счета на 44", phoneInput.getAttribute("placeholder"));

        WebElement sumInput = driver.findElement(By.id("instalment-sum"));
        assertEquals("Сумма", sumInput.getAttribute("placeholder"));

        WebElement emailInput = driver.findElement(By.id("instalment-email"));
        assertEquals("E-mail для отправки чека", emailInput.getAttribute("placeholder"));
    }

    //Проверка заполненности полей при выборе "Задолженность"
    @Test
    @DisplayName("Verify placeholder text for Arrears services")
    @Description("Test to verify placeholder text for 'Arrears services'")
    public void testEmptyFieldsPlaceholderForArrears() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement selectArrow = wait.until(ExpectedConditions.visibilityOfElementLocated((By
                .xpath("//span[contains(@class, 'select__arrow')]"))));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", selectArrow);
        selectArrow.click();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//p[contains(@class, 'select__option') and text() = 'Задолженность']")))
                .click();

        WebElement phoneInput = driver.findElement(By.id("score-arrears"));
        assertEquals("Номер счета на 2073", phoneInput.getAttribute("placeholder"));

        WebElement sumInput = driver.findElement(By.id("arrears-sum"));
        assertEquals("Сумма", sumInput.getAttribute("placeholder"));

        WebElement emailInput = driver.findElement(By.id("arrears-email"));
        assertEquals("E-mail для отправки чека", emailInput.getAttribute("placeholder"));
    }

    //Проверка заполненности полей в окне подтверждения оплаты
    @Test
    @DisplayName("Verify payment confirmation details")
    @Description("Test to fill form and verify payment confirmation details")
    public void testFillFormAndVerifyDetails() {
        String sum = "50.00";
        String phoneNumber = "297777777";
        String email = "asd@mail.ru";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement selectArrow = driver.findElement(By
                .xpath("//span[contains(@class, 'select__arrow')]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", selectArrow);
        selectArrow.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//p[contains(@class, 'select__option') " +
                        "and text() = 'Услуги связи']"))).click();

        // Заполнение поля номера телефона
        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        phoneInput.sendKeys(phoneNumber);

        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.sendKeys(sum);

        WebElement emailInput = driver.findElement(By.id("connection-email"));
        emailInput.sendKeys(email);

        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button"));
        continueButton.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[contains(@class, 'bepaid-iframe')]")
        ));

        WebElement sumText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                        "//div[contains(@class, 'pay-description__cost')]" +
                                "/span[contains(text(), 'BYN')]")));
        assertEquals(sum + " BYN", sumText.getText());

        WebElement phoneNumberText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'pay-description__text')]/span")));
        assertEquals("Оплата: Услуги связи Номер:375" + phoneNumber, phoneNumberText.getText());

        WebElement googlePayButton = wait.until
                (ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[@id='gpay-button-online-api-id']")));
        assertTrue(googlePayButton.isDisplayed());

        WebElement yandexPayButton = wait.until
                (ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@id='yandex-button']/button")));
        assertTrue(yandexPayButton.isDisplayed());


        WebElement cardNumberText = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(
                        ".content input#cc-number + label")));
        assertEquals("Номер карты", cardNumberText.getText());

        WebElement mastercardIcon = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(
                        "img[src*='mastercard-system.svg']")));
        assertTrue(mastercardIcon.isDisplayed());

        WebElement visaIcon = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(
                        "img[src*='visa-system.svg']")));
        assertTrue(visaIcon.isDisplayed());

        WebElement belkartIcon = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(
                        "img[src*='belkart-system.svg']")));
        assertTrue(belkartIcon.isDisplayed());

        WebElement mirIcon = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(
                        "img[src*='mir-system-ru.svg']")));
        assertTrue(mirIcon.isDisplayed());

        WebElement maestroIcon = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(
                        "img[src*='maestro-system.svg']")));
        assertTrue(maestroIcon.isDisplayed());

        WebElement expirationDateText = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(
                        ".content input[formcontrolname='expirationDate'] + label")));
        assertEquals("Срок действия", expirationDateText.getText());

        WebElement CVCText = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(
                        ".content input[formcontrolname='cvc'] + label")));
        assertEquals("CVC", CVCText.getText());

        WebElement holderText = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(
                        ".content input[formcontrolname='holder'] + label")));
        assertEquals("Имя держателя (как на карте)", holderText.getText());

        WebElement sumButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(
                        "//div[contains(@class, 'card-page__card')]/button[contains(text(), 'BYN')]")));
        assertEquals("Оплатить " + sum + " BYN", sumButton.getText());
    }
}