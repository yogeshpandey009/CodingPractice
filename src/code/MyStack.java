package code;

import java.util.LinkedList;

public class MyStack {
    // Push element x onto stack.
    LinkedList<Integer> active = new LinkedList<Integer>();
    LinkedList<Integer> inactive = new LinkedList<Integer>();
    int top;

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        // s.pop();
        System.out.println(s.top());
        System.out.println(sum(12345));
    }

    static int sum(int num) {

        int total = 0;
        total += +num % 10;

        num = num / 10;

        if (num == 0) {

            return total;

        } else {
            return total + sum(num);
        }

    }

    public void push(int x) {
        top = x;
        active.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (!active.isEmpty()) {
            int v = active.poll();
            if (active.isEmpty()) {
                break;
            }
            top = v;
            inactive.add(v);
        }
        LinkedList<Integer> temp = active;
        active = inactive;
        inactive = temp;
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return active.isEmpty();
    }
}