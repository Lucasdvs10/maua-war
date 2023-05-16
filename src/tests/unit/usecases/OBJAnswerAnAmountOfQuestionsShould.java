package tests.unit.usecases;

import domain.entities.Player;
import domain.entities.eventsystem.EventManager;
import domain.entities.eventsystem.IPlayerEventListener;
import domain.usecase.objectivesystem.OBJAnswerAnAmountOfQuestions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.unit.entities.eventmanager.PlayerEventListenerMock;

import java.awt.*;

public class OBJAnswerAnAmountOfQuestionsShould {
    Player player1;
    Player player2;
    OBJAnswerAnAmountOfQuestions objAnswerQuestions;

    @BeforeEach
    public void Setup_Tests(){
        player1 = new Player(1, Color.BLUE);
        player2 = new Player(2, Color.RED);

        Player[] playersArray = {player1, player2};

        objAnswerQuestions = new OBJAnswerAnAmountOfQuestions(2, playersArray);
    }

    @Test
    public void Add_One_Point_To_Player1(){
        objAnswerQuestions.PlayerAnsweredQuestionCorrectly(player1);

        Assertions.assertEquals(1, objAnswerQuestions.get_playerPointsHashMap().get(player1));
        Assertions.assertEquals(0, objAnswerQuestions.get_playerPointsHashMap().get(player2));
    }
    @Test
    public void Raise_PL_Completed_Obj_Event(){
        PlayerEventListenerMock listenerMock = new PlayerEventListenerMock();
        EventManager.SubscribeInPlayerEvent("PL_COMPLETED_OBJ", listenerMock);

        objAnswerQuestions.PlayerAnsweredQuestionCorrectly(player1);
        objAnswerQuestions.PlayerAnsweredQuestionCorrectly(player1);

        Assertions.assertTrue(listenerMock.hasBeenCalledFlag);
    }
}
