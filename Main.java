import java.util.Scanner;

public class Main{
    static char[] board = {'0','1','2','3','4','5','6','7','8'}; // show positions initially

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        int moves = 0;

        System.out.println("Welcome to Tic Tac Toe with Scoring!");

        while (moves < 9) { // play until board is full
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter position (0 to 8): ");
            int pos = sc.nextInt();

            // validate move
            if (pos < 0 || pos > 8) {
                System.out.println("Invalid position! Try again.");
                continue;
            }
            if (board[pos] == 'X' || board[pos] == 'O') {
                System.out.println("That cell is already taken. Try again.");
                continue;
            }

            // place mark
            board[pos] = currentPlayer;
            moves++;

            // switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        // game over → calculate scores
        printBoard();
        int scoreX = calculateScore('X');
        int scoreO = calculateScore('O');

        System.out.println("Final Scores:");
        System.out.println("Player X: " + scoreX);
        System.out.println("Player O: " + scoreO);

        if (scoreX > scoreO) {
            System.out.println("---- Player X wins!----");
        } else if (scoreO > scoreX) {
            System.out.println("---- Player O wins!----");
        } else {
            System.out.println("---- It's a draw! ----");
        }

        sc.close();
    }

    // pretty print board
    static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    // calculate score
    static int calculateScore(char player) {
        int score = 0;

        // rows
        if (board[0] == player && board[1] == player && board[2] == player) score++;
        if (board[3] == player && board[4] == player && board[5] == player) score++;
        if (board[6] == player && board[7] == player && board[8] == player) score++;

        // cols
        if (board[0] == player && board[3] == player && board[6] == player) score++;
        if (board[1] == player && board[4] == player && board[7] == player) score++;
        if (board[2] == player && board[5] == player && board[8] == player) score++;
 // diagonals
        if (board[0] == player && board[4] == player && board[8] == player) score++;
        if (board[2] == player && board[4] == player && board[6] == player) score++;

        return score;
    }
}