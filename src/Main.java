import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import structure.Elem;
import structure.list.DoublyLinkedList;

public class Main {
    public static final String TAG = "Main";

    //    static String s = "(9+(3-1)*3+8/2+";
    //    static String s2 = "2*3/(2-1)+3*(4-1)";
    //    static String s3 = "(23+34*45/(5+6+7))";

    public static void main(String[] args) {

        int[] a = new int[] {
                62, 58, 88, 60, 47, 73, 99, 35, 51, 32, 36, 48, 93, 97, 28, 34
        };

        int[] b = new int[] {
                9, 8, 7, 6, 5, 4, 3, 2, 1, 0
        };

        int[] eg = new int[] {
                9,1,5,8,3,7,4,6,2
        };

        int[] c = new int[] {
                50, 10, 90, 30, 70, 40, 80, 60, 20

        };

        int[] search = new int[] {
                2,3,6,8,9,11,12,15,17,18,19,21,23,25,27,28,30,31,33,35

        };

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insert(new Elem(0, "a"), 0);
        doublyLinkedList.insert(new Elem(1, "b"), 0);
        doublyLinkedList.insert(new Elem(2, "c"), 2);
        doublyLinkedList.insert(new Elem(3, "d"), 3);
        doublyLinkedList.insert(new Elem(4, "e"), 4);
        doublyLinkedList.insert(new Elem(5, "f"), 5);
        doublyLinkedList.print();
        System.out.println();

        doublyLinkedList.delete(0);
        doublyLinkedList.print();
        System.out.println();

//        doublyLinkedList.delete(3);
//        doublyLinkedList.print();

//        LinkedList linkedList = new LinkedList();
//        linkedList.insert(new Elem(0, "a"), 0);
//        linkedList.insert(new Elem(1, "b"), 0);
//        linkedList.insert(new Elem(2, "c"), 2);
//        linkedList.insert(new Elem(3, "d"), 3);
//        linkedList.insert(new Elem(4, "e"), 4);
//        linkedList.insert(new Elem(5, "f"), 5);
//        linkedList.print();
//                System.out.println();
//
//        linkedList.delete(2);
//        linkedList.print();

    }

    /**
     * 检查表达式是否合法，合法返回true
     *
     * @param expression
     * @return
     */
    private static boolean checkExpression(String expression) {
        //去除空格
        expression = expression.replaceAll(" ", "");

        Set<Character> operate_set = new HashSet<>();
        operate_set.add('-');
        operate_set.add('+');
        operate_set.add('*');
        operate_set.add('/');

        //拆分字符串
        char[] arr = expression.toCharArray();
        int len = arr.length;

        //前后括号计数，用来判断括号是否合法
        int checkNum = 0;

        //数字集合
        List<Character> digit_list = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        //循环判断
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(arr[i]) || arr[i] == '.') { //数字和小数点判断
                //把数字和小数点加入到集合中，为了下一步判断数字是否合法
                digit_list.add(arr[i]);
            } else { //非数字和小数点
                //如果集合中有值，取出来判断这个数字整体是否合法
                if (digit_list.size() > 0) {
                    //判断字符串是否合法
                    boolean result = getNumberStringFromList(digit_list);
                    if (result) {
                        //如果合法，清空集合，为了判断下一个
                        digit_list.clear();
                    } else {
                        //不合法，返回false
                        return false;
                    }
                }

                if (arr[i] == '+' || arr[i] == '*' || arr[i] == '/') {
                    //判断规则(1.不能位于首位 2.不能位于末尾 3.后面不能有其他运算符 4.后面不能有后括号)
                    if (i == 0 || i == (len - 1) || operate_set.contains(arr[i + 1]) || arr[i + 1] == ')') {
                        System.out.println("error type : '+' or '*' or '/' ->" + arr[i]);
                        return false;
                    }
                } else if (arr[i] == '-') {
                    //减号判断规则(1.不能位于末尾 2.后面不能有其他运算符 3.后面不能有后括号)
                    if (i == (len - 1) || operate_set.contains(arr[i + 1]) || arr[i + 1] == ')') {
                        System.out.println("error type : '-' ->" + arr[i]);
                        return false;
                    }

                } else if (arr[i] == '(') {
                    checkNum++;
                    //判断规则(1.不能位于末尾 2.后面不能有+，*，/运算符和后括号 3.前面不能为数字)
                    if (i == (len - 1) || arr[i + 1] == '+' || arr[i + 1] == '*' || arr[i + 1] == '/' || arr[i + 1] == ')' || (i != 0 && Character.isDigit(arr[i - 1]))) {
                        System.out.println("error type : '(' ->" + arr[i]);
                        return false;
                    }
                } else if (arr[i] == ')') {
                    checkNum--;
                    //判定规则(1.不能位于首位 2.后面不能是前括号 3.括号计数不能小于0，小于0说明前面少了前括号)
                    if (i == 0 || (i < (len - 1) && arr[i + 1] == '(') || checkNum < 0) {
                        System.out.println("error type : ')' ->" + arr[i]);
                        return false;
                    }
                } else {
                    //非数字和运算符
                    System.out.println("error type : not number and operator ->" + arr[i]);
                    return false;
                }
            }
        }

        //如果集合中有值，取出来判断这个数字整体是否合法
        if (digit_list.size() > 0) {
            //判断字符串是否合法
            boolean result = getNumberStringFromList(digit_list);
            if (result) {
                //如果合法，清空集合，为了判断下一个
                digit_list.clear();
            } else {
                //不合法，返回false
                return false;
            }
        }

        //不为0,说明括号不对等，可能多前括号
        if (checkNum != 0) {
            return false;
        }
        return true;
    }

    /**
     * 把集合中的字符，拼接成字符串，并校验字符串是否是数值
     *
     * @param list
     * @return
     */
    private static boolean getNumberStringFromList(List<Character> list) {
        //如果集合中有值，取出来判断这个数字整体是否合法
        if (list != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (Character character : list) {
                stringBuffer.append(character);
            }
            //正则判断数字是否合法
            boolean result = isNumeric(stringBuffer.toString());

            if (!result) {
                System.out.println("error type: digit ->" + stringBuffer.toString());
            }
            return result;
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }



    private static void Fibonacci(int src) {

        int[] fibonacci = new int[src];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            System.out.println(String.format(format, i, i - 1, i - 2, fibonacci[i]));
            //            System.out.println(i + "-th fibonacci = " + fibonacci[i]);
        }
    }

    static String format = "fibonacci[%1$d] = fibonacci[%2$d] + fibonacci[%3$d] = %4$d";

}
