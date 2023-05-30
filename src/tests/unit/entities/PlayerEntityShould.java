package tests.unit.entities;

import domain.entities.Block;
import domain.entities.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class PlayerEntityShould {


    @Test
    public void Not_Have_Index_Less_Than_Zero(){
        Player mockPlayer = new Player(-5, Color.red);

        Assertions.assertEquals(0, mockPlayer.get_playerID());
    }

    @Test
    public void Have_Name_Jogador1(){
        Player mockPlayer = new Player(1, Color.BLUE);

        Assertions.assertEquals("Jogador 1", mockPlayer.GetPlayerName());
    }
}
