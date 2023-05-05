package Adapters.connection_database.connection_database.DAO;

import Adapters.connection_database.connection_database.MauawarDatabaseConnection;
import domain.entities.QuestionForConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class QuestionDAO {
    
    public void register_question(QuestionForConnection question){

        String sql_string = "INSERT INTO questions (QUESTION, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = MauawarDatabaseConnection.get_connection_database_mauawar().prepareStatement(sql_string);
            ps.setString(1, question.getQuestion());
            ps.setString(2, question.getAnswer_a());
            ps.setString(3, question.getAnswer_b());
            ps.setString(4, question.getAnswer_c());
            ps.setString(5, question.getAnswer_d());
            ps.setString(6, question.getCorrect_answer());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
