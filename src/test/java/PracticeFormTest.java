import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void testBase() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("automation-practice-form");
        $("#firstName").setValue("Bony");
        $("#lastName").setValue("Skye");
        $("#userEmail").setValue("Bony@test.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9659112131");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $$(".react-datepicker__year-select option").findBy(text("1991")).click();
        $(".react-datepicker__month-select").click();
        $$(".react-datepicker__month-select option").findBy(text("October")).click();
        $(".react-datepicker__day--007:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("One-Punch Man.jpg");
        $("#currentAddress").setValue("Street 1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();


        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Bony Skye"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("Bony@test.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9659112131"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("07 October,1991"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("One-Punch Man.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Street 1"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }

}