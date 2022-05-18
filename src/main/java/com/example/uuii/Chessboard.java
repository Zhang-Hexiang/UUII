package com.example.uuii;

public class Chessboard {
     Piece[][] cBoard = new Piece[2][3];

    public Chessboard() {
        this.cBoard[0][0] = Piece.KING;
        this.cBoard[0][1] = Piece.BISHOP;
        this.cBoard[0][2] = Piece.BISHOP;
        this.cBoard[1][0] = Piece.ROOK;
        this.cBoard[1][1] = Piece.ROOK;
        this.cBoard[1][2] = Piece.EMPTY;
    }

    public void start(){  //设定初始棋盘
        this.cBoard[0][0] = Piece.KING;
        this.cBoard[0][1] = Piece.BISHOP;
        this.cBoard[0][2] = Piece.BISHOP;
        this.cBoard[1][0] = Piece.ROOK;
        this.cBoard[1][1] = Piece.ROOK;
        this.cBoard[1][2] = Piece.EMPTY;

    }

    public boolean isPlayerWin(){  //查询当前游戏是否完成
        if(this.cBoard[0][0] == Piece.BISHOP
                && this.cBoard[0][1] == Piece.BISHOP
                && this.cBoard[0][2] == Piece.EMPTY
                && this.cBoard[1][0] == Piece.ROOK
                && this.cBoard[1][1] == Piece.ROOK
                && this.cBoard[1][2] == Piece.KING){
            return true;
        }

        return false;
    }

    public void swap(int rowA, int colA, int rowB, int colB){  //交换AA 格子 和BB 格子的棋子
        Piece mark = this.cBoard[rowA][colA];
        this.cBoard[rowA][colA] = this.cBoard[rowB][colB];
        this.cBoard[rowB][colB] = mark;
    }

    public void setcBoard(Piece[][] data){
        this.cBoard = data;
    }

    public Piece[][] getcBoard() { //查询当先棋盘状态
        return this.cBoard;
    }

    public boolean testWin(){
        if(this.cBoard[0][0] == Piece.KING
                && this.cBoard[0][1] == Piece.BISHOP
                && this.cBoard[0][2] == Piece.BISHOP
                && this.cBoard[1][0] == Piece.ROOK
                && this.cBoard[1][1] == Piece.EMPTY
                && this.cBoard[1][2] == Piece.ROOK){
            return true;
        }

        return false;
    }
}
