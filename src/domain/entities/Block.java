package domain.entities;

public class Block {
    private String _blockName;
    private int _currentLife;
    private int _maxLife;

    private boolean _isDominated;
    private Player _playerWhoDominated;

    public int ApplyDamage(int damageValue){
        set_currentLife(_currentLife - damageValue);
        return _currentLife;
    }

    public Block(String _blockName, int _maxLife) {
        this._blockName = _blockName;
        this.set_maxLife(_maxLife);
        this.set_currentLife(_maxLife);
        this._isDominated = false;
    }
    public Block(String _blockName, int _maxLife, int _currentLife) {
        this._blockName = _blockName;
        this.set_maxLife(_maxLife);
        this.set_currentLife(_currentLife);
        this._isDominated = false;
    }

    public void set_blockName(String _blockName) {
        this._blockName = _blockName;
    }

    public void set_playerWhoDominated(Player player){
        _playerWhoDominated = player;
    }

    public Player get_playerWhoDominated() {
        return _playerWhoDominated;
    }

    public void set_currentLife(int _currentLife) {
        if(_currentLife <= 0)
            this._currentLife = 0;
        else if(_currentLife >= this._maxLife){
            this._currentLife = this._maxLife;
        }
        else{
            this._currentLife = _currentLife;
        }
    }

    public void set_maxLife(int _maxLife) {
        if( _maxLife <= 0) return;

        this._maxLife = _maxLife;
    }

    public String get_blockNameAndLife() {
        return String.format("%s (%d)", _blockName, _currentLife);
    }

    public String get_blockName(){
        return _blockName;
    }

    public int get_currentLife() {
        return _currentLife;
    }

    public int get_maxLife() {
        return _maxLife;
    }

    public boolean get_isDominated() {
        return _isDominated;
    }

    public void set_isDominated(boolean _isDominated) {
        this._isDominated = _isDominated;
    }
}
