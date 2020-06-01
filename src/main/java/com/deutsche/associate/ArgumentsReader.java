package com.deutsche.associate;

import java.util.Scanner;

public class ArgumentsReader {
    public static void main(String[] args) {


        System.out.println("=======Interactive Drawing Tool=======");
        Scanner scanner = new Scanner(System.in);

        ArgumentProcessor parser = new ArgumentProcessor();
        System.out.println("enter command: ");
        while (scanner.hasNextLine()) {

            String input = scanner.nextLine().trim();
            String[] inputArray = input.split("\\s+");
            try {
                parser.process(inputArray);
                Canvas canvas = parser.getCanvas();
                if (canvas != null) {
                    canvas.render();
                    System.out.println("enter command: ");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


}
