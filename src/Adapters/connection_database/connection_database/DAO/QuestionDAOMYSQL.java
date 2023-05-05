package Adapters.connection_database.connection_database.DAO;

import Adapters.connection_database.connection_database.MauawarDatabaseConnection;
import domain.entities.Question;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;


public class QuestionDAOMYSQL {
    
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
}
