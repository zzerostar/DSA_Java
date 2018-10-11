package structure.stack.app;

/**
 * @author zz
 * @email zzerostar@163.com
 * @date 2018/5/2
 */
public class MazeBlock {

    /**
     * 障碍物
     */
    public static final int TYPE_BLOCK = 1;

    /**
     * 边界
     */
    public static final int TYPE_BORDER = 2;

    /**
     * 通路
     */
    public static final int TYPE_WAY = 3;

    /**
     * 小人儿
     */
    public static final int TYPE_MEN = 4;

    /**
     * 开始位置
     */
    public static final int TYPE_START = 5;

    /**
     * 目的地
     */
    public static final int TYPE_END = 6;

    public static final int TYPE_PATH = 7;


    public int state = TYPE_WAY;

    public boolean hasPassed = false;

    public int posX;
    public int posY;


}
