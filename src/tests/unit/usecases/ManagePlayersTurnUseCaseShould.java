package tests.unit.usecases;

import domain.usecase.ManagePlayersTurnUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagePlayersTurnUseCaseShould {
    @Test
    public void Return_Index_2(){
        ManagePlayersTurnUseCase useCase = new ManagePlayersTurnUseCase(2);

        useCase.FinishCurrentPlayersTurn();

        Assertions.assertEquals(2, useCase.get_currentPlayerID());
    }

    @Test
    public void Return_Index_1_When_Current_Index_Is_Last(){
        ManagePlayersTurnUseCase useCase = new ManagePlayersTurnUseCase(2);

        useCase.FinishCurrentPlayersTurn();
        useCase.FinishCurrentPlayersTurn();

        Assertions.assertEquals(1, useCase.get_currentPlayerID());
    }
}
