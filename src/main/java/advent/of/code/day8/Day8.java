package advent.of.code.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Day8 {
    public static void main(String[] args) {
        File file = new File("C:\\Development\\Projects\\advent-of-code\\src\\main\\resources\\day-8\\input.txt");
        Map<String, String> signals = reaFile(file);

        int one = 0;
        int four = 0;
        int seven = 0;
        int eight = 0;

        for (Map.Entry<String, String> entry : signals.entrySet()) {
            String[] number = entry.getValue().split(" ");
            for (String s : number) {
                switch (s.length()) {
                    case 2 -> one += 1;
                    case 4 -> four += 1;
                    case 3 -> seven += 1;
                    case 7 -> eight += 1;
                }
            }
        }


        int sum = one + four + seven + eight;
        System.out.println("Suma: " + sum);
    }

    private static Map<String, String> reaFile(File file) {
        Map<String, String> lines = new LinkedHashMap<>();
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                lines.put(nextLine.split(Pattern.quote ("|"))[0],
                        nextLine.split(Pattern.quote ("|"))[1]) ;
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
