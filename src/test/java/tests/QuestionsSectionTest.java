package tests;

import org.junit.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.MainPage;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class QuestionsSectionTest extends BaseTest {

    private final int questionIndex;

    public QuestionsSectionTest(int questionIndex) {
        this.questionIndex = questionIndex;
    }

    @Parameterized.Parameters(name = "FAQ-вопрос #{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}
        });
    }

    @Test
    public void testQuestionHasAnswer() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToFaqSection();

        mainPage.clickQuestion(questionIndex);
        String answerText = mainPage.getAnswerText(questionIndex);

        Assert.assertFalse("Ответ на вопрос №" + (questionIndex + 1) + " пустой", answerText.isEmpty());
    }
}
