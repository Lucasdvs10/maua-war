package domain.entities;

import java.util.HashMap;

public class Question {

    private final int _questionId;
    private final String _statement;
    private HashMap<Character, String> _alternativesHashMap;
    private final Character _correctAlternative;

    public Question(String _statement, Character _correctAlternative, int _questionId) {
        this._questionId = _questionId;
        this._statement = _statement;
        this._alternativesHashMap = new HashMap<>();
        this._correctAlternative = _correctAlternative;
    }

    public void AddAlternativeToHashMap(Character alternativeLetter, String alternativeStatement){
        this._alternativesHashMap.put(alternativeLetter, alternativeStatement);
    }

    public String get_statement() {
        return _statement;
    }

    public HashMap<Character, String> get_alternativesHashMap() {
        return _alternativesHashMap;
    }


    public Character get_correctAlternative() {
        return _correctAlternative;
    }

    public int get_questionId() {
        return _questionId;
    }
}
