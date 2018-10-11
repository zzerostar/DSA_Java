package algorithm.sort;

/**
 * @author zz
 * @date 2018/3/2
 */
public class SelectionSort extends Sort{

    public void selectionSort(int[] src) {
        int length = src.length;

        for (int i = 0; i < length; i++) {
            int min = i;

            for (int j = i + 1; j < length; j++) {
                if (src[min] > src[j]) {
                    min = j;
                }
            }

            if (min != i) {
                swap(src, i, min);
            }
        }
    }
}
