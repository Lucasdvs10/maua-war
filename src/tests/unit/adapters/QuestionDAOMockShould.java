package tests.unit.adapters;

import Model.mock.QuestionDAOMock;
import domain.entities.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionDAOMockShould {
    @Test
    public void Add_One_Question_To_Mock_Data_Base(){
        QuestionDAOMock questionDAOMock = new QuestionDAOMock();

        Question mockQuestion = new Question("Eeeeeita", 'B', 3);
        mockQuestion.AddAlternativeToHashMap('A', "Sim");
        mockQuestion.AddAlternativeToHashMap('B', "Nao");

        int sizeBefore = questionDAOMock.get_questionsDBMock().size();

        questionDAOMock.RegisterQuestion(mockQuestion);

        Assertions.assertEquals(sizeBefore + 1, questionDAOMock.get_questionsDBMock().size());
        Assertions.assertSame(mockQuestion, questionDAOMock.get_questionsDBMock().get(sizeBefore));
    }

    @Test
    public void Return_Question_When_Id_Exists(){
        QuestionDAOMock questionDAOMock = new QuestionDAOMock();

        int anIdThatExists = questionDAOMock.get_questionsDBMock().get(0).get_questionId();

        Question questionReturnedByDAO = questionDAOMock.GetQuestionById(anIdThatExists);

        Assertions.assertNotNull(questionReturnedByDAO);
        Assertions.assertEquals(anIdThatExists, questionReturnedByDAO.get_questionId());
    }

    @Test
    public void Return_Null_When_Id_Doesnt_Exist(){
        QuestionDAOMock questionDAOMock = new QuestionDAOMock();

        int anIdThatDoesntExists = 8001;

        Question questionReturnedByDAO = questionDAOMock.GetQuestionById(anIdThatDoesntExists);

        Assertions.assertNull(questionReturnedByDAO);
    }
}
