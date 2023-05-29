package domain.usecase;

import domain.entities.eventsystem.EventManager;
import domain.entities.eventsystem.IEventListener;

public class ManageRoundsUseCase implements IEventListener {
    private int _currentRound;

    public int GoToNextRound(){
        this._currentRound++;
        EventManager.RaiseAnEvent("EV_NEXT_ROUND");
        System.out.println("Mudando de round!");
        return this._currentRound;
    }

    @Override
    public void OnEventRaised() {
        GoToNextRound();
    }

    public int get_currentRound() {
        return _currentRound;
    }

    public ManageRoundsUseCase(){
        this._currentRound = 1;
        EventManager.CreateEventIfItDoesNotExists("EV_NEXT_ROUND");
    }
    public ManageRoundsUseCase(String eventToSubscribe){
        this._currentRound = 1;
        EventManager.CreateEventIfItDoesNotExists("EV_NEXT_ROUND");
        EventManager.SubscribeInEvent(eventToSubscribe, this);
    }
    public ManageRoundsUseCase(int _currentRound) {
        EventManager.CreateEventIfItDoesNotExists("EV_NEXT_ROUND");

        if(_currentRound > 0)
            this._currentRound = _currentRound;
    }

}
