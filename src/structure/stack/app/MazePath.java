package structure.stack.app;

import java.util.Stack;

/**
 * @author zz
 * @date 2018/5/30
 */
public class MazePath {

    private Path[][] mPaths;

    public class Path {
        public boolean hasPassBy = false;
        public int posX;
        public int posY;
        public int di;
        public boolean canPass;
    }

    public void path(Path[][] paths) {
        this.mPaths = paths;

        int rowCount = paths[0].length;
        Stack<Path> stack = new Stack<>();
        Path curPos;
        Path path;
        int curStep = 0;
        curPos = mPaths[1][1];
        path = curPos;
        do {
            if (canPass(curPos.posX, curPos.posY)) {
                mPaths[curPos.posX][curPos.posY].hasPassBy = true;
                stack.push(curPos);
                curStep++;

                if (curPos.posX == rowCount - 2
                        && curPos.posY == rowCount - 2) {
                    System.out.println("Find the exit !");
                    return;
                }
                curPos =
                        getNext(curPos.posX, curPos.posY, curPos.di);
            } else {

                if (!stack.empty()) {
                    path = stack.pop();
                    curStep--;

                    while (path.di == 3 && !stack.empty()) {
                        mPaths[path.posX][path.posY].hasPassBy = true;
                        path = stack.pop();
                        curStep--;
                    }

                    if (path.di < 3) {
                        path.di++;
                        stack.push(path);
                        curStep++;
                        curPos =
                                getNext(path.posX, path.posY, path.di);
                    }
                }
            }
        } while (!stack.empty());

        System.out.println("There is no route to the exit !");
    }

    private boolean canPass(int x, int y) {
        Path path = mPaths[x][y];
        return path.canPass && !path.hasPassBy;
    }

    private Path getNext(int x, int y, int di) {
        int posX = x;
        int posY = y;

        if (di == 0) {
            posY += 1;
        } else if (di == 1) {
            posX += 1;
        } else if (di == 2) {
            posY -= 1;
        } else if (di == 3) {
            posX -= 1;
        }
        return mPaths[posX][posY];
    }

}
