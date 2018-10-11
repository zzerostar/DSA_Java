package util;

import java.util.Random;

/**
 * @author zz
 * @date 2018/2/26
 */
public class Randoms {
    private static Random random = new Random();

    public static void setSeed(long seed) {
        random.setSeed(seed);
    }

    public static float floatStandard() {
        return random.nextFloat();
    }

    public static boolean randomBoolean() {
        return random.nextBoolean();
    }

    public static int randomInt(int start, int end) {
        return random.nextInt(end - start) + start;
    }

    public static float floatAround(float mean, float delta) {
        return floatInRange(mean - delta, mean + delta);
    }

    public static float floatInRange(float left, float right) {
        return left + (right - left) * random.nextFloat();
    }

    public static double positiveGaussian() {
        return Math.abs(random.nextGaussian());
    }
}
