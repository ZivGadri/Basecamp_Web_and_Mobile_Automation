package Extensions.Mobile;              //Actions we commonly do on UI objects will be wrapped here with our methods in order to simplify
                                        //the process. Inherits from CommonOps.

import org.openqa.selenium.WebElement;

public class UiActions {

    public static void click(WebElement elem) {
        elem.click();
    }

    public static void insertKeysAndClick(WebElement elem, String info, WebElement elem2) {
        elem.sendKeys(info);
        elem2.click();
    }
}
