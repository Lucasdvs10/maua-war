package domain.usecase;

import Adapters.DependencyInjector;
import Adapters.IQuestionDAO;
import domain.entities.Question;
import domain.entities.eventsystem.EventManager;

import java.util.ArrayList;

public class PullQuestionsUseCase {
    private IQuestionDAO _questionDao;
    private ArrayList<Question> _answeredQuestionsList; //Poderia ser um HashSet

    public Question GetRandomQuestion(){
        return _questionDao.GetRandomQuestion();
    }

    public Question GetNotAnsweredRandomQuestion(){
        boolean allQuestionsHasBeenAnswered = _answeredQuestionsList.size() == _questionDao.GetDataBaseSize();

        if(allQuestionsHasBeenAnswered){
            EventManager.RaiseAnEvent("THERE_IS_NO_MORE_QUESTIONS");
            return null;
        }

        Question question = this.GetRandomQuestion();

        while(_answeredQuestionsList.contains(question) || question == null){
            question = GetRandomQuestion();
        }

        return question;
    }

    public void AddQuestionToAnsweredList(Question question){
        _answeredQuestionsList.add(question);
    }


    public PullQuestionsUseCase(IQuestionDAO questionDAO) {
        EventManager.CreateEventIfItDoesNotExists("THERE_IS_NO_MORE_QUESTIONS");
        this._questionDao = questionDAO;
        _answeredQuestionsList = new ArrayList<>();
    }

    public ArrayList<Question> get_answeredQuestionsList() {
        return _answeredQuestionsList;
    }
}
