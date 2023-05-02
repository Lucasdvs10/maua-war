package domain.entities;

import java.util.HashMap;

public class Question {
    private final String _statement;
    private HashMap<Character, String> _alternativesHashMap;
    private final Character _correctAlternative;

    public Question(String _statement, Character _correctAlternative) {
        this._statement = _statement;
        this._alternativesHashMap = new HashMap<>();
        this._correctAlternative = _correctAlternative;
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

}
