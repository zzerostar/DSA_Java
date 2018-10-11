package structure;

/**
 * @author zz
 * @date 2018/2/18
 */
public class Elem {

    public int id;

    public String name;

    public Elem(int id) {
        this.id = id;
    }

    public Elem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Elem(String name) {
        this.name = name;
    }

    public String toString() {
        return "[" + id + "," + name + "]";
    }

}
