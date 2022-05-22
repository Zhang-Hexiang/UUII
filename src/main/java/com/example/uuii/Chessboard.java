package com.example.uuii;

public class Chessboard {
    /**
     * Set the board size 2 row * 3 col
     */
     Piece[][] cBoard = new Piece[2][3];

    /**
     * Set the default chessboard
     */
    public Chessboard() {
        this.cBoard[0][0] = Piece.KING;
        this.cBoard[0][1] = Piece.BISHOP;
        this.cBoard[0][2] = Piece.BISHOP;
        this.cBoard[1][0] = Piece.ROOK;
        this.cBoard[1][1] = Piece.ROOK;
        this.cBoard[1][2] = Piece.EMPTY;
    }

    /**
     * Set the default chessboard
     */
    public void start(){
        this.cBoard[0][0] = Piece.KING;
        this.cBoard[0][1] = Piece.BISHOP;
        this.cBoard[0][2] = Piece.BISHOP;
        this.cBoard[1][0] = Piece.ROOK;
        this.cBoard[1][1] = Piece.ROOK;
        this.cBoard[1][2] = Piece.EMPTY;

    }

    /**
     * Compare this.chessboard to the win status
     * @return true if player win the game
     */
    public boolean isPlayerWin(){
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

    /**
     * Swap the pieces which player aimed
     * @param rowA aimed piece row number
     * @param colA aimed piece col number
     * @param rowB empty grid row number
     * @param colB empty grid col number
     */
    public void swap(int rowA, int colA, int rowB, int colB){
        Piece mark = this.cBoard[rowA][colA];
        this.cBoard[rowA][colA] = this.cBoard[rowB][colB];
        this.cBoard[rowB][colB] = mark;
    }

    /**
     * setter
     * @param data
     */
    public void setcBoard(Piece[][] data){
        this.cBoard = data;
    }

    /**
     * getter
     * @return this.chessboard
     */
    public Piece[][] getcBoard() { //查询当先棋盘状态
        return this.cBoard;
    }

}
