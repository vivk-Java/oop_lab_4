package oop.lab.MathExpression;

import java.util.Stack;

public class ParenthesesCheck {
    private static final Stack<Character> parentheses = new Stack<Character>();

    private static final Character[] open = { '(', '[', '{' };
    private static final Character[] close = { ')', ']', '}' };

    private static final Character ERROR_CHARACTER = '\0';

    public static boolean isExpression(String sourceString) {
        char[] source = sourceString.toCharArray();
        parentheses.clear();

        for (Character element : source) {
            Character containsOpen = contains(open, element);
            if (containsOpen != ERROR_CHARACTER) {
                parentheses.push(element);
            }

            Character containsClose = contains(close, element);
            if (containsClose != ERROR_CHARACTER) {
                if (parentheses.isEmpty()) {
                    return false;
                }

                Character open = parentheses.pop();
                if (open == '(') {
                    if (containsClose != ')') {
                        return false;
                    }
                } else if (open == '[') {
                    if (containsClose != ']') {
                        return false;
                    }
                } else if (open == '{') {
                    if (containsClose != '}') {
                        return false;
                    }
                }
            }
        }

        return parentheses.isEmpty();
    }

    private static Character contains(Object[] array, Object element) {
        for (Object object : array) {
            if (object == element)
                return (Character) element;
        }
        return ERROR_CHARACTER;
    }

}
