import java.util.LinkedList;

public class Balanced_Brackets {
    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
    }

    public static String isBalanced(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '{':
                case '(':
                case '[':
                    stack.add(c);
                    size++;
                    break;
                case '}':
                    if (size == 0 || stack.peekLast() != '{') {
                        return "NO";
                    }
                    stack.removeLast();
                    size--;
                    break;
                    case ')':
                        if (size == 0 || stack.peekLast() != '(') {
                        return "NO";
                    }
                        stack.removeLast();
                        size--;
                        break;
                    case ']':
                        if (size == 0 || stack.peekLast() != '[') {
                            return "NO";
                        }
                        stack.removeLast();
                        size--;
                        break;
            }
        }
        return size == 0 ? "YES" : "NO";
    }
}