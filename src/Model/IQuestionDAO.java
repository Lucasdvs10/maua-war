package Model;


import domain.entities.Question;

public interface IQuestionDAO {
    void RegisterQuestion(Question question);
    Question GetQuestionById(int questionId);

    Question GetRandomQuestion();

    int GetDataBaseSize();
}
