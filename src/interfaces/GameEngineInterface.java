package interfaces;

public interface GameEngineInterface {
    void startGameEngine();
    int rollDice();
    void showTable();
    void endGameEngine();
    boolean  isColumnComplete(int column);
    void getColumnWinner(int column);
    void getWinner();
}
