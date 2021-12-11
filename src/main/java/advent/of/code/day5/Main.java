package advent.of.code.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Development\\Projects\\advent-of-code\\src\\main\\resources\\day-5\\input.txt");
        List<String> inputData = readFile(file);
        Board board = new Board(1000, 1000);

        List<Line> lines = inputData.stream()
                .map(data -> data.split("\\D"))
                .filter(array -> Integer.parseInt(array[0]) == Integer.parseInt(array[5]) ||
                        Integer.parseInt(array[1]) == Integer.parseInt(array[6]) ||
                        (Integer.parseInt(array[0]) - Integer.parseInt(array[5]) == Integer.parseInt(array[1]) - Integer.parseInt(array[6])) ||
                        (Integer.parseInt(array[0]) + Integer.parseInt(array[1]) ==Integer.parseInt(array[5]) + Integer.parseInt(array[6])))
                .map(array -> new Line(
                        new Point(Integer.parseInt(array[0]), Integer.parseInt(array[1])),
                        new Point(Integer.parseInt(array[5]), Integer.parseInt(array[6]))))
                .collect(Collectors.toList());

//        System.out.println(lines);

        for (Line line : lines) {
            board.drawLineOnBoard(line);
        }

//        board.drawLineOnBoard(lines.get(0));
//        board.drawLineOnBoard(new Line(new Point(402,500), new Point (402,400)));

        long numberOfDangerousPoints = board.getBoard().stream()
                .flatMap(Collection::stream)
                .filter(number -> number > 1)
                .count();

        System.out.println("Number of dangerous points " + numberOfDangerousPoints);
//        System.out.println(board);

    }

    private static List<String> readFile(File file) {
        List<String> inputData = new ArrayList<>();

        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                inputData.add(nextLine);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return inputData;
    }
}
