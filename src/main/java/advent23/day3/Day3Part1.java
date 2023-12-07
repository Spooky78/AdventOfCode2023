package advent23.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3Part1 {
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
        try {
            File input = new File("./src/main/java/advent23/day3/input.txt");
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                String currentLine = scanner.nextLine();
                allLines.add(currentLine);
                currentLine= currentLine.replace(".", "D");
                String currentLineFormat = "";
                for (int i = 0; i < currentLine.length(); i++) {
                    if (Character.isDigit(currentLine.charAt(i))) {
                        currentLineFormat = currentLineFormat + "N";
                    } else if (!Character.isAlphabetic(currentLine.charAt(i))) {
                        currentLineFormat = currentLineFormat + "S";
                    } else {
                        currentLineFormat = currentLineFormat + "D";
                    }
                }
                allLinesFormat.add(currentLineFormat);
            }
            for (String lineFormat : allLinesFormat) {
                System.out.println(lineFormat);
            }
            for (int i = 0; i < allLinesFormat.size() + 1; i++) {
                //middle line is only possible when below line is at least 2nd line
                if (!((i-1) < 0)) {
                    if (!((i-2) < 0)) {
                        aboveLine = allLines.get(i-2);
                        aboveLineFormat = allLinesFormat.get(i-2);
                    }
                    middleLine = allLines.get(i-1);
                    middleLineFormat = allLinesFormat.get(i-1);
                    if (i < allLinesFormat.size()) {
                        belowLine = allLines.get(i);
                        belowLineFormat = allLinesFormat.get(i);
                    }

                    for (int j = 0; j < allLines.get(0).length(); j++) {
                        ArrayList<Character> currentNumFormat = new ArrayList<>();
                        String currentNum = "";
                        if (middleLineFormat.charAt(j) == 'N') {
                            int currentNumEnd = j;
                            while (currentNumEnd < middleLine.length() && middleLineFormat.charAt(currentNumEnd)== 'N') {
                                currentNum = currentNum + (middleLine.charAt(currentNumEnd));
                                currentNumFormat.add(middleLine.charAt(currentNumEnd));
                                currentNumEnd++;
                            }
                            if (isNumPartSameLine(j, currentNumEnd)) {
                                int num = Integer.parseInt(currentNum);
                                sum += num;
                            } else if (isNumPartBelowLine(j, currentNumEnd )) {
                                int num = Integer.parseInt(currentNum);
                                sum += num;
                            } else if (!((i-2) < 0) && isNumPartAboveLine(j, currentNumEnd)) {
                                int num = Integer.parseInt(currentNum);
                                sum += num;
                            }
                            j = currentNumEnd;
                        }
                        currentNumFormat.clear();
                    }
                }
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("Could not read file");
        }
    }

    private static boolean isNumPartSameLine(int numStart, int numEnd) {
        if (numStart > 0 && middleLineFormat.charAt(numStart - 1) == 'S') {
            return true;
        } else if (numEnd < middleLine.length() && middleLineFormat.charAt(numEnd) == 'S') {
            return true;
        }
        return false;
    }

    private static boolean isNumPartBelowLine(int numStart, int numEnd) {
        if (numStart > 0 && belowLineFormat.charAt(numStart - 1) == 'S') {
            return true;
        } else if (numEnd < belowLine.length() && belowLineFormat.charAt(numEnd) == 'S') {
            return true;
        }
        for (int i = numStart; i < numEnd; i++) {
            if (belowLineFormat.charAt(i) == 'S') {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumPartAboveLine(int numStart, int numEnd) {
        if (numStart > 0 && aboveLineFormat.charAt(numStart - 1) == 'S') {
            return true;
        } else if (numEnd < aboveLine.length() && aboveLineFormat.charAt(numEnd) == 'S') {
            return true;
        }
        for (int i = numStart; i < numEnd; i++) {
            if (aboveLineFormat.charAt(i) == 'S') {
                return true;
            }
        }
        return false;
    }
}
