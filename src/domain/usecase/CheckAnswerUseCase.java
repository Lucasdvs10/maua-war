package domain.usecase;

import domain.entities.Player;
import domain.entities.Question;
import domain.entities.eventsystem.EventManager;

public class CheckAnswerUseCase {
    public boolean VerifyPlayerAnswer(Player player, Question question, char playerAnswer){
        if(playerAnswer != question.get_correctAlternative()){
            EventManager.RaiseAnEvent("EV_PLAYER_ANSWERED_A_QUESTION");
            return false;
        }
            EventManager.RaiseAnEvent("EV_PLAYER_ANSWERED_A_QUESTION");
            EventManager.RaiseAnPlayerEvent("PL_ANSWERED_A_QUESTION_CORRECTLY", player);
            return true;
    }
    public CheckAnswerUseCase(){
        EventManager.CreatePlayerEventIfItDoesNotExists("PL_ANSWERED_A_QUESTION_CORRECTLY");
        EventManager.CreatePlayerEventIfItDoesNotExists("EV_PLAYER_ANSWERED_A_QUESTION");
    }

}
