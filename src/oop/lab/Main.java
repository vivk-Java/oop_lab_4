package oop.lab;

import oop.lab.MathExpression.ParenthesesCheck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static final String sourcePath = "one_expression.txt";

    private static void println(Object object) {
        System.out.println(object.toString());
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> readStrings = new ArrayList<String>();
        File source = new File(sourcePath);
        Scanner scanner = new Scanner(source);

        while (scanner.hasNextLine()) {
            readStrings.add(scanner.nextLine());
        }

        for (String expression : readStrings) {
            println(expression + ": " +
                    ParenthesesCheck.isExpression(expression));
        }
    }
}
