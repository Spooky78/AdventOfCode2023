package advent23.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Part1 {
    public static void main(String[] args) {
        try {
            int sum = 0;
            File input = new File("./src/main/java/advent23/day1/input.txt");
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String clean = line.replaceAll("\\D+","");
                char firstChar = clean.charAt(0);
                char lastChar = clean.charAt(clean.length() - 1);
                String contcatChar = firstChar + "" + lastChar;
                int finalInt = Integer.parseInt(contcatChar);
                sum += finalInt;
                System.out.println(finalInt);
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't read file");
            e.printStackTrace();
        }
    }
}