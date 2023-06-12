package domain.usecase.objectivesystem;

import domain.entities.Block;
import domain.entities.Player;
import domain.entities.eventsystem.EventManager;

public class ObjectivesContainer { //Aqui nós vamos instanciar todos os objetivos e conecta-los aos seus eventos

    public ObjectivesContainer(Player[] allPlayersArray, Block[] allBlocksArray) {
        OBJAnswerAnAmountOfQuestions objAnswerAnAmountOfQuestions = new OBJAnswerAnAmountOfQuestions(9, allPlayersArray);
        OBJDominateAnAmountOfBlocks objDominateAnAmountOfBlocks = new OBJDominateAnAmountOfBlocks(5, allPlayersArray);


        EventManager.CreatePlayerEventIfItDoesNotExists("PL_ANSWERED_A_QUESTION_CORRECTLY");
        EventManager.CreatePlayerEventIfItDoesNotExists("PL_DOMINATED_A_BLOC");

        EventManager.SubscribeInPlayerEvent("PL_ANSWERED_A_QUESTION_CORRECTLY", objAnswerAnAmountOfQuestions);
        EventManager.SubscribeInPlayerEvent("PL_DOMINATED_A_BLOC", objDominateAnAmountOfBlocks);
    }
}
