package domain.usecase.objectivesystem;

import domain.entities.Player;
import domain.entities.eventsystem.EventManager;
import domain.entities.eventsystem.IPlayerEventListener;

import java.util.HashMap;

public class OBJAnswerAnAmountOfQuestions implements IPlayerEventListener {
    private int _amountToAnswer;
    private HashMap<Player, Integer> _playerPointsHashMap;

    public OBJAnswerAnAmountOfQuestions(int _amountToAnswer, Player[] playersArray){
        this._amountToAnswer = _amountToAnswer;
        this._playerPointsHashMap = new HashMap<>();
        EventManager.CreatePlayerEventIfItDoesNotExists("PL_COMPLETED_OBJ");

        for(Player player : playersArray){
            this._playerPointsHashMap.put(player, 0);
        }
    }

    public OBJAnswerAnAmountOfQuestions(int _amountToAnswer, HashMap<Player, Integer> _playerPointsHashMap) {
        this._amountToAnswer = _amountToAnswer;
        this._playerPointsHashMap = _playerPointsHashMap;
        EventManager.CreatePlayerEventIfItDoesNotExists("PL_COMPLETED_OBJ");
    }

    @Override
    public void OnPlayerEventRaised(Player player) {
        PlayerAnsweredQuestionCorrectly(player);
    }

    public void PlayerAnsweredQuestionCorrectly(Player player) {
        int currentPoints = this._playerPointsHashMap.get(player);
        this._playerPointsHashMap.put(player, ++currentPoints);

        if(currentPoints >= this._amountToAnswer){
            EventManager.RaiseAnPlayerEvent("PL_COMPLETED_OBJ", player);
        }
    }

    public int get_amountToAnswer() {
        return _amountToAnswer;
    }

    public HashMap<Player, Integer> get_playerPointsHashMap() {
        return _playerPointsHashMap;
    }
}
