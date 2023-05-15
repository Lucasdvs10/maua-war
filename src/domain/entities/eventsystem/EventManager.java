package domain.entities.eventsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventManager {
    public static HashMap<String, List<IEventListener>> AllEventsMap = new HashMap<>();

    public static void RaiseAnEvent(String eventName){
        for (IEventListener listener : AllEventsMap.get(eventName)){
            listener.OnEventRaised();
        }
    }

    public static void CreateEventIfItDoesNotExists(String eventName){
        if(!AllEventsMap.containsKey(eventName)){
            AllEventsMap.put(eventName, new ArrayList<>());
        }
    }

    public static void SubscribeInEvent(String eventName, IEventListener eventListener){
        AllEventsMap.get(eventName).add(eventListener);
    }

    public static void UnsubscribeInEvent(String eventName, IEventListener eventListener){
        AllEventsMap.get(eventName).remove(eventListener);
    }
}
