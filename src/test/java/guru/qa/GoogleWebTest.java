package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/** testcase description for parameterized test *
 *0 - unique test case id
 *
 * 0.1 parameterized test parameters
    ['Selenide', 'selenide.org']
    ['Junit5', 'junit.org']
     ['Gradle', 'gradle.org']
    ['IntelliJ IDEA', 'jetbrains.com']
 *
 *1  set @DisplayName - Check that test_data[1] is in test results by query test_data[0]
 *
 * 2 set @Tags -  priority and severity by (Minor, Major, Critical, Blocker, Trivial) and add other tags
 *
 * 3 set @BeforeEach preconditions by  it is a state of the system before the test is executed (e.g. user is logged in, user is not logged in, etc.)
 *   for several test cases, the same preconditions can be used
 * - open browser
 * - open site name
 *
 * 4 set step sequence
 * - in the search field, enter the text test_data[0]
 * - press Enter
 *
 * 5 expected result
 * -search results should contain the text test_data[1]
 *
 * 6 set @AfterEach - postconditions by  it is a state of the system after the test is executed (e.g. user is logged in, user is not logged in, etc.)
 *
 *
 * Testcase and Bug report - are scenarios. They are used to describe the behavior of the system.
 * Unlike the Testcase, Bugreport contains the both Expected and Actual results.
 *
 * parameterized test - is a test that is executed several times with different parameters.
 * csv file - is a file that contains data in the form of a table.Stands for Comma Separated Values.
 * @CsvSource - is a parameterized test that gets data from a csv file.
 * csv representation for
 *   ['Selenide', 'selenide.org']
    ['Junit5', 'junit.org']
     ['Gradle', 'gradle.org']
    ['IntelliJ IDEA', 'jetbrains.com']
    * will be like this
    * Selenide,selenide.org
    * Junit5,junit.org
    * Gradle,gradle.org
    * IntelliJ IDEA,jetbrains.com

  */

/** testcase describtion for Locales test
 * 0 - unique test case id
 *
 *
 */

/** testcase for two locales
 * 0 - unique test case id
 * 0.1 parameterized test parameters
    ['ru', List{С чего начать? Док ЧАВО Блог Javadoc Пользователи Отзывы }]
    ['en', List{Quick start Docs FAQ Blog Javadoc Users Quotes }]
 * 1  set @DisplayName -Check aviability of buttons from list test_data[1] in locale test_data[0]
 * 2 set @Tags -  priority and severity by (Minor, Major, Critical, Blocker, Trivial) and add other tags
 * 3 set @BeforeEach preconditions
 * - open browser
 * - open site name https://selenide.org/
* 4 set step sequence
 * -select locale test_data[0]
 *
 *5 expected result
 * -buttons from list test_data[1] should be visible
 */
public class GoogleWebTest {
    @BeforeEach
    void setUp() {
        Configuration.headless = true;
        open("https://google.com/");
        //run in headless mode

    }

    /** data providers description
     * @data_providers  - @CsvFileSource, @CsvSource, @ValueSource, @EnumSource, @MethodSource, @ArgumentsSource
     * @MethodSource - most flexible data provider
     * @CsvFileSource (resources = " / test_data.csv ", numLinesToSkip = 1, delimiter = ' | ')
     * works with strings, booleans and primitives.
     * @delimiter - is a character that separates the values in a csv file. if you need to specify ',' as a part of the value, you need change delimiter to '|'
     * @numLinesToSkip - is a number of lines to skip in the csv file. For example, if you have a header in the csv file, you can skip it by setting numLinesToSkip = 1
     *(resources = "/test_data.csv", numLinesToSkip = 1,)
     * @CsvSource ({"Selenide,selenide.org", "Junit5,junit.org", "Gradle,gradle.org", "IntelliJ IDEA,jetbrains.com"}) uses array. Each element of the array is a line from the csv file.
     * @ValueSource strings and primitives, but only one argument
     **/

    @CsvSource(value = {
            "Selenide|selenide.org",
            "Junit|junit.org",
            "Gradle|gradle.org",
            "IntelliJ IDEA|jetbrains.com"
    },
            delimiter = '|')
    @ParameterizedTest(name = "{index} searchQuery={0} contains expectedText={1}")
    @Tags({@Tag("web"), @Tag("regression"), @Tag("BLOCKER")})
    void googleSearchTest(String searchQuery, String expectedText) {

        $("input").setValue(searchQuery).pressEnter();
        $("html").shouldHave(text(expectedText));
    }

     /*   @ValueSource(strings = {
            "Selenide",
            "Junit",
            "Gradle",
            "IntelliJ IDEA"
    })*/

    @DisplayName("googlePhotoPopupTest")
    @Test
    @Tags({@Tag("web"), @Tag("regression"), @Tag("BLOCKER")})
    void googlePhotoPopupTest() {
        //locator Selenide class="Gdd5U"
        $(".Gdd5U").click();
        //popup should be visible
        $(".ea0Lbe").shouldBe(visible);
    }

   /* @DisplayName("Check if JUnit is in google search results")
    @Test
    @Tags({@Tag("web"), @Tag("regression"), @Tag("BLOCKER")})
    void googleJUnitTest (){
        $("input").setValue("JUnit").pressEnter();
        $("html").shouldHave(text("JUnit.org"));
    }*/


}
