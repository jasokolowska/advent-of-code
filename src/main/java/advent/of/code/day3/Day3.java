package advent.of.code.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day3 {

    public static void main(String[] args) {
        File file = new File("C:\\Development\\Projects\\advent-of-code\\src\\main\\resources\\day-3\\input.txt");
        List<String> binaryNumbers = readFile(file);


//        getGammaAndEpsilon(binaryNumbers);
        int i = 0;

        while (binaryNumbers.size() > 1){
            int oneQuantity = 0;
            int zeroQuantity = 0;
            for (String binaryNumber : binaryNumbers) {

                if (binaryNumber.charAt(i) == 49) {
                    oneQuantity += 1;
                } else {
                    zeroQuantity += 1;
                }
            }

            if (oneQuantity < zeroQuantity) {
                int finalI = i;
                binaryNumbers.removeIf(number -> number.charAt(finalI) == 48);
            } else {
                int finalI = i;
                binaryNumbers.removeIf(number -> number.charAt(finalI) == 49);
            }
            i++;
        }
        System.out.println("binaryNumbers: " + binaryNumbers);
        int nbr1;
        nbr1 = Integer.parseInt("000100011010", 2);
        int nbr2 = Integer.parseInt(binaryNumbers.get(0), 2);
        System.out.println(nbr1*nbr2);
    }


    private static void getGammaAndEpsilon(List<String> binaryNumbers) {
        //        String gamma = "";
//        String epsilon = "";

        for (int i = 0; i < binaryNumbers.get(0).length(); i++) {
            int oneQuantity = 0;
            int zeroQuantity = 0;
            for (String binaryNumber : binaryNumbers) {

                if (binaryNumber.charAt(i) == 49) {
//                    System.out.println("binaryNumber.charAt(i) == " + binaryNumber.charAt(i));
                    oneQuantity += 1;
                } else {
                    zeroQuantity += 1;
                }
            }
            System.out.println("one quantity: " + oneQuantity);
            System.out.println("zero quantity: " + zeroQuantity);
            if (oneQuantity > zeroQuantity) {
//                gamma += "1";
//                epsilon += "0";


            } else {
//                gamma += "0";
//                epsilon += "1";
            }
        }
//        System.out.println("Gamma = " + gamma + "/" + Integer.parseInt(gamma, 2)
//                + "\nEpsilon = " + epsilon + "/" + Integer.parseInt(epsilon, 2));

//        System.out.println("Multiplication: " + Integer.parseInt(gamma, 2)*Integer.parseInt(epsilon, 2));
    }

    private static List<String> readFile(File file) {

        List<String> binaryNumbers = new LinkedList<>();
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                binaryNumbers.add(nextLine);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return binaryNumbers;
    }
}
