package structure.list.app;

import java.util.LinkedList;

/**
 * @author zz
 * @date 2018/5/30
 */
public class PolynomialAddition {

    public class Item {

        /**
         * 系数
         */
        public int coef;

        /**
         * 指数
         */
        public int expn;

        public Item() {
        }

        public Item(int coef, int expn) {
            this.coef = coef;
            this.expn = expn;
        }

    }

    public LinkedList<Item> add(LinkedList<Item> itemListA, LinkedList<Item> itemListB) {
        LinkedList<Item> results = new LinkedList<>();

        while (itemListA.peekFirst() != null && itemListB.peekFirst() != null) {
            Item itemA = itemListA.peekFirst();
            Item itemB = itemListB.peekFirst();
            if (itemA.expn < itemB.expn) {
                results.add(itemA);
                itemListA.pollFirst();

            } else if (itemA.expn > itemB.expn) {
                results.add(itemB);
                itemListB.pollFirst();

            } else {
                Item item = new Item();
                item.coef = itemA.coef + itemB.coef;
                item.expn = itemA.expn;
                if (item.coef != 0) {
                    results.add(item);
                }
                itemListA.pollFirst();
                itemListB.pollFirst();
            }
        }

        if (itemListA.peekFirst() != null) {
            results.addAll(itemListA);
        }

        if (itemListB.peekFirst() != null) {
            results.addAll(itemListB);
        }

        return results;
    }
}
