package tests.unit.entities;

import domain.entities.Block;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlockEntityShould {
    @Test
    public void Set_Current_Life_As_5_When_Bigger_Than_MaxLife(){
        Block myBlock = new Block("A", 5);

        myBlock.set_currentLife(10);

        Assertions.assertEquals(5, myBlock.get_currentLife());
    }


    @Test
    public void Set_Current_Life_As_0_When_Less_Than_Zero(){
        Block myBlock = new Block("A", 5);

        myBlock.set_currentLife(-1);

        Assertions.assertEquals(0, myBlock.get_currentLife());
    }


    @Test
    public void Set_Max_Life_As_0_When_Less_Than_Zero(){
        Block myBlock = new Block("A", -5);


        Assertions.assertEquals(0, myBlock.get_maxLife());
    }

    @Test
    public void Get_Name_In_The_Right_Format(){
        Block myBlock = new Block("A", 5);

        Assertions.assertEquals("A (5)", myBlock.get_blockName());

        myBlock.set_currentLife(2);

        Assertions.assertEquals("A (2)", myBlock.get_blockName());
    }
}
