package tests.unit.adapters;

import Adapters.mock.QuestionDAOMock;
import domain.entities.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionDAOMockShould {
    @Test
    public void Add_One_Question_To_Mock_Data_Base(){
        QuestionDAOMock questionDAOMock = new QuestionDAOMock();

        Question mockQuestion = new Question("Eh Certo isso?", 'B');
        mockQuestion.AddAlternativeToHashMap('A', "Sim");
        mockQuestion.AddAlternativeToHashMap('B', "Nao");

        questionDAOMock.RegisterQuestion(mockQuestion);

        Assertions.assertEquals(1, questionDAOMock.get_questionsDBMock().size());
        Assertions.assertSame(mockQuestion, questionDAOMock.get_questionsDBMock().get(0));
    }
}
