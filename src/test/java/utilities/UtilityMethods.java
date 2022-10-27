package utilities;

import tests.base.TestBase;

public class UtilityMethods extends TestBase {

    //This method for cleaning cart, I assume quantity of every product is 1 pcs.
    public static void cleanCart() throws InterruptedException {
        while (true) {
            try {
                if (cartPage.deleteButton.isDisplayed()) {
                    cartPage.deleteButton.click();
                }
            } catch (Exception e) {
                logger.info("Cart has been cleaned successfully!");
                break;
            }
            Thread.sleep(2000);
        }
    }

}
