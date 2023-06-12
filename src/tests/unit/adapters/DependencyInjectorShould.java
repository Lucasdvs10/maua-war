package tests.unit.adapters;

import Model.DependencyInjector;
import Model.IQuestionDAO;
import Model.mock.QuestionDAOMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DependencyInjectorShould {

    @Test
    public void Return_Same_DAO_Mock_Instance(){
        DependencyInjector.TestModeOn = true;

        IQuestionDAO questionDAO1 = DependencyInjector.GetQuestionDAO();
        IQuestionDAO questionDAO2 = DependencyInjector.GetQuestionDAO();

        Assertions.assertInstanceOf(QuestionDAOMock.class, questionDAO1);
        Assertions.assertInstanceOf(QuestionDAOMock.class, questionDAO2);

        Assertions.assertSame(questionDAO1, questionDAO2);
    }
}
