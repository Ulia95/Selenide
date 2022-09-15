import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    WebDriver driver;

    @BeforeEach
    void  setupTest(){
        Selenide.open("http://localhost:9999");
    }

    @Test
    void test(){
        //Configuration.holdBrowserOpen=true;
       // open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder=\"Дата встречи\"]").setValue("19.09.2022");
        $("[data-test-id=\"name\"] input").setValue("Иванов Иван");
        $("[data-test-id=\"phone\"] input").setValue("+79192356987");
        $x("//span[text()=\"Я соглашаюсь с условиями обработки и использования моих персональных данных\"]").click();
        $(".button__content").click();
        $x("//div[text()= 'Успешно!']").should(Condition.visible, Duration.ofSeconds(15));
        $x("//div[contains(text(), 'Встреча успешно забронирована')]").should(Condition.visible, Duration.ofSeconds(15));

    }
}
