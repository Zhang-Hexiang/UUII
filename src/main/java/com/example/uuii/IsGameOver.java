package com.example.uuii;

public class IsGameOver {
    public boolean gg(Piece[][] board){
        if(board[1][2] == Piece.KING
                && board[1][1] == Piece.ROOK
                && board[1][0] == Piece.ROOK
                && board[0][0] == Piece.BISHOP
                && board[0][1] == Piece.BISHOP){
            return true;
        }
        else
          return false;
    }
    public boolean giveUp(){
        return false;
    }
}
