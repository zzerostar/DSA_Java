package apply;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zz
 * @date 2018/2/21
 */
public class Arithmetic {

    public static final char PLUS = '+';
    public static final char REDUCE = '-';
    public static final char MUL = '*';
    public static final char DIV = '/';

    public static final char OPEN_ANGEL = '(';
    public static final char CLOSE_ANGEL = ')';


    public static String toPostfix(String s) {
        Stack<Character> stack = new Stack<Character>();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                stringBuilder.append(c);
            } else {
                if (!stack.empty()) {
                    while (!stack.empty() && priority(c, stack.peek())) {
                        if (judgeAngel(c, stack.peek())) { //右括号匹配
                            stack.pop();
                            break;
                        }
                        stringBuilder.append(stack.pop());
                    }
                    if (c != CLOSE_ANGEL) {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public static List<Character> getPostfixCharList(String s) {
        Stack<Character> stack = new Stack<Character>();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                list.add(c);
            } else {
                if (!stack.empty()) {
                    //Judge priority
                    while (!stack.empty() && priority(c, stack.peek())) {
                        //bracket matching
                        if (judgeAngel(c, stack.peek())) {
                            stack.pop();
                            break;
                        }
                        list.add(stack.pop());
                    }
                    if (c != CLOSE_ANGEL) {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 判断优先级 如果当前的优先级低于或等于栈顶符号,返回true
     *
     * @param src 当前的char
     * @param des 栈顶的char
     * @return
     */
    public static boolean priority(char src, char des) {
        if (src == CLOSE_ANGEL) {
            return true;
        }

        if (src == PLUS || src == REDUCE) {
            if (des == MUL || des == DIV || des == PLUS || des == REDUCE) {
                return true;
            }
        } else if (src == MUL || src == DIV) {
            if (des == MUL || des == DIV) {
                return true;
            }
        }

        return false;

    }

    public static boolean judgeAngel(char src, char des) {
        if (src == CLOSE_ANGEL && des == OPEN_ANGEL) {
            return true;
        }
        return false;
    }

    public static int calculate(List<Character> characters) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < characters.size(); i++) {
            char c = characters.get(i);
            if (Character.isDigit(c)) {
                stack.push(Integer.parseInt(String.valueOf(c)));
            } else {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(operator(y, x, c));
            }
        }

        return stack.pop();
    }

    private static int operator(int x, int y, char operator) {
        int a = Integer.parseInt(String.valueOf(x));
        int b = Integer.parseInt(String.valueOf(y));

        int result = 0;
        switch (operator) {
            case PLUS:
                result = a + b;
                break;

            case REDUCE:
                result = a - b;
                break;

            case MUL:
                result = a * b;
                break;

            case DIV:
                result = a / b;
                break;
        }
        return result;
    }

}
