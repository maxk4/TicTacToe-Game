// Name: Maximilian Kaczmarek
// UCID: 30151219
// Date: February 11, 2022
// Program description: Junit testing for the created TicTacToe game

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

// Junit setup for every function
class TicTacToeTest {
    TicTacToe tictactoe;

    @BeforeEach
    void setup() {
        tictactoe = new TicTacToe();
    }

    // createBoard

    // checking for columns(sizing)
    @Test
    @DisplayName("checking_columns")
    void checking_columns() {
        int[][] test_board = tictactoe.createBoard(3, 4);
        assertEquals(3, test_board[0].length, "3x4 square board should have 3 columns, 4 rows");
    }

    // checking for rows(sizing)
    @Test
    @DisplayName("checking_rows")
    void checking_rows() {
        int[][] test_board = tictactoe.createBoard(5, 3);
        assertEquals(3, test_board.length, "3x5 square board should have 3 rows, and 5 columns");
    }

    // checking if the board is empty
    @Test
    @DisplayName("checking_empty")
    void checking_empty() {
        int[][] test_board = tictactoe.createBoard(3, 3);
        boolean Flag = true;
        for (int i = 0; i < test_board[0].length; i++) {
            for (int j = 0; j < test_board.length; j++) {
                if (test_board[i][j] != 0) {
                    Flag = false;
                }
            }
        }
        assertEquals(true, Flag, "Board is supposed to be all zero's");

    }

    // rowsIn
    // checking the amount of rows we have
    @Test
    @DisplayName("checking_rowsIn1")
    void checking_rowsIn1() {
        int[][] test_board = tictactoe.createBoard(4, 3);
        assertEquals(3, test_board.length, "3x4 square board should have 3 rows");
    }

    // columnsIn
    // checking the amount of columns we have
    @Test
    @DisplayName("checking_columnsIn1")
    void checking_columnsIn1() {
        int[][] test_board = tictactoe.createBoard(5, 5);
        assertEquals(5, test_board[0].length, "5x5 square board should have 5 columns");
    }

    // canPlay
    // checking if it is open to play
    @Test
    @DisplayName("checking_canPlay")
    void checking_canPlay() {
        int column = 3;
        int row = 4;
        int[][] test_board = tictactoe.createBoard(5, 5);
        assertEquals(true, tictactoe.canPlay(test_board, row, column), "Can not play");
    }

    // play
    // checking play sees if it is valid to put a piece there
    @Test
    @DisplayName("checking_play1")
    void checking_play1() {
        int[][] test_board = tictactoe.createBoard(3, 3);
        int[][] final_board = tictactoe.createBoard(3, 3);
        final_board[1][1] = 1;
        tictactoe.play(test_board, 1, 1, 1);
        assertArrayEquals(final_board, test_board, "play did not work");
    }

    @Test
    @DisplayName("checking_play2")
    void checking_play2() {
        int[][] test_board = tictactoe.createBoard(4, 4);
        int[][] final_board = tictactoe.createBoard(4, 4);
        final_board[1][2] = 2;
        tictactoe.play(test_board, 1, 2, 2);
        assertArrayEquals(final_board, test_board, "play did not work");

    }

    // full
    // checking if board is empty or full
    @Test
    @DisplayName("checking_full1")
    void checking_full1() {
        int[][] test_board = tictactoe.createBoard(3, 5);
        assertEquals(false, tictactoe.full(test_board), "board is empty");

    }

    // places two pieces in the board, then checking if it is full
    @Test
    @DisplayName("checking_full2")
    void checking_full2() {
        int[][] test_board = tictactoe.createBoard(4, 2);
        // does not matter where I am placing. the piece itself cannot be 0
        test_board[1][1] = 2;
        assertEquals(false, tictactoe.full(test_board), "board is not completely full");
    }

    // placing 3 pieces in the board, then checking if it is full
    @Test
    @DisplayName("checking_full3")
    void checking_full3() {
        int[][] test_board = tictactoe.createBoard(3, 3);
        // does not matter where I am placing. the piece itself cannot be 0
        test_board[1][1] = 2;
        test_board[1][2] = 1;
        test_board[2][1] = 1;
        assertEquals(false, tictactoe.full(test_board), "board is not completely full");
    }

    // filling the board
    @Test
    @DisplayName("checking_full4")
    void checking_full4() {
        int[][] test_board = tictactoe.createBoard(3, 3);
        // does not matter where I am placing. the piece itself cannot be 0
        test_board[0][0] = 1;
        test_board[0][1] = 2;
        test_board[0][2] = 1;
        test_board[1][0] = 1;
        test_board[1][1] = 2;
        test_board[1][2] = 1;
        test_board[2][0] = 1;
        test_board[2][1] = 2;
        test_board[2][2] = 1;
        assertEquals(true, tictactoe.full(test_board), "board is full");
    }

    // winInRow
    // checking if we have a win in a row
    @Test
    @DisplayName("checking_winInRow1")
    void checking_winInRow1() {
        // making empty row
        int[][] test_board = tictactoe.createBoard(4, 3);
        // make x win in the first row
        test_board[0][0] = 2;
        test_board[0][1] = 2;
        test_board[0][2] = 2;
        // compare test board with checking in row
        assertEquals(true, tictactoe.winInRow(test_board, 0, 2), "three in a row, you won");
    }

    @Test
    @DisplayName("checking_winInRow2")
    void checking_winInRow2() {
        // making empty row
        int[][] test_board = tictactoe.createBoard(5, 3);
        // make x win in the first row
        test_board[1][0] = 1;
        test_board[1][1] = 1;
        test_board[1][2] = 1;
        // compare test board with checking in row
        assertEquals(true, tictactoe.winInRow(test_board, 1, 1), "three in a row, you won");
    }

    @Test
    @DisplayName("checking_winInRow3")
    void checking_winInRow3() {
        // making empty row
        int[][] test_board = tictactoe.createBoard(5, 3);
        // make x win in the first row
        test_board[2][0] = 1;
        test_board[2][1] = 1;
        test_board[2][2] = 1;
        // compare test board with checking in row
        assertEquals(true, tictactoe.winInRow(test_board, 2, 1), "three in a row, you won");
    }

    @Test
    @DisplayName("checking_winInRow4")
    void checking_winInRow4() {
        // making empty row
        int[][] test_board = tictactoe.createBoard(4, 5);
        // make x win in the first row
        test_board[2][0] = 1;
        test_board[2][1] = 2;
        test_board[2][2] = 1;
        // compare test board with checking in row
        assertEquals(false, tictactoe.winInRow(test_board, 2, 1), "should not count a loss as a win");
    }

    @Test
    @DisplayName("checking_winInRow5")
    void checking_winInRow5() {
        // making empty row
        int[][] test_board = tictactoe.createBoard(4, 5);
        // make x win in the first row
        test_board[1][0] = 2;
        test_board[1][1] = 1;
        test_board[1][2] = 1;
        // compare test board with checking in row
        assertEquals(false, tictactoe.winInRow(test_board, 1, 1), "should not count a loss as a win");
    }

    // winInColumn
    // checking if we have a win in a column
    @Test
    @DisplayName("checking_winInColumn1")
    void checking_winInColumn1() {
        // making empty row
        int[][] test_board = tictactoe.createBoard(4, 3);
        test_board[0][2] = 2;
        test_board[1][2] = 2;
        test_board[2][2] = 2;
        // compare test board with checking in column
        assertEquals(true, tictactoe.winInColumn(test_board, 2, 2), "three in a column, you won");
    }

    @Test
    @DisplayName("checking_winInColumn2")
    void checking_winInColumn2() {
        // making empty row
        int[][] test_board = tictactoe.createBoard(4, 3);
        test_board[0][1] = 2;
        test_board[1][1] = 2;
        test_board[2][1] = 2;
        // compare test board with checking in column
        assertEquals(true, tictactoe.winInColumn(test_board, 1, 2), "three in a column, you won");
    }

    @Test
    @DisplayName("checking_winInColumn3")
    void checking_winInColumn3() {
        // making empty row
        int[][] test_board = tictactoe.createBoard(4, 3);
        test_board[0][0] = 2;
        test_board[1][0] = 2;
        test_board[2][0] = 2;
        // compare test board with checking in column
        assertEquals(true, tictactoe.winInColumn(test_board, 0, 2), "three in a column, you won");
    }

    @Test
    @DisplayName("checking_winInColumn4")
    void checking_winInColumn4() {
        // making empty row
        int[][] test_board = tictactoe.createBoard(4, 3);
        test_board[0][0] = 2;
        test_board[1][0] = 1;
        test_board[2][0] = 2;
        // compare test board with checking in column
        assertEquals(false, tictactoe.winInColumn(test_board, 0, 1), "should not count a loss as a win");
    }

    @Test
    @DisplayName("checking_winInColumn5")
    void checking_winInColumn5() {
        // making empty row
        int[][] test_board = tictactoe.createBoard(4, 3);
        test_board[0][2] = 1;
        test_board[1][2] = 2;
        test_board[2][2] = 2;
        // compare test board with checking in column
        assertEquals(false, tictactoe.winInColumn(test_board, 2, 2), "should not count a loss as a win");
    }

    // winInDiagonalBS
    // checking if we have a win with a negative slope
    @Test
    @DisplayName("checking_winInDiagonalBS1")
    void checking_winInDiagonalBS1() {
        int[][] test_board = tictactoe.createBoard(3, 3);
        test_board[0][0] = 1;
        test_board[1][1] = 1;
        test_board[2][2] = 1;
        assertEquals(true, tictactoe.winInDiagonalBS(test_board, 1), "correct diagonal");
    }

    @Test
    @DisplayName("checking_winInDiagonalBS2")
    void checking_winInDiagonalBS2() {
        int[][] test_board = tictactoe.createBoard(3, 3);
        test_board[0][0] = 1;
        test_board[1][1] = 2;
        test_board[2][2] = 1;
        assertEquals(false, tictactoe.winInDiagonalBS(test_board, 1), "incorrect diagonal win");
    }

    @Test
    @DisplayName("checking_winInDiagonalBS3")
    void checking_winInDiagonalBS3() {
        int[][] test_board = tictactoe.createBoard(3, 5);
        test_board[2][0] = 1;
        test_board[3][1] = 1;
        test_board[4][2] = 1;
        assertEquals(true, tictactoe.winInDiagonalBS(test_board, 1), "correct diagonal");
    }

    @Test
    @DisplayName("checking_winInDiagonalBS4")
    void checking_winInDiagonalBS4() {
        int[][] test_board = tictactoe.createBoard(4, 4);
        test_board[1][0] = 2;
        test_board[2][1] = 2;
        test_board[3][2] = 2;
        assertEquals(true, tictactoe.winInDiagonalBS(test_board, 2), "correct diagonal");
    }

    @Test
    @DisplayName("checking_winInDiagonalBS5")
    void checking_winInDiagonalBS5() {
        int[][] test_board = tictactoe.createBoard(5, 4);
        test_board[1][2] = 1;
        test_board[2][3] = 2;
        test_board[3][4] = 2;
        assertEquals(false, tictactoe.winInDiagonalBS(test_board, 2), "incorrect diagonal win");
    }

    // winInDiagonalFS
    // checking if we have a win with a positive slope
    @Test
    @DisplayName("checking_winInDiagonalFS1")
    void checking_winInDiagonal1() {
        int[][] test_board = tictactoe.createBoard(3, 3);
        test_board[0][2] = 2;
        test_board[1][1] = 2;
        test_board[2][0] = 2;
        assertEquals(true, tictactoe.winInDiagonalFS(test_board, 2), "correct diagonal");
    }

    @Test
    @DisplayName("checking_winInDiagonalFS2")
    void checking_winInDiagonal2() {
        int[][] test_board = tictactoe.createBoard(3, 3);
        test_board[0][2] = 2;
        test_board[1][1] = 1;
        test_board[2][0] = 2;
        assertEquals(false, tictactoe.winInDiagonalFS(test_board, 2), "incorrect diagonal win");
    }

    @Test
    @DisplayName("checking_winInDiagonalFS3")
    void checking_winInDiagonal3() {
        int[][] test_board = tictactoe.createBoard(3, 5);
        test_board[2][2] = 2;
        test_board[3][1] = 2;
        test_board[4][0] = 2;
        assertEquals(true, tictactoe.winInDiagonalFS(test_board, 2), "correct diagonal");
    }

    @Test
    @DisplayName("checking_winInDiagonalFS4")
    void checking_winInDiagonal4() {
        int[][] test_board = tictactoe.createBoard(4, 4);
        test_board[3][0] = 1;
        test_board[2][1] = 2;
        test_board[1][2] = 2;
        assertEquals(false, tictactoe.winInDiagonalFS(test_board, 1), "incorrect diagonal win");
    }

    // hint
    // checking if the recommended piece is in the correct spot, within the given
    // row, column or forward or backwards diagonals
    @Test
    @DisplayName("checking_hint1")
    void checking_hint1() {
        int[][] test_board = tictactoe.createBoard(3, 3);
        test_board[0][0] = 1;
        test_board[0][2] = 1;
        int[] result = { 0, 1 };
        assertArrayEquals(result, tictactoe.hint(test_board, 1), "Expected recommended piece is {0,1}");
    }

    @Test
    @DisplayName("checking_hint2")
    void checking_hint2() {
        int[][] test_board = tictactoe.createBoard(3, 3);
        test_board[2][0] = 2;
        test_board[0][2] = 2;
        int[] result = { 1, 1 };
        assertArrayEquals(result, tictactoe.hint(test_board, 2), "Expected recommended piece is {1,1}");
    }

    @Test
    @DisplayName("checking_hint3")
    void checking_hint3() {
        int[][] test_board = tictactoe.createBoard(4, 5);
        test_board[4][1] = 1;
        test_board[3][2] = 1;
        int[] result = { 2, 3 };
        assertArrayEquals(result, tictactoe.hint(test_board, 1), "Expected recommended piece is {2,3}");
    }

    @Test
    @DisplayName("checking_hint4")
    void checking_hint4() {
        int[][] test_board = tictactoe.createBoard(3, 4);
        test_board[1][2] = 1;
        test_board[3][2] = 1;
        int[] result = { -1, -1 };
        assertArrayEquals(result, tictactoe.hint(test_board, 1), "Expected recommended piece is {-1,-1}");
    }

    // factorial
    // checks if the factorial function is working correctly with multiple different
    // factorials ranging from sizes
    @Test
    @DisplayName("checking_factorial1")
    void checking_factorial1() {
        BigInteger A;
        A = BigInteger.valueOf(120);
        // BigInteger result = BigInteger.valueOf(5);
        assertEquals(A, tictactoe.factorial(5), "5! = 120");

    }

    @Test
    @DisplayName("checking_factorial2")
    void checking_factorial2() {
        BigInteger A;
        A = BigInteger.valueOf(3628800);
        // BigInteger result = BigInteger.valueOf(5);
        assertEquals(A, tictactoe.factorial(10), "10! = 3628800");
    }

    @Test
    @DisplayName("checking_factorial3")
    void checking_factorial3() {
        BigInteger A;
        A = BigInteger.valueOf(39916800);
        // BigInteger result = BigInteger.valueOf(5);
        assertEquals(A, tictactoe.factorial(11), "11! = 39916800");
    }

    @Test
    @DisplayName("checking_factorial4")
    void checking_factorial4() {
        BigInteger A;
        A = BigInteger.valueOf(40320);
        // BigInteger result = BigInteger.valueOf(5);
        assertEquals(A, tictactoe.factorial(8), "8! = 40320");
    }

    @Test
    @DisplayName("checking_factorial5")
    void checking_factorial5() {
        BigInteger A;
        A = BigInteger.valueOf(6);
        // BigInteger result = BigInteger.valueOf(5);
        assertEquals(A, tictactoe.factorial(3), "3! = 6");
    }

}