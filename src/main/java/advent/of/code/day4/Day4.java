package advent.of.code.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day4 {

    public static void main(String[] args) {
        File file = new File("C:\\Development\\Projects\\advent-of-code\\src\\main\\resources\\day-4\\input.txt");
        List<Integer> numbers = List.of(67, 31, 58, 8, 79, 18, 19, 45, 38, 13, 40, 62, 85, 10, 21, 96, 56, 55, 4, 36, 76, 42, 32, 34, 39, 89, 6, 12, 24, 57, 93, 47, 41, 52, 83, 61, 5, 37, 28, 15, 86, 23, 69, 92, 70, 27, 25, 53, 44, 80, 65, 22, 99, 43, 66, 26, 11, 72, 2, 98, 14, 82, 87, 20, 73, 46, 35, 7, 1, 84, 95, 74, 81, 63, 78, 94, 16, 60, 29, 97, 91, 30, 17, 54, 68, 90, 71, 88, 77, 9, 64, 50, 0, 49, 48, 75, 3, 59, 51, 33);
        List<String> boardsRaw = readFile(file);
        List<Integer[][]> boards = fillBoardsFromFile(boardsRaw);
        Map<Integer, Integer[][]> winningBoards = new LinkedHashMap<>();

//        outerloop:
        while (boards.size() > 0) {
            for (Integer number : numbers) {
                boards = remainingBoards(boards);
                for (Integer[][] board : boards) {
                    int i = 0;
                    for (Integer[] row : board) {
                        int j = 0;
                        for (Integer integer : row) {
                            System.out.println("checking integer: " + integer);
                            if (integer == number) {
                                board[i][j] = null;
//                                printBoard(board);
                                winningBoards.put(number, board);
                            }
                            j++;
                        }
                        i++;
                    }

                }
//                if (checkBoard(board)) {
//                    System.out.println("Index of winning board: " + boards.indexOf(board) + "\nLast number: " + number);
//                    System.out.println("Sum: " + getBoardSum(board));
//
////                                    boards.remove(board);
//                    break;
//                }
            }
        }
        printWinningBoards(winningBoards);
    }

    private static List<Integer[][]> remainingBoards(List<Integer[][]> boards) {
        return boards.stream()
                .filter(board -> !checkBoard(board))
                .collect(Collectors.toList());
    }

    private static void printWinningBoards(Map<Integer, Integer[][]> winningBoards) {
        winningBoards.entrySet().stream()
                .forEach(entry -> {
                    System.out.println("Number: " + entry.getKey());
                    printBoard(entry.getValue());
                });
    }

    private static int getBoardSum(Integer[][] board) {
        int sum = 0;
        for (Integer[] row : board) {
            for (Integer integer : row) {
                if (integer != null) {
                    sum += integer;
                }
            }
        }
        return sum;
    }

    private static void printBoard(Integer[][] board) {
        for (Integer[] row : board) {
            for (Integer integer : row) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static boolean checkBoard(Integer[][] board) {
        for (Integer[] row : board) {
            int counter = 0;
            for (Integer integer : row) {
                if (integer == null) {
                    counter++;
                }
            }
            if (counter == 5) {
                return true;
            }
        }

        for (int i = 0; i < board.length; i++) {
            int counter = 0;
            for (int j = 0; j < board[i].length; j++) {
                if(board[j][i] == null){
                    counter++;
                }
            }
            if (counter == 5) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer[][]> fillBoardsFromFile(List<String> boardsRaw) {
        List<Integer[][]> boards = new LinkedList<>();


        Integer[][] board = new Integer[5][5];

        for (int i = 0; i < boardsRaw.size(); i++) {
            if (!boardsRaw.get(i).equals("")) {
                int index = i % 6;
                List<String> row = Arrays.stream(boardsRaw.get(i).split(" "))
                        .filter(input -> !input.equals(""))
                        .toList();
//                    Arrays.stream(row)
//                            .forEach(nbr -> System.out.print(nbr + " "));
                for (int j = 0; j < 5; j++) {
                    if (!row.get(j).equals("")) {
                        board[index][j] = Integer.parseInt(row.get(j));
                    }
                }
                if (board[4][4] != null) {
                    boards.add(board);
                    board = new Integer[5][5];
                }
            }
        }
        return boards;
    }

    private static void printBoards(List<Integer[][]> boards) {
        for (Integer[][] integers : boards) {
            for (Integer[] integer : integers) {
                for (Integer integer1 : integer) {
                    if (integer1 == null) {
                        System.out.print("X ");
                    } else {
                        System.out.print(integer1 + " ");
                    }
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }

    private static List<String> readFile(File file) {
        List<String> boardsRaw = new ArrayList<>();

        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                boardsRaw.add(nextLine);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return boardsRaw;
    }
}
