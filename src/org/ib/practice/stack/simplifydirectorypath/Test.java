package org.ib.practice.stack.simplifydirectorypath;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home///foo/"));
    }

    public static String simplifyPath(String A) {
        String[] strArr = A.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i].equals(".") || strArr[i].equals(""))
                continue;
            if (strArr[i].equals("..")) {
                if (!stack.empty())
                    stack.pop();
                continue;
            }
            stack.push(strArr[i]);
        }
        StringBuilder sb = new StringBuilder("/");
        while (!stack.empty())
            sb.insert(0, "/" + stack.pop());
        if (sb.length() == 1)
            return sb.toString();
        return sb.toString().substring(0, sb.length() - 1);
    }
}
