import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void testBase() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
    }

    @Test
    void fillFormTest() {
        open("automation-practice-form");
        $("#firstName").setValue("Bony");
        $("#lastName").setValue("Skye");
        $("#userEmail").setValue("Bony@test.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("9659112131");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$("option[value='1991']").click();
        $(".react-datepicker__month-select").$("option[value='9']").click();
        $(".react-datepicker__day--007:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("One-Punch Man.jpg");
        $("#currentAddress").setValue("Street 1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();


        $("#submit").click();

        $(".table-responsive").shouldHave(
             text("Bony Skye"),             // Проверка имени
             text("Bony@test.com"),         // Проверка email
             text("Male"),                  // Проверка пола
             text("9659112131"),            // Проверка телефона
             text("07 October,1991"),       // Проверка даты рождения
             text("Maths"),                 // Проверка предметов
             text("Sports"),                // Проверка хобби
             text("One-Punch Man.jpg"),     // Проверка загруженной картинки
             text("Street 1"),              // Проверка адреса
             text("NCR Delhi")              // Проверка штата и города
        );
    }

}