package tictactoe;

import java.util.List;

public class Client {
    public static void main(String[] args){
        Player p1=new Player(1,"prem");
        Player p2=new Player(2,"sandy"),
        Game game=new Game(3, List.of(p1,p2),new Window(512,512));
        game.startGame();
        game.makeMove(new Move(20,20));
        game.makeMove(new Move(20,20));
        game.makeMove(new Move(20,20));
        game.makeMove(new Move(20,20));
        game.getWinner();
    }
}
