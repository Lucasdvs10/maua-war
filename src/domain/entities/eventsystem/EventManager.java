package domain.entities.eventsystem;

import domain.entities.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventManager {
    public static HashMap<String, List<IEventListener>> AllEventsMap = new HashMap<>();
    public static HashMap<String, List<IPlayerEventListener>> AllPlayerEventsMap = new HashMap<>();

    public static void RaiseAnEvent(String eventName){
        for (IEventListener listener : AllEventsMap.get(eventName)){
            listener.OnEventRaised();
        }
    }

    public static void RaiseAnPlayerEvent(String eventName, Player playerWhoRaisedEvent){
        for (IPlayerEventListener listener : AllPlayerEventsMap.get(eventName)){
            listener.OnPlayerEventRaised(playerWhoRaisedEvent);
        }
    }

    public static void CreateEventIfItDoesNotExists(String eventName){
        if(!AllEventsMap.containsKey(eventName)){
            AllEventsMap.put(eventName, new ArrayList<>());
        }
    }

    public static void CreatePlayerEventIfItDoesNotExists(String eventName){
        if(!AllPlayerEventsMap.containsKey(eventName)){
            AllPlayerEventsMap.put(eventName, new ArrayList<>());
        }
    }


    public static void SubscribeInPlayerEvent(String eventName, IPlayerEventListener playerEventListener){
        AllPlayerEventsMap.get(eventName).add(playerEventListener);
    }

    public static void UnsubscribeInPlayerEvent(String eventName, IPlayerEventListener playerEventListener){
        AllPlayerEventsMap.get(eventName).remove(playerEventListener);
    }

    public static void SubscribeInEvent(String eventName, IEventListener eventListener){
        AllEventsMap.get(eventName).add(eventListener);
    }

    public static void UnsubscribeInEvent(String eventName, IEventListener eventListener){
        AllEventsMap.get(eventName).remove(eventListener);
    }
}
