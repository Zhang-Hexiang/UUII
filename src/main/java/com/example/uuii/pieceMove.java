package com.example.uuii;

import org.tinylog.Logger;

public class pieceMove {

    /**
     *
     * @param board the chessboard state
     * @param row   the aimed piece row number
     * @param col   the aimed piece col number
     * @return true if the aimed piece is movable
     */
    public boolean isMovable(Piece[][] board, int row, int col){

        if(row < 0 || row > 1 || col < 0 || col >2) return false;
        /**
         * Save the selected piece type
         * and Find the Empty grid row and col number
         */
        Piece thisPiece = board[row][col];
        int emptyRow = 0, emptyCol = 0;
        for(int r = 0; r < 2; r++){
            for (int c = 0; c < 3; c++){
                if(board[r][c] == Piece.EMPTY){
                    emptyCol = c;
                    emptyRow = r;
                }
            }
        }

        int thisPieceMark = row + col;
        int emptyPieceMark = emptyCol + emptyRow;
        /**
         * absCoordinateValue is the absolute value of the difference between the sum of the coordinates of the selected piece and the sum of the coordinates of the empty square
         * In this game, if the absCoordinateValue is 1, the selected piece is in a straight line relationship with the empty square
         * if the absCoordinateValue is 0 or 2, the selected piece is diagonal to the empty square
         */
        int absCoordinateValue = Math.abs(thisPieceMark - emptyPieceMark);
        /**
         * LIMIT
         * the selected piece is not empty and adjacent to empty square
         */
        if(thisPiece != Piece.EMPTY && Math.abs(col - emptyCol) != 2){
            if(absCoordinateValue == 1 && thisPiece != Piece.BISHOP){
                Logger.info("movable");
                return true;
            }
            else if((absCoordinateValue == 0 || absCoordinateValue == 2) && thisPiece != Piece.ROOK){
                Logger.info("movable");
                return true;
            }
            else
                return false;
        }
        else
           return false;
    }
}
