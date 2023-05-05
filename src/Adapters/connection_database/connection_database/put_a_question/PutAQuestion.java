package Adapters.connection_database.connection_database.put_a_question;

import Adapters.connection_database.connection_database.DAO.QuestionDAO;
import domain.entities.QuestionForConnection;

public class PutAQuestion {
    public static void main(String[] args) throws Exception {

        QuestionForConnection question_one = new QuestionForConnection();
        question_one.setQuestion("Quantos dedos tem uma mão ?");
        question_one.setAnswer_a("5");
        question_one.setAnswer_b("6");
        question_one.setAnswer_c("12");
        question_one.setAnswer_d("55");
        question_one.setCorrect_answer("5");

        new QuestionDAO().register_question(question_one);
    }
}
