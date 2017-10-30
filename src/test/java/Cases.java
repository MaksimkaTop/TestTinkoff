import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Cases extends Tinkoff {

    WebDriver driver = new FirefoxDriver();

String Find;



    @Test
    public void Check() {


        driver.get("https://www.tinkoff.ru");
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }

        //driver.findElement(By.xpath(".//*[@id='mainMenu']/li[3]/span/a/span")).isDisplayed();

        public boolean IsXPathPresent(String XPath)
        {

            try
            {
                driver.findElement(By.xpath(".//*[@id='mainMenu']/li[3]/span/a/span"));
                System.out.println("Selector: " + XPath + " found");
                return true;
            } catch (Exception e)

            {
                System.out.println(XPath + " Selector Not Present");
                return false;
            }

        }



        public void Same() {


            driver.findElement(By.xpath(".//*[@id='mainMenu']/li[3]/span/a/span")).click(); //переходим в платежи


            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

            driver.findElement(By.linkText("Коммунальные платежи")).isDisplayed();
            driver.findElement(By.xpath(".//div/div[2]/div/ul/li[2]/span[2]/a/span")).click();


            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        }



    public boolean IsMoscowPresent1(String XPath) {

        if (driver.findElement(By.xpath(".//title[@span='ui-link payment-page__title_inner'='Москве']")).isDisplayed()//(что то не так пошло)если есть москва
         ) {
            Find = driver.findElement(By.xpath(".//ul[@class='ui-menu ui-menu_icons _3Fsrs']/li/span/a/span/div[1]")).getText(); //забираем искомое

            driver.findElement(By.xpath(".//ul[@class='ui-menu ui-menu_icons _3Fsrs']/li/span/a/span/div[1]")).click();//переход на ЖКУ Москва

        } else {
            driver.findElement(By.xpath(".//span[@class='ui-link payment-page__title_inner']")).click();//идем список регионов

            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.findElement(By.linkText("г. Москва")).isDisplayed();
            driver.findElement(By.linkText("г. Москва")).click();//выбираем москву


            driver.findElement(By.xpath(".//ul[@class='ui-menu ui-menu_icons _3Fsrs']/li/span/a/span/div[1]")).isDisplayed();
            driver.findElement(By.xpath(".//ul[@class='ui-menu ui-menu_icons _3Fsrs']/li/span/a/span/div[1]")).click();//переход на ЖКУ Москва
            Find = driver.findElement(By.xpath(".//ul[@class='ui-menu ui-menu_icons _3Fsrs']/li/span/a/span/div[1]")).getText();//забираем искомое


        }
        return true;
    }
    public void SameT() {

        driver.findElement(By.linkText("Оплатить ЖКУ в Москве")).isDisplayed();
        driver.findElement(By.linkText("Оплатить ЖКУ в Москве")).click();


        driver.findElement(By.xpath("//input[@required]")).isDisplayed();
        driver.findElement(By.xpath("//input[@required]")).sendKeys("0");

        driver.findElement(By.cssSelector(".ui-form-field-error-message.ui-form-field-error-message_ui-form")).isDisplayed();
        driver.findElement(By.cssSelector(".ui-form-field-error-message.ui-form-field-error-message_ui-form"));


        driver.findElement(By.xpath(".//*[@id='mainMenu']/li[3]/span/a/span")).isDisplayed();
        driver.findElement(By.xpath(".//*[@id='mainMenu']/li[3]/span/a/span")).click();//переходим в платежи


        driver.findElement(By.xpath(".//*[@id='search-and-pay-container']/.../label/input")).sendKeys(Find);//ищем искомый
        driver.findElement(By.linkText(Find)).isDisplayed();//смени на первый!!!
        driver.findElement(By.linkText(Find)).click();//перешли в жк москва


//сравнитть страницы


        driver.findElement(By.xpath(".//*[@id='mainMenu']/li[3]/span/a/span")).isDisplayed();
        driver.findElement(By.xpath(".//*[@id='mainMenu']/li[3]/span/a/span")).click(); //переходим в платежи

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Коммунальные платежи")).isDisplayed();
        driver.findElement(By.xpath(".//div/div[2]/div/ul/li[2]/span[2]/a/span")).click();// коммунальные платежи


        driver.findElement(By.xpath(".//span[@class='ui-link payment-page__title_inner']")).click();

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.findElement(By.linkText("г. Санкт-Петербург")).isDisplayed();
        driver.findElement(By.linkText("г. Санкт-Петербург")).click();


        boolean present;
        try {
            driver.findElement(By.linkText(Find));
            present = false;
        } catch (NoSuchElementException e) {
            present = true;
        }


    }}


