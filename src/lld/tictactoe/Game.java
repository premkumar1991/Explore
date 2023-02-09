package lld.tictactoe;

import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    Window window;
    int lastPlayerIdx=-1;
    boolean win=false;
    Player winner;
    public Game(int n, List<Player> players, Window window){
        board=new Board(n,-1);
        this.players=players;
        this.window=window;
    }
    public Player getWinner(){
        return players.get(0);
    }
    public boolean startGame(){
        return true;
    }
    public void makeMove(Move move){
        int row = getRow(move.posX);
        int col = getCol(move.posX);
        if(lastPlayerIdx==-1){
            lastPlayerIdx=0;
        }else
            lastPlayerIdx=1-lastPlayerIdx;
        board.setCell(row,col,lastPlayerIdx);
        getWinner();
    }
    private int getRow(float posX){
        return 0;
    }
    private int getCol(float posY){
        return 0;
    }
}
