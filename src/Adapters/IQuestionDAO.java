package Adapters;

import domain.entities.Question;

public interface IQuestionDAO {
    void RegisterQuestion(Question question);
    Question GetQuestion(String questionCode);
}
