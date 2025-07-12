package tests;

import org.junit.*;

import pageobjects.MainPage;



public class QuestionsSectionTest extends BaseTest{

    @Test
    public void testAllAccordionQuestionsHaveAnswers() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToFaqSection();

        int questionCount = mainPage.getQuestionsCount();

        for (int i = 0; i < questionCount; i++) {
            mainPage.clickQuestion(i);
            String answerText = mainPage.getAnswerText(i);
            Assert.assertFalse("Ответ на вопрос №" + i + " пустой", answerText.isEmpty());
        }
    }

}
