package tests.unit.usecases;

import domain.entities.Player;
import domain.entities.eventsystem.EventManager;
import domain.usecase.objectivesystem.OBJDominateAnAmountOfBlocks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.unit.entities.eventmanager.PlayerEventListenerMock;

import java.awt.*;

public class OBJDominateAnAmountOfBlocksShould {
    PlayerEventListenerMock listenerMock;
    Player[] playersArrayMock;
    OBJDominateAnAmountOfBlocks objDominateAnAmountOfBlocks;

    @BeforeEach
    public void SetupTests(){
        listenerMock = new PlayerEventListenerMock();
        playersArrayMock = new Player[]{
                new Player(1, Color.BLUE),
                new Player(2, Color.RED)
        };

        objDominateAnAmountOfBlocks = new OBJDominateAnAmountOfBlocks(2, playersArrayMock);
    }

    @Test
    public void Add_One_Point_Only_To_Player_1(){
        objDominateAnAmountOfBlocks.OnPlayerEventRaised(playersArrayMock[0]);

        Assertions.assertEquals(1, objDominateAnAmountOfBlocks.get_playersPointsHashMap().get(playersArrayMock[0]));
        Assertions.assertEquals(0, objDominateAnAmountOfBlocks.get_playersPointsHashMap().get(playersArrayMock[1]));
    }

    @Test
    public void Raise_Player_Event_When_A_Player_Completed_Objective(){
        EventManager.SubscribeInPlayerEvent("PL_COMPLETED_OBJ", listenerMock);

        objDominateAnAmountOfBlocks.OnPlayerEventRaised(playersArrayMock[0]);
        objDominateAnAmountOfBlocks.OnPlayerEventRaised(playersArrayMock[0]);

        Assertions.assertTrue(listenerMock.hasBeenCalledFlag);
    }

    @Test
    public void Not_Raise_Player_Event_When_Nobody_Completed_Objective(){
        EventManager.SubscribeInPlayerEvent("PL_COMPLETED_OBJ", listenerMock);

        objDominateAnAmountOfBlocks.OnPlayerEventRaised(playersArrayMock[0]);
        objDominateAnAmountOfBlocks.OnPlayerEventRaised(playersArrayMock[1]);

        Assertions.assertFalse(listenerMock.hasBeenCalledFlag);
    }
}
