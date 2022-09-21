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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {


    @Test
    void SuccessfulCardBooking() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        String planningDate = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        $("[placeholder=\"Дата встречи\"]").setValue(planningDate);
        $("[data-test-id=\"name\"] input").setValue("Иванов Иван");
        $("[data-test-id=\"phone\"] input").setValue("+79192356987");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//div[text()= 'Успешно!']").should(Condition.visible, Duration.ofSeconds(15));
        $x("//div[contains(text(), 'Встреча успешно забронирована')]").shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));

    }

    @Test
    void CityNotValid() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Нью-Йорк");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        String planningDate = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        $("[placeholder=\"Дата встречи\"]").setValue(planningDate);
        $("[data-test-id=\"name\"] input").setValue("Иванов Иван");
        $("[data-test-id=\"phone\"] input").setValue("+79192356987");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Доставка')]").hover();
    }

    @Test
    void InvalidFirstAndLastName() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        String planningDate = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        $("[placeholder=\"Дата встречи\"]").setValue(planningDate);
        $("[data-test-id=\"name\"] input").setValue("Ivanov Ivan");
        $("[data-test-id=\"phone\"] input").setValue("+79192356987");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Имя и Фамилия указаные неверно')]").hover();

    }

    @Test
    void InvalidFirstAndLastName2() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        String planningDate = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        $("[placeholder=\"Дата встречи\"]").setValue(planningDate);
        $("[data-test-id=\"name\"] input").setValue("Иванов,Иавн");
        $("[data-test-id=\"phone\"] input").setValue("+79192356987");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Имя и Фамилия указаные неверно')]").hover();

    }
    @Test
    void InvalidPhoneNumber() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        String planningDate = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        $("[placeholder=\"Дата встречи\"]").setValue(planningDate);
        $("[data-test-id=\"name\"] input").setValue("Иванов Иавн");
        $("[data-test-id=\"phone\"] input").setValue("89192356987");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Телефон указан неверно')]").hover();

    }

    @Test
    void InvalidPhoneNumber2() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        String planningDate = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        $("[placeholder=\"Дата встречи\"]").setValue(planningDate);
        $("[data-test-id=\"name\"] input").setValue("Иванов Иавн");
        $("[data-test-id=\"phone\"] input").setValue("+7919235698.");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Телефон указан неверно')]").hover();

    }
    @Test
    void CityInputField() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").hover();
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        String planningDate = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        $("[placeholder=\"Дата встречи\"]").setValue(planningDate);
        $("[data-test-id=\"name\"] input").setValue("Иванов Иван");
        $("[data-test-id=\"phone\"] input").setValue("+79192356987");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Поле обязательно для заполнения')]").hover();

    }

    @Test
    void NameInputField() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        String planningDate = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        $("[placeholder=\"Дата встречи\"]").setValue(planningDate);
        $("[data-test-id=\"name\"] input").hover();
        $("[data-test-id=\"phone\"] input").setValue("+79192356987");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Поле обязательно для заполнения')]").hover();

    }

    @Test
    void PhoneInputField() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        String planningDate = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        $("[placeholder=\"Дата встречи\"]").setValue(planningDate);
        $("[data-test-id=\"name\"] input").setValue("Иванов Иван");
        $("[data-test-id=\"phone\"] input").hover();
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__content").click();
        $x("//span[contains(text(), 'Поле обязательно для заполнения')]").hover();

    }

}
