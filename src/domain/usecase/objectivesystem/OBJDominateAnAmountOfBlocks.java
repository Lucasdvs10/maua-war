package domain.usecase.objectivesystem;

import domain.entities.Block;
import domain.entities.Player;
import domain.entities.eventsystem.EventManager;
import domain.entities.eventsystem.IPlayerEventListener;

import java.util.HashMap;

public class OBJDominateAnAmountOfBlocks implements IPlayerEventListener {
    private int _amountToDominate;
    private HashMap<Player, Integer> _playersPointsHashMap;


    @Override
    public void OnPlayerEventRaised(Player player) {
        int currentPoints = _playersPointsHashMap.get(player);
        _playersPointsHashMap.put(player, ++currentPoints);

        if(currentPoints >= _amountToDominate){
            EventManager.RaiseAnPlayerEvent("PL_COMPLETED_OBJ", player);
        }
    }

    public OBJDominateAnAmountOfBlocks(int _amountToDominate, Player[] _allPlayersArray) {
        this._amountToDominate = _amountToDominate;
        this._playersPointsHashMap = new HashMap<>();

        for(Player player : _allPlayersArray){
            this._playersPointsHashMap.put(player, 0);
        }

        EventManager.CreatePlayerEventIfItDoesNotExists("PL_COMPLETED_OBJ");

    }

    public int get_amountToDominate() {
        return _amountToDominate;
    }

    public HashMap<Player, Integer> get_playersPointsHashMap() {
        return _playersPointsHashMap;
    }
}
