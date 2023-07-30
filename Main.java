import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] board = new String[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = " ";
            }
        }
        System.out.println("---------");
        for (String[] item : board) {
            System.out.print("| ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(item[j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        int numberOfEmptyCells = 9;
        int numberOfXRows = 0;
        int numberOfORows = 0;
        int YCoordinate = 0;
        int XCoordinate = 0;
        String currentSymbol = "X";
        boolean gameFinished = false;
        while (!gameFinished) {
            System.out.println("Enter the coordinates: ");
            if (scanner.hasNextInt()) {
                YCoordinate = scanner.nextInt();
            } else {
                System.out.println("You should enter numbers!");
            }
            if (scanner.hasNextInt()) {
                XCoordinate = scanner.nextInt();
            } else {
                System.out.println("You should enter numbers!");
            }
            if (YCoordinate > 3 || XCoordinate > 3 || YCoordinate < 1 || XCoordinate < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (board[YCoordinate - 1][XCoordinate - 1].equalsIgnoreCase("X") || board[YCoordinate - 1][XCoordinate - 1].equalsIgnoreCase("O")) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                board[YCoordinate - 1][XCoordinate - 1] = currentSymbol;
                numberOfEmptyCells = numberOfEmptyCells - 1;
                if (currentSymbol.equalsIgnoreCase("X")) {
                    currentSymbol = "O";
                } else {
                    currentSymbol = "X";
                }
            }
            System.out.println("---------");
            for (String[] item : board) {
                System.out.print("| ");
                for (int j = 0; j < board.length; j++) {
                    System.out.print(item[j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");
            for (String[] value : board) {
                if (value[0].equalsIgnoreCase("X") && value[1].equalsIgnoreCase("X") && value[2].equalsIgnoreCase("X")) {
                    numberOfXRows = numberOfXRows + 1;
                }
            }
            for (int i = 0; i < board.length; i++) {
                if (board[0][i].equalsIgnoreCase("X") && board[1][i].equalsIgnoreCase("X") && board[2][i].equalsIgnoreCase("X")) {
                    numberOfXRows = numberOfXRows + 1;
                }
            }
            if (board[0][0].equalsIgnoreCase("X") && board[1][1].equalsIgnoreCase("X") && board[2][2].equalsIgnoreCase("X")) {
                numberOfXRows = numberOfXRows + 1;
            }
            if (board[0][2].equalsIgnoreCase("X") && board[1][1].equalsIgnoreCase("X") && board[2][0].equalsIgnoreCase("X")) {
                numberOfXRows = numberOfXRows + 1;
            }
            for (String[] strings : board) {
                if (strings[0].equalsIgnoreCase("O") && strings[1].equalsIgnoreCase("O") && strings[2].equalsIgnoreCase("O")) {
                    numberOfORows = numberOfORows + 1;
                }
            }
            for (int i = 0; i < board.length; i++) {
                if (board[0][i].equalsIgnoreCase("O") && board[1][i].equalsIgnoreCase("O") && board[2][i].equalsIgnoreCase("O")) {
                    numberOfORows = numberOfORows + 1;
                }
            }
            if (board[0][0].equalsIgnoreCase("O") && board[1][1].equalsIgnoreCase("O") && board[2][2].equalsIgnoreCase("O")) {
                numberOfORows = numberOfORows + 1;
            }
            if (board[0][2].equalsIgnoreCase("O") && board[1][1].equalsIgnoreCase("O") && board[2][0].equalsIgnoreCase("O")) {
                numberOfORows = numberOfORows + 1;
            }
            if (numberOfXRows == 0 && numberOfORows == 0 && numberOfEmptyCells == 0) {
                System.out.println("Draw");
                gameFinished = true;
            } else if (numberOfXRows == 1) {
                System.out.println("X wins");
                gameFinished = true;
            } else if (numberOfORows == 1) {
                System.out.println("O wins");
                gameFinished = true;
            }
        }
    }
}
