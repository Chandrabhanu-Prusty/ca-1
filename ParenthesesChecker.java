import java.util.Scanner;

// Stack ADT Implementation
class Stack {
    private char[] arr;
    private int top;
    private int capacity;

    public Stack(int size) {
        arr = new char[size];
        capacity = size;
        top = -1;
    }

    public void push(char c) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = c;
    }

    public char pop() {
        if (isEmpty()) {
            return '\0'; // special char to indicate error
        }
        return arr[top--];
    }

    public char peek() {
        if (isEmpty()) {
            return '\0';
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class ParenthesesChecker {
    // function to check matching brackets
    public static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static boolean checkBalanced(String expr) {
        Stack stack = new Stack(expr.length());

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            // if opening bracket, push it
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // if closing bracket, pop and check
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; // no opening bracket
                } else if (!isMatchingPair(stack.pop(), ch)) {
                    return false; // mismatch
                }
            }
        }

        // at end, stack must be empty
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();

        if (checkBalanced(expr)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
