package tests.unit.usecases;

import Adapters.mock.QuestionDAOMock;
import domain.entities.Question;
import domain.entities.eventsystem.EventManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.unit.entities.eventmanager.EventListenerMock;

public class PullQuestionsUseCaseShould {
    QuestionDAOMock daoMock;
    domain.usecase.PullQuestionsUseCase useCase;

    @BeforeEach
    public void SetupTests(){
        daoMock = new QuestionDAOMock();
        useCase = new domain.usecase.PullQuestionsUseCase(daoMock);
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
    public void Raise_An_Event_When_AnsweredList_Is_Full(){
        EventListenerMock listenerMock = new EventListenerMock();
        EventManager.SubscribeInEvent("THERE_IS_NO_MORE_QUESTIONS", listenerMock);

        useCase.AddQuestionToAnsweredList(daoMock.get_questionsDBMock().get(0));
        useCase.AddQuestionToAnsweredList(daoMock.get_questionsDBMock().get(1));

        Question questionReturn = useCase.GetNotAnsweredRandomQuestion();

        Assertions.assertTrue(listenerMock.hasBeenCalledFlag);
    }
}
