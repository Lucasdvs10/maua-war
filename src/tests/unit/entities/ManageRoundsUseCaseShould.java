package tests.unit.entities;

import domain.usecase.ManageRoundsUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManageRoundsUseCaseShould {
    @Test
    public void Initialize_Current_Round_As_Zero(){
        ManageRoundsUseCase manageRoundsUseCase = new ManageRoundsUseCase();

        Assertions.assertEquals(0, manageRoundsUseCase.get_currentRound());
    }

    @Test
    public void Set_Current_Round_As_1_When_Call_GoToNextRound(){
        ManageRoundsUseCase manageRoundsUseCase = new ManageRoundsUseCase();

        manageRoundsUseCase.GoToNextRound();

        Assertions.assertEquals(1, manageRoundsUseCase.get_currentRound());
    }
}
