package dev.xfj.gi.gacha.simulator;

import java.util.Scanner;

import static java.lang.String.format;

public class Main {
    private static boolean running = false;

    public static void main(String[] args) {
        running = true;
        System.out.println("Roll a single or a 10 pull");
        System.out.println("/single");
        System.out.println("/multi");
        System.out.println("/pity");
        System.out.println("/q to exit");

        Gacha gacha = new Gacha();
        Scanner scanner = new Scanner(System.in);

        while (running) {
            String[] command = scanner.nextLine().split(" ");

            if (command[0].startsWith("/")) {
                switch (command[0]) {
                    case "/single" -> System.out.println(format("Rolled: %s", gacha.rollSingle()));
                    case "/multi" -> System.out.println(format(
                            "Rolled:\n%s", String.join("\n", gacha.rollMulti()))
                    );
                    case "/pity" -> System.out.println(format(
                            "5 Star Pity: %s\n4 Star Pity: %s",
                            gacha.getPityCounter5Star(),
                            gacha.getPityCounter4Star()
                    ));
                    case "/q" -> running = false;
                    default -> System.err.println("Not a valid command");
                }
            } else {
                System.err.println("Command needs to start with /");
            }
        }
    }
}