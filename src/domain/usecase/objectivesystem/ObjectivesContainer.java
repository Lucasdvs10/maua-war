package domain.usecase.objectivesystem;

import domain.entities.Block;
import domain.entities.Player;
import domain.entities.eventsystem.EventManager;

public class ObjectivesContainer { //Aqui nós vamos instanciar todos os objetivos e conecta-los aos seus eventos

    public ObjectivesContainer(Player[] allPlayersArray, Block[] allBlocksArray) {
        OBJAnswerAnAmountOfQuestions objAnswerAnAmountOfQuestions = new OBJAnswerAnAmountOfQuestions(5, allPlayersArray);
        OBJDominateAnAmountOfBlocks objDominateAnAmountOfBlocks = new OBJDominateAnAmountOfBlocks(5, allPlayersArray);


        EventManager.SubscribeInPlayerEvent("PL_ANSWERED_A_QUESTION", objAnswerAnAmountOfQuestions);
        EventManager.SubscribeInPlayerEvent("PL_DOMINATED_A_BLOC", objDominateAnAmountOfBlocks);
    }
}
