package advent23.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3Part2 {
    static String aboveLine;
    static String middleLine;
    static String belowLine;
    static String aboveLineFormat;
    static String middleLineFormat;
    static String belowLineFormat;
    static ArrayList<String> allLines = new ArrayList<>();
    static ArrayList<String> allLinesFormat = new ArrayList<>();
    public static void main (String[] args) {
        int sum = 0;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;
        try {
            File input = new File("./src/main/java/advent23/day3/inputTest.txt");
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                String currentLine = scanner.nextLine();
                allLines.add(currentLine);
                currentLine = currentLine.replace(".", "D");
                String currentLineFormat = "";
                for (int i = 0; i < currentLine.length(); i++) {
                    if (Character.isDigit(currentLine.charAt(i))) {
                        currentLineFormat = currentLineFormat + "N";
                    } else if (currentLine.charAt(i) == '*') {
                        currentLineFormat = currentLineFormat + "A";
                    }else if (!Character.isAlphabetic(currentLine.charAt(i))) {
                        currentLineFormat = currentLineFormat + "S";
                    } else {
                        currentLineFormat = currentLineFormat + "D";
                    }
                }
                allLinesFormat.add(currentLineFormat);
            }
//            for (String lineFormat : allLinesFormat) {
//                System.out.println(lineFormat);
//            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read file");
        }

        for (int i = 0; i < allLinesFormat.size() + 1; i++) {
            //middle line is only possible when below line is at least 2nd line
            if (!((i - 1) < 0)) {
                if (!((i - 2) < 0)) {
                    aboveLine = allLines.get(i - 2);
                    aboveLineFormat = allLinesFormat.get(i - 2);
                }
                middleLine = allLines.get(i - 1);
                middleLineFormat = allLinesFormat.get(i - 1);
                if (i < allLinesFormat.size()) {
                    belowLine = allLines.get(i);
                    belowLineFormat = allLinesFormat.get(i);
                }

                for (int j = 0; j < allLines.get(0).length(); j++) {
                    String currentNum1 = "";
                    String currentNum2 = "";
                    boolean found = false;
                    if (middleLineFormat.charAt(j) == 'A') {
                        if (j-1 >=0 && middleLineFormat.charAt(j-1) == 'N') {
                            int z = j - 1;
                            while (z >= 0 && middleLineFormat.charAt(z) == 'N') {
                                currentNum1 = middleLine.charAt(z) + currentNum1;
                                z--;
                            }
                        }
                        if (j < middleLine.length() && middleLineFormat.charAt(j+1) == 'N') {
                            int z = j + 1;
                            String currentNum = "";
                            while (middleLineFormat.charAt(z) == 'N') {
                                currentNum = currentNum + middleLine.charAt(z);
                                z++;
                            }
                            if (currentNum1.isEmpty()) {
                                currentNum1 = currentNum;
                            } else {
                                currentNum2 = currentNum;
                            }
                            if (!currentNum1.isEmpty() && !currentNum2.isEmpty()) {
                                int num1 = Integer.parseInt(currentNum1);
                                int num2 = Integer.parseInt(currentNum2);
                                sum1 += (num1 * num2);
                            }
                        }
                        boolean foundAbove = false;
                        int q = j-1;
                        while (!foundAbove && q <= j+1) {
                            if (q >= 0 && aboveLineFormat.charAt(q) == 'N') {
                                int z = q;
                                String currentNum = "";
                                while (z >= 0 && aboveLineFormat.charAt(z) == 'N') {
                                    currentNum = aboveLine.charAt(z) + currentNum;
                                    z--;
                                }
                                z = q + 1;
                                while (z < middleLine.length() && aboveLineFormat.charAt(z) == 'N') {
                                    currentNum = currentNum + aboveLine.charAt(z);
                                    z++;
                                }
                                if (currentNum1.isEmpty()) {
                                    currentNum1 = currentNum;
                                } else {
                                    currentNum2 = currentNum;
                                }
                                foundAbove = true;
                                if (!currentNum1.isEmpty() && !currentNum2.isEmpty()) {
                                    int num1 = Integer.parseInt(currentNum1);
                                    int num2 = Integer.parseInt(currentNum2);
                                    sum3 += (num1 * num2);
                                }
                            }
                            q++;
                        }
                        boolean foundBelow = false;
                        q = j-1;
                        while (!foundBelow && q <= j+1) {
                            if (q >= 0 && belowLineFormat.charAt(q) == 'N') {
                                int z = q;
                                String currentNum = "";
                                while (z >= 0 && belowLineFormat.charAt(z) == 'N') {
                                    currentNum = belowLine.charAt(z) + currentNum;
                                    z--;
                                }
                                z = q + 1;
                                while (z < middleLine.length() && belowLineFormat.charAt(z) == 'N') {
                                    currentNum = currentNum + belowLine.charAt(z);
                                    z++;
                                }
                                if (currentNum1.isEmpty()) {
                                    currentNum1 = currentNum;
                                } else {
                                    currentNum2 = currentNum;
                                }
                                foundBelow = true;
                                if (!currentNum1.isEmpty() && !currentNum2.isEmpty()) {
                                    found = true;
                                }
                            }
                            q++;
                        }
                    }
                    if (!currentNum1.isEmpty() && !currentNum2.isEmpty()) {
                        int num1 = Integer.parseInt(currentNum1);
                        int num2 = Integer.parseInt(currentNum2);
                        sum += (num1 * num2);
                    }
                }
            }
        }
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
        System.out.println(sum);
    }
}
