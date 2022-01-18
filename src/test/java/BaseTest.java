import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    String email , password;

    @BeforeMethod
    public void setUp(){
        //Configuration.headless = true;
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url")); //"https://app.qase.io";
        email = System.getenv().getOrDefault("QASE_MAIL", PropertyReader.getProperty("qase.email"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
        Configuration.browser = "chrome";
        //Configuration.clickViaJs = true; //(по дефолту не используется) операции взаимодействия, типа клика, ввода, через js (не найдется баг, если включена установка эта, т.к. клик тот же сработает с ломаной версткой(юзер так кликнуть не сможет))
        Configuration.savePageSource = false; // по ум. - тру. Если тру - в логах при падении сохраняется файлик с полной структурой html страницы
        Configuration.timeout = 10000;
        // Configuration.pollingInterval  прописываем, чтобы изменить куличество пуляний проверок на отображение элемента

        //настройки, которые различаются для разных браузеров
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("headless");
//        Configuration.browserCapabilities = chromeOptions;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        getWebDriver().quit();
    }

}
