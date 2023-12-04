package advent23.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Part1 {
    public static void main(String[] args) {
        try {
            int sum = 0;
            int id = 0;
            File input = new File("./src/main/java/advent23/day2/input.txt");
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                id++;
                String line = scanner.nextLine();
                String[] lineSplit = line.split(":");
                    if (isAcceptableGame(lineSplit[1])) {
                        System.out.println(isAcceptableGame(lineSplit[1]));
                        sum += id;
                    }
                }

            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("Could not read file");
        }
    }

    private static boolean isAcceptableGame(String game) {
        int red = 12;
        int green = 13;
        int blue = 14;
        String[] pulls = game.split(";");
        for (String pull : pulls) {
            String[] colours = pull.split(",");
            for (String colour : colours) {
                String[] colourSplit = colour.split(" ");
                if (colour.contains("red") && Integer.parseInt(colourSplit[1]) > red) {
                    return false;
                }
                if (colour.contains("green") && Integer.parseInt(colourSplit[1]) > green) {
                    return false;
                }
                if (colour.contains("blue") && Integer.parseInt(colourSplit[1]) > blue) {
                    return false;
                }
            }
        }
        return true;
    }
}
//4*2*6
