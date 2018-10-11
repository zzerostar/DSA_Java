package structure.stack.app;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zz
 * @date 2018/5/28
 */
public class NumberConversion {

    public static final int SYSTEM_BINARY = 2;

    public static final int SYSTEM_OCTAL = 8;
    public static final int SYSTEM_HEX = 16;

    public static final String HEX_10 = "A";
    public static final String HEX_11 = "B";
    public static final String HEX_12 = "C";
    public static final String HEX_13 = "D";
    public static final String HEX_14 = "E";
    public static final String HEX_15 = "F";

    private Map<Integer, String> hexMap;

    public NumberConversion() {
        hexMap = new HashMap<>();
        hexMap.put(10, HEX_10);
        hexMap.put(11, HEX_11);
        hexMap.put(12, HEX_12);
        hexMap.put(13, HEX_13);
        hexMap.put(14, HEX_14);
        hexMap.put(15, HEX_15);
    }

    public String convert(int num, int system) {
        Stack<String> stack = new Stack<String>();
        while (num > 0) {
            String numStr = getNumber(num, system);
            stack.push(numStr);
            num = num / system;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.empty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    private String getNumber(int num, int system) {
        Map<Integer, String> hexMap = new HashMap<>();
        hexMap.put(10, "A");
        hexMap.put(11, "B");
        hexMap.put(12, "C");
        hexMap.put(13, "D");
        hexMap.put(14, "E");
        hexMap.put(15, "F");

        int mod = num % system;
        if (system == SYSTEM_HEX && mod >= 10) {
            return hexMap.get(mod);
        } else {
            return String.valueOf(mod);
        }
    }

}
