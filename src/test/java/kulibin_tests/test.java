package kulibin_tests;

public class test extends BaseTest{
    /* @Test
    public void checkThatToolsHaveSimilarPrise_1() {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//a[text()='Електроінструмент']"));
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("(//a[contains(text(),'Болгарки')])[1]")).click();
        List<WebElement> products = driver.findElements(By.xpath("//*[@class='old-price']/../../../../..//*[@class='holder']"));
        System.out.println(products.size());

        // Випадково вибираємо 3 товари
        Random random = new Random();
        int count = Math.min(3, products.size());
        for (int i = 0; i <= count; i++) {
            WebElement product = products.get(random.nextInt(products.size()));
            String idProduct = product.getAttribute("id");
            System.out.println(idProduct);

            String oldPriceMainMenu = driver.findElement(By.xpath("//*[@class='old-price']/../../../../..//*[@class='holder']//span[@class='old-price']")).getText();
            System.out.println(oldPriceMainMenu);
            String newPriceMainMenu = driver.findElement(By.xpath("//*[@class='old-price']/../../../../..//*[@class='holder']//span[@class='price']")).getText();
            System.out.println(newPriceMainMenu);

            new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='catalog catalog-full js-catalog']")));
            product.click();
            String nameEnterTool = driver.findElement(By.xpath("//h1")).getText();
            System.out.println(nameEnterTool);

            String oldPriceInCart = driver.findElement(By.xpath("//span[@class='item_old_price old-price']")).getText();
            System.out.println(oldPriceInCart);
            String newPriceInCart = driver.findElement(By.xpath("//div[@class='price-row']//span[@class='price']")).getText();
            System.out.println(newPriceInCart);

            Assert.assertEquals(oldPriceMainMenu, oldPriceInCart);
            Assert.assertEquals(newPriceMainMenu, newPriceInCart);


            // Повертаємося до списку товарів
            driver.navigate().back();

            // Видаляємо оброблений товар зі списку
            products.remove(product);

        }
    }*/
}
