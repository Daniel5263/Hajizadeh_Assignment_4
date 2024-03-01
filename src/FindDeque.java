import java.util.Deque;
import java.util.LinkedList;

public class FindDeque {
    public static void main(String[] args) {
        Deque<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        int x = 6;
        System.out.println(findElement(q, x));
    }

    public static int findElement(Deque<Integer> q, int x) {
        int left = 0;
        int right = q.size() - 1;

        while (left <= right) {
            if (q.peekFirst() == x) {
                return left;
            }
            if (q.peekLast() == x) {
                return q.size() - 1 - right;
            }
            q.pollFirst();
            q.pollLast();
            left++;
            right--;
        }

        return -1;
    }
}
