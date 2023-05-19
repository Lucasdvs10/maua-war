package domain.usecase;

import domain.entities.eventsystem.EventManager;

public class ManagePlayersTurnUseCase {

    private int[] _allPlayersIndexArray;
    private int _currentPlayerID;
    private int _currentIndex;

    public void FinishCurrentPlayersTurn(){
        _currentIndex++;
        if(_currentIndex >= _allPlayersIndexArray.length){
            _currentIndex = 0;
            EventManager.RaiseAnEvent("EV_LAST_PLAYER_PLAYED");
        }

        _currentPlayerID = _allPlayersIndexArray[_currentIndex];
    }

    public ManagePlayersTurnUseCase(int numberOfPlayers) {
        EventManager.CreateEventIfItDoesNotExists("EV_LAST_PLAYER_PLAYED");

        this._allPlayersIndexArray = new int[numberOfPlayers];

        for(int i = 0; i < numberOfPlayers; i++){
            this._allPlayersIndexArray[i] = i + 1;
        }

        _currentIndex = 0;
        _currentPlayerID = _allPlayersIndexArray[0];
    }

    public int get_currentPlayerID() {
        return _currentPlayerID;
    }
}
