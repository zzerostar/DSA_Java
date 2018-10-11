package algorithm.sort;

/**
 * @author zz
 * @date 2018/3/5
 */
public class MergeSort extends Sort {

    public void sort(int[] src) {
        sort(src, 0, src.length - 1);
    }


    private void sort(int[] src, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        sort(src, start, mid);
        sort(src, mid + 1, end);
        merge(src, start, mid, end);
    }


    public void mergeSort(int[] src) {
        int len = 1;
        int low = 0;
        int mid;
        int high;

        while (len <= src.length) {
            for (int i = 0; i + len <= src.length - 1; i += len * 2) {
                low = i;
                mid = i + len - 1;
                high = i + len * 2 - 1;
                if (high > src.length - 1) {
                    high = src.length - 1;
                }
                merge(src, low, mid, high);
            }
            len = 2 * len;
        }
    }


    private void merge(int[] src, int start, int mid, int end) {
        int[] tmp = new int[src.length];

        int right = mid + 1;
        int left = start;
        int tmpIndex = start;
        int index = start;

        while (left <= mid && right <= end) {
            if (src[left] <= src[right]) {
                tmp[tmpIndex++] = src[left++];
            } else {
                tmp[tmpIndex++] = src[right++];
            }
        }

        while (left <= mid) {
            tmp[tmpIndex++] = src[left++];
        }

        while (right <= end) {
            tmp[tmpIndex++] = src[right++];
        }

        while (index <= end) {
            src[index] = tmp[index];
            index++;
        }
    }
}
