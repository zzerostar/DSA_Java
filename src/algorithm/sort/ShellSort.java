package algorithm.sort;

/**
 * @author zz
 * @date 2018/3/2
 */
public class ShellSort extends Sort {

    public void shellSort(int[] src) {

        int step = src.length / 2;
        while (step != 0) {
            for (int i = 0; i < step; i++) {
                for (int j = i + step; j < src.length; j += step) {
                    int temp = src[j];
                    int k;

                    for (k = j - step; k >= 0 && src[k] > temp; k = k - step) {
                        src[k + step] = src[k];
                    }
                    src[k + step] = temp;
                }
            }
            step = step / 2;
        }
    }
}
