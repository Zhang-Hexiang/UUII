import com.example.uuii.Chessboard;
import com.example.uuii.Piece;
import org.testng.annotations.Test;


public class TestClss {

    @Test
    public void isMovableTest(){
        Chessboard chessboard = new Chessboard();
        System.out.println(this.isMovable(chessboard.getcBoard(),1,1));
    }


    public boolean isMovable(Piece[][] board, int row, int col){
        if(row < 0 || row > 1 || col < 0 || col >2) return false;
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
        int absCoordinateValue = Math.abs(thisPieceMark - emptyPieceMark);
        if(thisPiece != Piece.EMPTY && Math.abs(col - emptyCol) != 2){
            if(absCoordinateValue == 1 && thisPiece != Piece.BISHOP){
                return true;
            }
            else if((absCoordinateValue == 0 || absCoordinateValue == 2) && thisPiece != Piece.ROOK){
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
}
