package algorithm.sort;

/**
 * @author zz
 * @date 2018/3/2
 */
public class BubbleSort extends Sort {

    private static final String TAG = "BubbleSort";

    public void sort0(int[] src) {
        int length = src.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                count++;
                if (src[i] > src[j]) {
                    swap(src, i, j);
                    print(src);
                }
            }
        }
        System.out.print("sort0 count = " + count);

    }

    public void bubbleSort(int[] src) {
        int length = src.length;

        for (int i = 0; i < length; i++) {

            for (int j = length - 1; j > i; j--) {
                if (src[j] < src[j - 1]) {
                    swap(src, j, j - 1);
                }
            }

        }
    }

    public void sort1(int[] src) {

        int length = src.length;
        boolean flag = true;
        int count = 0;
        for (int i = 0; i < length && flag; i++) {
            flag = false;
            for (int j = length - 1; j > i; j--) {
                count++;
                if (src[j] < src[j - 1]) {
                    swap(src, j, j - 1);
                    print(src);
                    flag = true;
                }
            }
        }
        System.out.print("sort1 count = " + count);
    }


}
