package tests.unit;

import domain.entities.Block;
import domain.entities.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class PlayerEntityShould {
    @Test
    public void Add_A_Dominated_Block_Into_HashMap(){
        Player mockPlayer = new Player("Jogador 1", Color.BLUE);

        Block mockBlock = new Block("Bloco A", 10);

        mockPlayer.AddBlockToDominatedHashMap(mockBlock);

        Assertions.assertEquals(1, mockPlayer.get_dominatedBlocksHashMap().size());
        Assertions.assertSame(mockBlock, mockPlayer.get_dominatedBlocksHashMap().get(mockBlock.get_blockName()));
        Assertions.assertTrue(mockBlock.get_isDominated());
    }

    @Test
    public void Not_Add_Same_Block_Twice(){

        Player mockPlayer = new Player("Jogador 1", Color.BLUE);

        Block mockBlock = new Block("Bloco A", 10);

        mockPlayer.AddBlockToDominatedHashMap(mockBlock);
        mockPlayer.AddBlockToDominatedHashMap(mockBlock);

        Assertions.assertEquals(1, mockPlayer.get_dominatedBlocksHashMap().size());
        Assertions.assertSame(mockBlock, mockPlayer.get_dominatedBlocksHashMap().get(mockBlock.get_blockName()));
        Assertions.assertTrue(mockBlock.get_isDominated());
    }
}
