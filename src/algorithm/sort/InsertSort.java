package algorithm.sort;

/**
 * @author zz
 * @date 2018/3/2
 */
public class InsertSort extends Sort {

    public void insertSort(int[] src) {
        int j;
        int t;

        for (int i = 1; i < src.length; i++) {
            if (src[i] < src[i - 1]) {
                t = src[i];
                for (j = i - 1; j >= 0 && src[j] > t; j--) {
                    src[j + 1] = src[j];
                }
                src[j + 1] = t;
            }
        }
    }
}
