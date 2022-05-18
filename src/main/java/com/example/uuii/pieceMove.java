package com.example.uuii;

/*import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;*/

public class pieceMove {

    int rr;
    int cc;

 /*   @Test*/
    void ttest(){
        Chessboard board = new Chessboard();
/*        Assertions.assertFalse(this.isMovable(board.getcBoard(), 0, 2));*/
       // Assertions.assertTrue(this.isMovable(board.getcBoard(), 0, 1));
       // Assertions.assertTrue(this.isMovable(board.getcBoard(), 1, 1));
        System.out.println(board.getcBoard()[0][0]+ " " +board.getcBoard()[0][1] + " "+board.getcBoard()[0][2]);
        System.out.println(board.getcBoard()[1][0]+ " " +board.getcBoard()[1][1] + "   "+board.getcBoard()[1][2]);
        System.out.println(rr+"hang " + cc+"lie ");
    }

    /**
     *
     * @param board 当前棋盘数据
     * @param row   需要移动的棋子row
     * @param col   需要移动的棋子column
     * @return 是否能够移动
     */
   /* @Test*/
    public boolean isMovable(Piece[][] board, int row, int col){

        if(row < 0 || row > 1 || col < 0 || col >2) return false;

        Piece thisPiece = board[row][col];  //记录当前所选择的棋子种类
        int emptyRow = 0, emptyCol = 0;     //记录空棋格位置信息
        for(int r = 0; r < 2; r++){       //遍历棋盘找出空棋格位置
            for (int c = 0; c < 3; c++){
                if(board[r][c] == Piece.EMPTY){
                    emptyCol = c;
                    emptyRow = r;
                    //System.out.println(r+"hang ," + c+"lie ");
                    this.cc = c;
                    this.rr = r;
                }
            }
        }
        int thisPieceMark = row + col;
        int emptyPieceMark = emptyCol + emptyRow;
        int absCoordinateValue = Math.abs(thisPieceMark - emptyPieceMark);  //当前棋子坐标之和  与  空棋格坐标之和  之差  若为1 则是直线关系  若为0或2 则是对角关系
        if(thisPiece != Piece.EMPTY && Math.abs(col - emptyCol) != 2){     // 当前棋子不为空  且  当前棋子与空棋格相邻
            if(absCoordinateValue == 1 && thisPiece != Piece.BISHOP){      // 当前棋子与空棋格为直线关系  且  当前棋子不为 象
                return true;
            }
            else if((absCoordinateValue == 0 || absCoordinateValue == 2) && thisPiece != Piece.ROOK){  // 当前棋子与空棋格为对角关系  且  当前棋子不为 车
                return true;
            }
            else
                return false;
        }

        else
           return false;
    }
}
// 棋子移动