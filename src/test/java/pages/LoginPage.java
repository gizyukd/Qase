package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage{

    public static final By LOGIN_BUTTON = By.xpath("//*[@id='inputPassword']");
    public static final String EMAIL_INPUT = "#inputEmail";
    public static final By PASSWORD_INPUT = By.xpath("//*[@id='inputPassword']");

    public LoginPage open(){
        Selenide.open("/login");
        return this;
    }

    public ProjectsPage login(String email, String password){
        $(EMAIL_INPUT).sendKeys(email);
        $(PASSWORD_INPUT)
                .setValue(password)
                .submit();
        return new ProjectsPage();
    }

    @Override
    public boolean isPageOpen() {
        //log.debug("start checking if the Login page is opened");
        return isExist(LOGIN_BUTTON);
    }
}
