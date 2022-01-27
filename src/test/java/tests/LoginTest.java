package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test
    public void login(){
        loginPage
                .open()
                .login(email, password);

        $(By.id("createButton")).shouldBe(Condition.visible); // можно добавить duration для кастомного ожидания Duration.ofSeconds(60)
    }
}
