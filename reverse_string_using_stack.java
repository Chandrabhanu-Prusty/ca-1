import java.util.*;

class StackADT {
    private char[] stack;
    private int top;
    private int capacity;

    public StackADT(int cap) {
        capacity = cap;
        stack = new char[capacity];
        top = -1;
    }

    public void push(char c) {
        if (top == capacity - 1) return; // Overflow not expected here
        stack[++top] = c;
    }

    public char pop() {
        if (isEmpty()) return '\0';
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StackADT st = new StackADT(s.length());

        // Push each character
        for (char c : s.toCharArray()) {
            st.push(c);
        }

        // Pop all to reverse
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        System.out.println(sb.toString());
    }
}
