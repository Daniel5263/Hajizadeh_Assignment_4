import java.util.*;

public class Infex_to_Postfix {
    static int Prec(char ch) {
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

    static Queue<Character> infixToPostfix(String exp) {
        Queue<Character> result = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c))
                result.add(c);
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.add(stack.pop());

                if (!stack.isEmpty() && stack.peek() != '(')
                    return null; // invalid expression
                else
                    stack.pop();
            } else {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                    result.add(stack.pop());
                stack.push(c);
            }
        }

        while (!stack.isEmpty())
            result.add(stack.pop());

        return result;
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        Queue<Character> postfix = infixToPostfix(exp);
        while (!postfix.isEmpty()) {
            System.out.print(postfix.poll());
        }
    }
}
