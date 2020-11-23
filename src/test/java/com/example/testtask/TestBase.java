package com.example.testtask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        openSite("https://yandex.ru/");
    }

    @AfterClass
    public void tearDown(){
        wd.quit();
    }

    public void filterItem(item item) {
        click(By.cssSelector("[href='/catalog/"+ item.getItemType() +"/54545/list?hid=6427100&track=fr_ctlg']"));

        type(By.cssSelector("textfield9574089643"), item.getPriceFrom());
        type(By.cssSelector("textfield8089830197"), item.getPriceTo());
        //    click(By.cssSelector("Apple"));
        click(By.xpath("//span[text()='"+ item.getBrand() +"']"));
    }

    public void selectComputersDepartment() {
        click(By.cssSelector("[href^='//pokupki.market.yandex.ru/catalog/kompiuternaia-tekhnika']"));
    }

    public void goToMarket() {
        click(By.cssSelector("[data-id='market']"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        if (text != null){
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void openSite(String url) {
        wd.navigate().to(url);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void switchToNextTab() {
        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(1));
        }
    }
}
