package code;

import java.util.Scanner;
import java.util.Stack;

public class Spreadsheet {
    static String[][] values;
    static boolean[][] evaluated;
    static boolean[][] visiting;
    static double[][] result;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int m = Integer.parseInt(nm[0]);
        int n = Integer.parseInt(nm[1]);
        values = new String[n][m];
        evaluated = new boolean[n][m];
        visiting = new boolean[n][m];
        result = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                values[i][j] = sc.nextLine().trim();
            }
        }
        sc.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    System.out.printf("%.5f\n", result[i][j]);
                } else {
                    System.out.println("Error: circular dependency!");
                }
            }
        }
    }

    private static boolean dfs(int i, int j) {
        if (!evaluated[i][j]) {
            if (visiting[i][j] == true) {
                return false;
            }
            visiting[i][j] = true;
            if (!evaluate(i, j)) {
                return false;
            }
            evaluated[i][j] = true;
            visiting[i][j] = false;
        }
        return true;
    }

    private static boolean evaluate(int i, int j) {
        if (evaluated[i][j])
            return true;
        String[] elems = values[i][j].split(" ");
        Stack<Double> st = new Stack<Double>();
        for (String el : elems) {
            try {
                int number = Integer.parseInt(el);
                st.push((double) number);
            } catch (Exception e) {
                if ("+".equals(el)) {
                    st.push(st.pop() + st.pop());
                } else if ("-".equals(el)) {
                    double op1 = st.pop();
                    double op2 = st.pop();
                    st.push(op2 - op1);
                } else if ("*".equals(el)) {
                    st.push(st.pop() * st.pop());
                } else if ("/".equals(el)) {
                    double op1 = st.pop();
                    double op2 = st.pop();
                    st.push(op2 / op1);
                } else if ("++".equals(el)) {
                    st.push(st.pop() + 1);
                } else if ("--".equals(el)) {
                    st.push(st.pop() - 1);
                } else {
                    int x = el.charAt(0) - 'A';
                    int y = Integer.parseInt(el.substring(1)) - 1;
                    if (!evaluated[x][y]) {
                        if (!dfs(x, y)) {
                            return false;
                        }
                    }
                    st.push(result[x][y]);
                }
            }
        }
        result[i][j] = st.pop();
        return true;
    }
}