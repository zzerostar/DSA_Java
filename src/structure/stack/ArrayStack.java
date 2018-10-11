package structure.stack;

import structure.Elem;
import util.LogUtil;

/**
 * @author zz
 * @date 2018/2/20
 */
public class ArrayStack implements Stack {

    private static final String TAG = "ArrayStack";


    private Elem[] datas;

    private int maxLength;

    private int length = 0;

    public ArrayStack(int maxLength) {
        this.maxLength = maxLength;
        datas = new Elem[maxLength];

    }

    @Override
    public Elem pop() {
        if (length > 0) {
            length--;
            Elem elem = datas[length];
            datas[length] = null;
            return elem;
        } else {
            LogUtil.d(TAG, "Stack is empty, can not pop");
            return null;
        }

    }

    @Override
    public void push(Elem e) {
        datas[length] = e;
        length++;
    }

    public int length() {
        return length;
    }

    public String toString() {
        if (length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                stringBuilder.append(datas[i].toString()).append(",");
            }
            return stringBuilder.toString();
        } else {
            return "ArrayStack is empty";
        }

    }

}
