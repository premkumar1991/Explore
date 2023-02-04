package tictactoe;

import java.util.Arrays;

public class Board {
    private int[][] board;
    public Board(int n, int defaultValue){
        this.board=new int[n][n];
        if(defaultValue!=0){
            Arrays.stream(board).forEach(a->Arrays.fill(a,defaultValue));
        }
    }
    public void setCell(int row,int col,int val){
        if(!this.isValidCell(row,col))
            throw new IllegalArgumentException("row and col value is invalid");
        board[row][col]=val;
    }
    private boolean isValidCell(int row,int col){
        return row>=0&&row<board.length&&col>=0&&col<board.length;
    }
    public int getCellValue(int row,int col){
        return board[row][col];
    }
}
