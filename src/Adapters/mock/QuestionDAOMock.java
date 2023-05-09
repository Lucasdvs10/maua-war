package Adapters.mock;

import domain.entities.Question;

import java.util.ArrayList;

public class QuestionDAOMock implements Adapters.IQuestionDAO{
    private ArrayList<Question> _questionsDBMock;

    public QuestionDAOMock() {
        this._questionsDBMock = new ArrayList<>();
        this._questionsDBMock.add(new Question("Eh Certo isso?", 'A', 1));
        this._questionsDBMock.add(new Question("E isso?", 'B', 2));
    }

    @Override
    public void RegisterQuestion(Question question) {
        this._questionsDBMock.add(question);
    }

    @Override
    public Question GetQuestionById(int questionId) {
        for (Question question : _questionsDBMock) {
            int currentQuestionId = question.get_questionId();

            if (currentQuestionId == questionId)
                return question;
        }
        return null;
    }

    @Override
    public Question GetRandomQuestion() {
        return null;
    }

    public ArrayList<Question> get_questionsDBMock() {
        return _questionsDBMock;
    }
}
