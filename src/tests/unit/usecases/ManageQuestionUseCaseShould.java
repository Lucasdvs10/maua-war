package tests.unit.usecases;

import Adapters.mock.QuestionDAOMock;
import domain.entities.Question;
import domain.usecase.PullQuestionsUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManageQuestionUseCaseShould {
    QuestionDAOMock daoMock;
    PullQuestionsUseCase useCase;

    @BeforeEach
    public void SetupTests(){
        daoMock = new QuestionDAOMock();
        useCase = new PullQuestionsUseCase(daoMock);
    }

    @Test
    public void Add_Question_To_List(){
        Question question = new Question("Oi", 'a', 1);

        useCase.AddQuestionToAnsweredList(question);

        int tamanhoLista = useCase.get_answeredQuestionsList().size();

        Assertions.assertEquals(1, tamanhoLista);
        Assertions.assertTrue(useCase.get_answeredQuestionsList().contains(question));
    }

    @Test
    public void Return_Question_With_Id_2(){
        useCase.AddQuestionToAnsweredList(daoMock.get_questionsDBMock().get(0));

        Question questionReturn = useCase.GetNotAnsweredRandomQuestion();

        Assertions.assertEquals(2, questionReturn.get_questionId());
    }

    @Test
    public void Set_List_Size_To_0(){
        useCase.AddQuestionToAnsweredList(daoMock.get_questionsDBMock().get(0));
        useCase.AddQuestionToAnsweredList(daoMock.get_questionsDBMock().get(1));

        Question questionReturn = useCase.GetNotAnsweredRandomQuestion();

        Assertions.assertEquals(0, useCase.get_answeredQuestionsList().size());
    }
}
