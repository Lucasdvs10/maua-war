package domain.entities;

import java.awt.*;

public class Player {
    private int _playerID;
    private Color _playerColor;

    public Player(int playerIndex, Color _playerColor) {
        this.set_playerID(playerIndex);
        this._playerColor = _playerColor;
    }

    public String GetPlayerName(){
        return String.format("Jogador %d", this._playerID);
    }
    public int get_playerID() {
        return _playerID;
    }

    public void set_playerID(int _playerID) {
        if(_playerID <= 0){
            this._playerID = 0;
            return;
        }
        this._playerID = _playerID;
    }

    public Color get_playerColor() {
        return _playerColor;
    }

    public void set_playerColor(Color _playerColor) {
        this._playerColor = _playerColor;
    }

}
