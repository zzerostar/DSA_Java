package algorithm.sort;

/**
 * @author zz
 * @date 2018/3/2
 */
public class Sort {


    protected void swap(int[] src, int i, int j) {
        int temp = src[i];
        src[i] = src[j];
        src[j] = temp;
    }

    protected void print(int[] src) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < src.length; i++) {
            stringBuilder.append(src[i]).append(",");
        }
        System.out.println(stringBuilder.toString());
    }
}
