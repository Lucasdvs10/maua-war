package domain.usecase;

public class ManagePlayersTurnUseCase { //Todo: Implementar o observer pattern e emitir um
                                        // evento quando todos os players jogarem no round
    
    private int[] _allPlayersIndexArray;

    private int _currentPlayerID;
    private int _currentIndex;

    public void FinishCurrentPlayersTurn(){
        _currentIndex++;
        if(_currentIndex >= _allPlayersIndexArray.length){
            _currentIndex = 0;
        }

        _currentPlayerID = _allPlayersIndexArray[_currentIndex];
    }

    public ManagePlayersTurnUseCase(int numberOfPlayers) {
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
