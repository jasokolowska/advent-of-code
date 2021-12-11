package advent.of.code.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Day6 {
    public static void main(String[] args) {
        File file = new File("C:\\Development\\Projects\\advent-of-code\\src\\main\\resources\\day-6\\sample.txt");
        List<Integer> initialQuantity = readFile(file);

        int days = 0;
        int size = initialQuantity.size();

        while (days < 256) {
            for (int i = 0; i < size; i++) {
                if (initialQuantity.get(i) > 0) {
                    int currentValue = initialQuantity.get(i);
                    initialQuantity.set(i, currentValue-1);
                } else {
                    initialQuantity.set(i, 6);
                    initialQuantity.add(9);
                    size++;
                }
            }

            days++;
        }

        System.out.println("Size: " + initialQuantity.size());
    }

    private static List<Integer> readFile(File file) {
        List<Integer> inputData = new LinkedList<>();

        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                String[] row = nextLine.split(",");
                for (String number : row) {
                    inputData.add(Integer.parseInt(number));
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return inputData;
    }
}
