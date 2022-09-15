import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    @Test
    void test() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder=\"Дата встречи\"]").setValue("19.09.2022");
        $("[data-test-id=\"name\"] input").setValue("Иванов Иван");
        $("[data-test-id=\"phone\"] input").setValue("+79192356987");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//div[text()= 'Успешно!']").should(Condition.visible, Duration.ofSeconds(15));
        $x("//div[contains(text(), 'Встреча успешно забронирована')]").should(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    void test2() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Нью-Йорк");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder=\"Дата встречи\"]").setValue("25.09.2022");
        $("[data-test-id=\"name\"] input").setValue("Иванов Иван");
        $("[data-test-id=\"phone\"] input").setValue("+79192356987");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Доставка')]").hover();
    }

    @Test
    void test3() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder=\"Дата встречи\"]").setValue("19.09.2022");
        $("[data-test-id=\"name\"] input").setValue("Ivanov Ivan");
        $("[data-test-id=\"phone\"] input").setValue("+79192356987");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Имя и Фамилия указаные неверно')]").hover();

    }

    @Test
    void test4() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder=\"Дата встречи\"]").setValue("19.09.2022");
        $("[data-test-id=\"name\"] input").setValue("Иванов,Иавн");
        $("[data-test-id=\"phone\"] input").setValue("+79192356987");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Имя и Фамилия указаные неверно')]").hover();

    }
    @Test
    void test5() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder=\"Дата встречи\"]").setValue("19.09.2022");
        $("[data-test-id=\"name\"] input").setValue("Иванов Иавн");
        $("[data-test-id=\"phone\"] input").setValue("89192356987");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Телефон указан неверно')]").hover();

    }

    @Test
    void test6() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder=\"Дата встречи\"]").setValue("19.09.2022");
        $("[data-test-id=\"name\"] input").setValue("Иванов Иавн");
        $("[data-test-id=\"phone\"] input").setValue("+7919235698.");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Телефон указан неверно')]").hover();

    }
    @Test
    void test7() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").hover();
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder=\"Дата встречи\"]").setValue("25.09.2022");
        $("[data-test-id=\"name\"] input").setValue("Иванов Иван");
        $("[data-test-id=\"phone\"] input").setValue("+79192356987");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Поле обязательно для заполнения')]").hover();

    }

    @Test
    void test8() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder=\"Дата встречи\"]").setValue("25.09.2022");
        $("[data-test-id=\"name\"] input").hover();
        $("[data-test-id=\"phone\"] input").setValue("+79192356987");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Поле обязательно для заполнения')]").hover();

    }

    @Test
    void test9() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder=\"Дата встречи\"]").setValue("25.09.2022");
        $("[data-test-id=\"name\"] input").setValue("Иванов Иван");
        $("[data-test-id=\"phone\"] input").hover();
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Поле обязательно для заполнения')]").hover();

    }

}
