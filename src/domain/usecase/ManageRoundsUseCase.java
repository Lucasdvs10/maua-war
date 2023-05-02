package domain.usecase;

public class ManageRoundsUseCase {
    private int _currentRound;

    //Todo: Aplicar o Observer Pattern para emitir um evento toda vez que mudarmos de Round?
    public int GoToNextRound(){
        this._currentRound++;
        return this._currentRound;
    }

    public int get_currentRound() {
        return _currentRound;
    }

    public ManageRoundsUseCase(){
        this._currentRound = 0;
    }
    public ManageRoundsUseCase(int _currentRound) {
        if(_currentRound > 0)
            this._currentRound = _currentRound;
    }
}
