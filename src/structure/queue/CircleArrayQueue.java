package structure.queue;

import structure.Elem;
import util.LogUtil;

/**
 * @author zz
 * @date 2018/2/22
 */
public class CircleArrayQueue implements Queue {

    private static final String TAG = "CircleArrayQueue";

    private Elem[] datas;

    private int maxLength;

    private int front;

    private int rear;

    public CircleArrayQueue(int maxLength) {
        datas = new Elem[maxLength];
        this.maxLength = maxLength + 1;
        front = 0;
        rear = 0;
    }

    @Override
    public Elem deQueue() {
        if (isEmpty()) {
            LogUtil.d(TAG, "Queue is empty, can not deQueue");
            return null;
        }
        Elem temp = datas[front];
        datas[front] = null;
        front++;
        if (front == maxLength) {
            front = 0;
        }
        return temp;
    }

    @Override
    public void enQueue(Elem e) {
        if (isFull()) {
            LogUtil.d(TAG, "Queue is full, can not enQueue");
            return;
        }
        datas[rear] = e;
        rear++;
        if (rear == maxLength) {
            rear = 0;
        }
    }

    public boolean isFull() {
        return (rear + 1) % maxLength == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    @Override
    public int length() {
        return (rear - front + maxLength) % maxLength;
    }
}
