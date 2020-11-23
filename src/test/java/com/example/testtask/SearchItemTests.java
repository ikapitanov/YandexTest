package com.example.testtask;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTests extends TestBase{

    @Test
    public void testItem() throws InterruptedException {

        goToMarket();
        switchToNextTab();
        selectComputersDepartment();

        filterItem(new item()
                .setItemType("planshety")
                .setPriceFrom("20000")
                .setPriceTo("35000")
                .setBrand("Apple"));

        Thread.sleep(2000);
        //    WebElement item = wd.findElement(By.xpath("//*[@data-autotest-id='product-snippet'][2]"));
    //    String itemName = item.findElement(By.xpath(".//h3")).getText();
        String itemName = getItemNameFromListByOrder(2);

        searchItemFromSearchBox(itemName);
        String foundItemName = getItemNameFromListByOrder(1);
        Assert.assertEquals(foundItemName, itemName);

        /*
Перейти на Яндекс Маркет
4. Выбрать раздел Компьютеры
5. Выбрать раздел Планшеты
6. Зайти в расширенный поиск
7. Задать параметр поиска от 20000 до 35000 рублей.
8. Выбрать производителя “Apple”
9. Применить условия поиска
10. Запомнить второй элемент в результатах поиска
11. В поисковую строку ввести запомненное значение.
12. Найти и проверить, что наименование товара соответствует запомненному
значению.
        */
    }

    public void searchItemFromSearchBox(String itemName) {
        type(By.cssSelector("#header-search"), itemName);
        click(By.cssSelector("[type=submit]"));
    }

    public String getItemNameFromListByOrder(int number) {
        return wd.findElement(By.xpath("//*[@data-autotest-id='product-snippet']["+number+"]//h3")).getText();
    }

}
