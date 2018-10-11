package structure.queue;

import structure.Elem;

/**
 * @author zz
 * @date 2018/2/22
 */
public interface Queue {

    Elem deQueue();

    void enQueue(Elem e);

    int length();
}
