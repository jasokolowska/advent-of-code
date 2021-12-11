package advent.of.code.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Day2 {
    public static void main(String[] args) {
        File file = new File("C:\\Development\\Projects\\advent-of-code\\src\\main\\resources\\day-2\\input.txt");
        int depth = 0;
        int horizontal = 0;
        int aim = 0;

        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                String[] input = nextLine.split(" ");
                String direction = input[0];
                int distance = Integer.valueOf(input[1]);
                switch (direction) {
                    case "forward":
                        horizontal += distance;
                        depth += (aim*distance);
                        break;
                    case "up":
                        aim -= distance;
                        break;
                    case "down":
                        aim += distance;
                        break;
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        System.out.println("Depth: " + depth + "\nHorizontal: " + horizontal);
        System.out.println("Multiplication: " + depth*horizontal);

    }
}
