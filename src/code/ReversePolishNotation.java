package code;

import java.util.Stack;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
	Stack<String> s = new Stack<String>();
	int result = 0;
	int op1 = 0;
	int op2 = 0;
	for (int i = 0; i < tokens.length; i++) {
	    String t = tokens[i];
	    if (t.equals("+") || t.equals("-") || t.equals("*")
		    || t.equals("/")) {
		op2 = Integer.parseInt(s.pop());
		op1 = Integer.parseInt(s.pop());
		switch (t) {
		case "+":
		    result = op1 + op2;
		    break;
		case "-":
		    result = op1 - op2;
		    break;
		case "*":
		    result = op1 * op2;
		    break;
		case "/":
		    result = op1 / op2;
		    break;
		}
		s.push(result + "");
	    } else {
		s.push(t);
	    }
	}
	return Integer.parseInt(s.pop());
    }
}