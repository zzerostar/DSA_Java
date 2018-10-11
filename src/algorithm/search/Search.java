package algorithm.search;

import java.util.ArrayList;
import util.LogUtil;

/**
 * @author zz
 * @date 2018/2/26
 */
public class Search {

    private static final String TAG = "Search";

    public static int linearSearch(int[] src, int key) {
        for (int i = 0; i < src.length; i ++) {
            if (src[i] == key) {
                System.out.println("Find the key !");
                return i;
            }
        }
        System.out.println("Not find the key !");
        return 0;
    }

    /**
     * 二分法查找
     * @param src
     * @param key
     * @return
     */
    public static int binarySearch(int[] src, int key) {
        int low, high, mid;
        low = 0;
        high = src.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key < src[mid]) {
                high = mid - 1;
            } else if (key > src[mid]) {
                low = mid + 1;
            } else {
                System.out.println("Find the key !");
                return mid;
            }
        }
        System.out.println("Not find the key !");
        return 0;
    }

    /**
     * 插值查找
     * @param src
     * @param key
     * @return
     */
    public static int interpolation(int[] src, int key) {
        int low, high, mid;
        low = 0;
        high = src.length - 1;
        while (low <= high) {
            mid = low + (high - low) * (key - src[low]) / (src[high] - src[low]);
            if (key < src[mid]) {
                high = mid - 1;
            } else if (key > src[mid]) {
                low = mid + 1;
            } else {
                System.out.println("Find the key !");
                return mid;
            }
        }
        System.out.println("Not find the key !");
        return 0;
    }

    //todo int溢出问题
    public static int fibonacciSearch(ArrayList<Integer> arrayList, int key) {
        int n = arrayList.size() - 1;
        Fibonacci(n);

        int low, high ,mid;
        int i, k;

        low = 0;
        high = arrayList.size();
        k = 0;

        while (n > fibonacci[k] - 1) {
            k++;
        }

        for (i = n; i < fibonacci[k] - 1; i++) {
            arrayList.add(arrayList.get(n));
        }

        int cycleCount = 0;

        while (low <= high) {
            cycleCount ++;
            mid = low + fibonacci[k-1] - 1;
            if (key < arrayList.get(mid)) {
                high = mid - 1;
                k--;
            } else if (key > arrayList.get(mid)) {
                low = mid + 1;
                k = k - 2;
            } else {
                LogUtil.d(TAG, " fibonacci查找 循环次数 = " + cycleCount);
                return key;
            }
        }
        return 0;

    }

    private static int[] fibonacci;


    private static void Fibonacci(int n) {
        fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < n; i ++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
    }
}
