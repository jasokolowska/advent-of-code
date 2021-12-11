package advent.of.code.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Development\\Projects\\advent-of-code\\src\\main\\resources\\day-1\\input.txt");
        int counter = 0;
        List<Integer> numberList = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();

        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                numberList.add(Integer.valueOf(nextLine));
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < numberList.size()-2; i++) {
            sumList.add(numberList.get(i)+ numberList.get(i+1) + numberList.get(i+2));
        }
        System.out.println(countIncreased(sumList) + " sum measurements are larger than the previous sum measurement");
//        System.out.println(countIncreased(numberList) + " measurements are larger than the previous measurement");


    }

    public static int countIncreased(List<Integer> numbers) {
        int prevValue = 0;
        int nextValue;
        int counter = 0;

        for (Integer number : numbers) {
            nextValue = number;
            System.out.print(nextValue);
            if (prevValue < nextValue) {
                counter++;
                System.out.println(" (increased)");
            } else {
                System.out.println(" (decreased)");
            }

            prevValue = nextValue;
        }
        return counter;
    }
}
