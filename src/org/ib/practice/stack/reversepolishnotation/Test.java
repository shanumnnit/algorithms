package org.ib.practice.stack.reversepolishnotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        System.out.println(evalRPN(new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"))));
    }

    public static int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        for (String s : A) {
            try {
                Integer num = Integer.parseInt(s);
                stack.push(num);
                continue;
            } catch (Exception e) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                if (s.equals("+"))
                    stack.push(num2 + num1);
                else if (s.equals("-"))
                    stack.push(num2 - num1);
                else if (s.equals("*"))
                    stack.push(num2 * num1);
                else if (s.equals("/"))
                    stack.push(num2 / num1);
            }
        }
        return stack.pop();
    }
}
