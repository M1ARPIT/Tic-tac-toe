import java .util.*;
class TicTacToe {

    static char[][] board;

    public TicTacToe() {

        board = new char[3][3];
        intitBoard();
//        when someday called and object condtructor is called and condtructor will create a
////            3*3 array
    }

    void intitBoard() {

        for (int i =0; i<board.length; i++) {

            for (int j = 0; j<board[i].length; j++) {

                board[i][j] = ' ';
            }
        }
    }

    static void dispBoard() {

        System.out.println("--------------------");
        for (int i =0; i < board.length; i++) {

            System.out.print(" | ");

            for (int j =0; j<board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------------------");
        }


    }

    static void placemark(int row, int col, char mark) {
        if (row >=0 && row <=2 && col>=0 && col <=2) {
            board[row][col] = mark;
        } else {
            System.out.println("invalid position");
        }
    }


    static boolean checkRowWin() {
        for (int i =0; i <=2; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }

        }
        return false;

    }
    static boolean checkColWin() {
        for (int j=0; j<=2; j++) {
            if (board[0][j] !=' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }

        }
        return false;

    }



    static boolean checkDiagwin() {
        if (board[0][0] !=' '&& board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
                board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]

        ) {
            return true;
        } else {
            return false;
        }
    }

}

abstract class Player{

    String name;
    char mark;
      abstract void makeMove();
    boolean isValidMove(int row, int col)
    {
        if(row>=0&& row<=2 && col>=0 && col<=2)
        {
            if (TicTacToe.board[row][col] ==' ') {

                return true ;

            }

        }
        return false;
    }

}
class HumanPlayer extends Player {

    HumanPlayer( String name,char mark)
    {
      this.name =name;
      this.mark =mark;

    }
    void makeMove()
    {
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
        do{
            System.out.println( "enter the row and col");
            row = scan.nextInt();
            col = scan.nextInt();
        } while(!isValidMove(row,col));
          TicTacToe.placemark(row,col,mark);

    }

}
class AIPlayer extends Player {

    AIPlayer( String name,char mark)
    {
        this.name =name;
        this.mark =mark;

    }
    void makeMove()
    {
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
        do{
             Random r =new Random();
             row=r.nextInt(3);
             col=r.nextInt(3);

        } while(!isValidMove(row,col));
        TicTacToe.placemark(row,col,mark);

    }

}
public class Main {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
       t.intitBoard();
         HumanPlayer p1 = new HumanPlayer( "bob", 'x');
         AIPlayer p2 =new AIPlayer("tap",'o');
         Player cp ;
         cp = p1;
        while(true)
        {
            System.out.println(cp.name+ "  turn  " );
            cp.makeMove();
            TicTacToe.dispBoard();
            if( TicTacToe.checkRowWin() || TicTacToe.checkColWin() || TicTacToe.checkDiagwin())
            {
                System.out.println(cp.name+ "has won");
                 break;

            } else{

                if(cp == p1)
                  {
                      cp = p2;
                  }
                  else{
                      cp = p1;
                }


            }

        }

    }
}

