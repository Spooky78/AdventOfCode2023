package advent23.day1;

import java.io.*;
import java.util.*;

public class Day1Part2 {
    public static void main(String[] args) {
        try {
            int sum = 0;
            File input = new File("./src/main/java/advent23/day1/input.txt");
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replace("one", "o1e");
                line = line.replace("two", "t2o");
                line = line.replace("three", "t3e");
                line = line.replace("four", "f4e");
                line = line.replace("five", "f5e");
                line = line.replace("six", "s6x");
                line = line.replace("seven", "s7n");
                line = line.replace("eight", "e8t");
                line = line.replace("nine", "n9e");

                String clean = line.replaceAll("\\D+","");
                System.out.println(clean);
                char firstChar = clean.charAt(0);
                char lastChar = clean.charAt(clean.length() - 1);
                String contcatChar = firstChar + "" + lastChar;
                int finalInt = Integer.parseInt(contcatChar);
                sum += finalInt;
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't read file");
            e.printStackTrace();
        }
    }

}
