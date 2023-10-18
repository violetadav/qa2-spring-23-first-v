package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FinalPage {

    private final By SUCCESSFUL_REG_MSG = By.xpath(".//div[@class = 'finalTxt']");

    private BaseFunc baseFunc;

    public FinalPage (BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void successfulMsgCheck (String MSG) {
        baseFunc.findElement(SUCCESSFUL_REG_MSG);
        WebElement msgInfo = baseFunc.findElement(SUCCESSFUL_REG_MSG);
        Assertions.assertEquals(MSG, msgInfo.getText(), "Reservation Is Not Successful!");
    }

    public String successfulMessageAppears() {
        return baseFunc.findElement(SUCCESSFUL_REG_MSG).getText();
    }
}
