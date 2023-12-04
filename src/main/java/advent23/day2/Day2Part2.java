package advent23.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Part2 {
    public static void main (String[] args) {
        int sum = 0;
        int minRed = 0;
        int minGreen = 0;
        int minBlue = 0;
        try {
            File input = new File("./src/main/java/advent23/day2/input.txt");
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] lineSplit = line.split(":");
                String[] pulls = lineSplit[1].split(";");
                for (String pull : pulls) {
                    String[] colours = pull.split(",");
                    for (String colour : colours) {
                        String[] colourSplit = colour.split(" ");
                        if (colour.contains("red") && Integer.parseInt(colourSplit[1]) > minRed) {
                            minRed = Integer.parseInt(colourSplit[1]);
                        }
                        if (colour.contains("green") && Integer.parseInt(colourSplit[1]) > minGreen) {
                            minGreen =Integer.parseInt(colourSplit[1]);
                        }
                        if (colour.contains("blue") && Integer.parseInt(colourSplit[1]) > minBlue) {
                            minBlue = Integer.parseInt(colourSplit[1]);
                        }
                    }
                }
                sum += (minRed * minGreen * minBlue);
                minRed = 0;
                minGreen = 0;
                minBlue = 0;
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("Could not read file");
        }
    }
}
