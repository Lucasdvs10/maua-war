package Adapters;

import Adapters.connection_database.DAO.QuestionDAOMYSQL;
import Adapters.mock.QuestionDAOMock;

public class DependencyInjector {
    public static boolean TestModeOn = true;

    private static IQuestionDAO questionDaoInstance;

    public static IQuestionDAO GetQuestionDAO(){ //Improvisando um framework de Injeção de dependencia
            if(TestModeOn && questionDaoInstance == null)
                questionDaoInstance = new QuestionDAOMock();

            if(!TestModeOn && questionDaoInstance == null)
                questionDaoInstance = new QuestionDAOMYSQL();

            return questionDaoInstance;
    }
}
