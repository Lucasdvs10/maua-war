package Adapters.mock;

import domain.entities.Question;

import java.util.ArrayList;

public class QuestionDAOMock implements Adapters.IQuestionDAO{
    private ArrayList<Question> _questionsDBMock;

    public QuestionDAOMock() {
        this._questionsDBMock = new ArrayList<>();
    }

    @Override
    public void RegisterQuestion(Question question) {
        this._questionsDBMock.add(question);
    }

    @Override
    public Question GetQuestion(String questionCode) {
        return null;
    }

    public ArrayList<Question> get_questionsDBMock() {
        return _questionsDBMock;
    }
}
