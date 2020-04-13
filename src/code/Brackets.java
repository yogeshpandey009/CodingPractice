package code;

import java.util.Stack;

public class Brackets {
    public int solution(String S) {
        Stack<Character> braces = new Stack<Character>();
        for (int i = 0; i < S.length(); i++) {
            char v = S.charAt(i);
            if (v == '(' || v == '{' || v == '[') {
                braces.push(v);
            } else {
                if (!braces.isEmpty()) {
                    Character c = braces.peek();
                    if (c.equals('(') && v == ')') {
                        braces.pop();
                    } else if (c.equals('{') && v == '}') {
                        braces.pop();
                    } else if (c.equals('[') && v == ']') {
                        braces.pop();
                    }
                } else {
                    return 0;
                }
            }
        }
        return braces.size() == 0 ? 1 : 0;
    }
}
