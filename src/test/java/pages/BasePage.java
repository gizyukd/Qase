package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    public abstract boolean isPageOpen();

    protected boolean isExist(By locator){
        try{
            return $(locator).isDisplayed();
        }
        catch (NoSuchElementException ex){
            //log.error("ERROR in isExist method" + ex.getMessage());
            return false;
        }
    }
}
