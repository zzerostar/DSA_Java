package algorithm.sort;

/**
 * @author zz
 * @date 2018/3/5
 */
public class QuickSort extends Sort {

    /**
     * 拆分数组
     * @param src
     * @param start
     * @param end
     * @return
     */
    private int partArr(int[] src, int start, int end) {

        int base = src[end];

        int n = start;

        for (int i = start; i < end; i++) {
            if (src[i] < base) {
                swap(src, i, n);
                n++;
            }
        }
        swap(src, n, end);
        return n;
    }


    public void sort(int[] src) {
        qSort(src, 0, src.length - 1);
    }

    public void qSort(int[] src, int low, int high) {
        int pivot;
        if (low <= high) {
            pivot = partArr(src, low, high);
            print(src);
            System.out.println("pivot = " + pivot);

            qSort(src, low, pivot - 1);
            qSort(src, pivot + 1, high);
        }
    }
}
