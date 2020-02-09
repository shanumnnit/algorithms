package org.ib.practice.stack.minstack;

import java.util.Stack;

class Solution {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public Solution() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (!minStack.empty())
            minStack.push(Math.min(minStack.peek(), x));
        else minStack.push(x);

    }

    public void pop() {
        if (!mainStack.empty())
            mainStack.pop();
        if (!minStack.empty())
            minStack.pop();
    }

    public int top() {
        if (mainStack.empty())
            return -1;
        return mainStack.peek();
    }

    public int getMin() {
        if (minStack.empty())
            return -1;
        return minStack.peek();
    }
}

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(3);
        solution.push(1);
        solution.push(2);
        System.out.println(solution.getMin());
        solution.pop();
        System.out.println(solution.getMin());
        solution.pop();
        System.out.println(solution.getMin());
        solution.pop();
        System.out.println(solution.getMin());
        solution.pop();
    }
}
