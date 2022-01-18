import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest{

    @Test
    public void login(){
        open("/login");
        $("#inputEmail").sendKeys("icemanrus21@gmail.com");
        $(By.xpath("//*[@id='inputPassword']"))
                .setValue("TestQaseIo21")
                .submit();
        $(By.id("createButton")).shouldBe(Condition.visible); // можно добавить duration для кастомного ожидания Duration.ofSeconds(60)
    }
}
