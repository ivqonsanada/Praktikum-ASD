package Praktikum7;

import java.util.EmptyStackException;

public class Stack {

    private Node head, tail, top;
    private String rest;

    public Stack() {
        head = tail = top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object dataPop = top.data;
        removeLast();
        top = tail;
        return dataPop;
    }

    private void removeLast() {
        Node temp = head;
        if (!isEmpty()) {
            if (tail == head) {
                head = tail = null;
            } else {
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                temp = null;
            }
        }
    }

    int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    String infixToPostfix(String exp) {
        String result = new String("");

        Stack stack = new Stack();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && !"(".equals(stack.peek().toString())) {
                    result += stack.pop();
                }

                if (!stack.isEmpty() && !"(".equals(stack.peek().toString())) {
                    return "Invalid Expression";
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && Prec(c) <= Prec((char) stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public int countIn2Post(String exp) {
        Stack stack = new Stack();
        // Scan all characters one by one 
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If the scanned character is an operand (number here), 
            // push it to the stack. 
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } // If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else {
                int val1 = (int) stack.pop();
                int val2 = (int) stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        stack.push(val2 - val1);
                        break;

                    case '/':
                        stack.push(val2 / val1);
                        break;

                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return (int) stack.pop();
    }

    public String infixToPrefix(String exp) {
        int l = exp.length();
        String[] test = new String[l];
        String[] rev = new String[l];
        for (int i = 0; i < l; i++) {
            test[i] = exp.substring(i, i + 1);
        }
        for (int i = 0; i < rev.length; i++) {
            rev[i] = test[l - i - 1];
        }

        for (int i = 0; i < l; i++) {

            if ("(".equals(rev[i])) {
                rev[i] = ")";
                i++;
            } else if (")".equals(rev[i])) {
                rev[i] = "(";
                i++;
            }
        }
        String val = "";
        for (int i = 0; i < rev.length; i++) {
            val += rev[i];
        }
        String prefix = infixToPostfix(val);

        for (int i = 0; i < prefix.length(); i++) {
            val += prefix.substring(prefix.length() - i - 1, prefix.length() - i);
        }
        return prefix;
    }

    public void push(Object dt) {
        addLast(dt);
        top = tail;
    }

    private void addLast(Object dt) {
        Node newNode = new Node(dt);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Object peek() {
        return top.data;
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + "<-");
            pointer = pointer.next;
        }
        System.out.println("");
    }
}
