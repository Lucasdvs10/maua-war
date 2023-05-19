package Adapters.connection_database.DAO;

import Adapters.connection_database.MauawarDatabaseConnection;
import domain.entities.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;


public class QuestionDAOMYSQL implements Adapters.IQuestionDAO {
    
    @Override
    public void RegisterQuestion(Question question){

        String sql_string = "INSERT INTO questions (QUESTION, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER) VALUES (?, ?, ?, ?, ?, ?)";

        HashMap<Character, String> alternativesHashMap = question.get_alternativesHashMap();

        PreparedStatement ps = null;

        try {
            ps = MauawarDatabaseConnection.get_connection_database_mauawar().prepareStatement(sql_string);
            ps.setString(1, question.get_statement());
            ps.setString(2, alternativesHashMap.get('A'));
            ps.setString(3, alternativesHashMap.get('B'));
            ps.setString(4, alternativesHashMap.get('C'));
            ps.setString(5, alternativesHashMap.get('D'));
            ps.setString(6, question.get_correctAlternative().toString());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Question GetQuestionById(int questionId) {
        
        String sql_string = "SELECT * FROM questions WHERE id=" + questionId;

        Statement MauaWarStatement;
        try {
            MauaWarStatement = MauawarDatabaseConnection.get_connection_database_mauawar().createStatement();
            MauaWarStatement.executeQuery(sql_string);
            ResultSet mauaWarResultSet = MauaWarStatement.getResultSet();

            Question questionToReturn = new Question(mauaWarResultSet.getString("question"), mauaWarResultSet.getString("correct_answer").charAt(0), mauaWarResultSet.getInt("id"));

            return questionToReturn;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }      

    }

    @Override
    public Question GetRandomQuestion() {

        //Pegando o número do ultimo id

        //comando SQL para selecionar o último ID:
        String sql_string = "SELECT id FROM questions BY id DESC LIMIT 1";
        int id;

        Statement MauaWarStatement;
        try {
            MauaWarStatement = MauawarDatabaseConnection.get_connection_database_mauawar().createStatement();
            MauaWarStatement.executeQuery(sql_string);
            ResultSet mauaWarResultSet = MauaWarStatement.getResultSet();

            id = mauaWarResultSet.getInt("id");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        //gerando um número aleatório:
        int num_for_random = id + 1;
        Random random = new Random();
        int randomId = random.nextInt(num_for_random);

        return GetQuestionById(randomId);


    }

    @Override
    public int GetDataBaseSize() { //Todo: Implementar este método
        return 0;
    }
}
