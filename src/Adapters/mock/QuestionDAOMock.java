package Adapters.mock;

import domain.entities.Question;

import java.util.ArrayList;
import java.util.Random;

public class QuestionDAOMock implements Adapters.IQuestionDAO{
    private ArrayList<Question> _questionsDBMock;

    public QuestionDAOMock() {
        this._questionsDBMock = new ArrayList<>();
        this._questionsDBMock.add(new Question("Quantos dedos uma mao tem normalmente?", 'A', 1));
        _questionsDBMock.get(0).AddAlternativeToHashMap('A', "5");
        _questionsDBMock.get(0).AddAlternativeToHashMap('B', "1");
        _questionsDBMock.get(0).AddAlternativeToHashMap('C', "3");
        _questionsDBMock.get(0).AddAlternativeToHashMap('D', "8");

        this._questionsDBMock.add(new Question("2+2?", 'B', 2));
        _questionsDBMock.get(1).AddAlternativeToHashMap('A', "8");
        _questionsDBMock.get(1).AddAlternativeToHashMap('B', "4");
        _questionsDBMock.get(1).AddAlternativeToHashMap('C', "90");
        _questionsDBMock.get(1).AddAlternativeToHashMap('D', "75");


        this._questionsDBMock.add(new Question("Em qual lingua esse projeto foi feito?", 'D', 3));
        _questionsDBMock.get(2).AddAlternativeToHashMap('A', "C++");
        _questionsDBMock.get(2).AddAlternativeToHashMap('B', "Cobol");
        _questionsDBMock.get(2).AddAlternativeToHashMap('C', "Jython (Sim, essa lingua existe mesmo)");
        _questionsDBMock.get(2).AddAlternativeToHashMap('D', "Java");


        this._questionsDBMock.add(new Question("Quem é o pai do Luke?", 'B', 4));
        _questionsDBMock.get(3).AddAlternativeToHashMap('A', "Mestre Yoda");
        _questionsDBMock.get(3).AddAlternativeToHashMap('B', "Darth Vaider");
        _questionsDBMock.get(3).AddAlternativeToHashMap('C', "Gandalf");
        _questionsDBMock.get(3).AddAlternativeToHashMap('D', "Joel MIller");

        this._questionsDBMock.add(new Question("Em que país estamos?", 'C', 5));
        _questionsDBMock.get(4).AddAlternativeToHashMap('A', "Japao");
        _questionsDBMock.get(4).AddAlternativeToHashMap('B', "Butao");
        _questionsDBMock.get(4).AddAlternativeToHashMap('C', "Brasil");
        _questionsDBMock.get(4).AddAlternativeToHashMap('D', "Gana");
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
        Random random = new Random();

        int randomIndex = random.nextInt(0, this._questionsDBMock.size());

        return GetQuestionById(randomIndex);
    }

    @Override
    public int GetDataBaseSize() {
        return _questionsDBMock.size();
    }

    public ArrayList<Question> get_questionsDBMock() {
        return _questionsDBMock;
    }
}
