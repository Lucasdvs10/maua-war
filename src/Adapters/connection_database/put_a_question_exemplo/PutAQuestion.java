package Adapters.connection_database.put_a_question_exemplo;

import Adapters.connection_database.DAO.QuestionDAOMYSQL;
import domain.entities.Question;

public class PutAQuestion {
    public static void main(String[] args) throws Exception {

        Question questionOne = new Question("Quantos dedos tem uma mao?", 'C');

        questionOne.AddAlternativeToHashMap('A', "9");
        questionOne.AddAlternativeToHashMap('B', "122");
        questionOne.AddAlternativeToHashMap('C', "5");
        questionOne.AddAlternativeToHashMap('D', "90");

        new QuestionDAOMYSQL().RegisterQuestion(questionOne);
    }
}
