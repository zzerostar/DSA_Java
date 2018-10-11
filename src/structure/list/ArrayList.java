package structure.list;

import structure.Elem;

/**
 * @author zz
 * @date 2018/2/18
 */
public class ArrayList {
    private static final String TAG = "ArrayList";

    private Elem[] datas;

    private final int maxLength;

    private int length;

    public ArrayList(int maxLength) {
        this.maxLength = maxLength;
        datas = new Elem[maxLength];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void clear() {

    }

    public Elem get(int index) {
        if (index >= 0 && index < length - 1) {
            return datas[index];
        } else {
            return null;
        }
    }

    public boolean has(Elem elem) {
        for (int i = 0; i < length - 1; i++) {
            if (elem.equals(datas[i])) {
                return true;
            }
        }
        return false;
    }

    public void insert(Elem e, int index) {
        if (length < maxLength && index <= length) {

            for (int i = length; i > index; i--) {
                datas[i] = datas[i - 1];
            }
            datas[index] = e;
            length++;
        } else {
            System.out.println("ArrayList is full, can not insert");
        }
    }

    public void insertAtLast(Elem e) {
        insert(e, length);
    }

    public void delete(int index) {
        if (index < length) {
            for (int i = index; i < length - 1; i++) {
                datas[i] = datas[i + 1];
            }
            datas[length - 1] = null;
            length--;
        } else {
            System.out.println("ArrayList is empty, can not delete");
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(datas[i].toString()).append(",");
        }
        return stringBuilder.toString();
    }

}
