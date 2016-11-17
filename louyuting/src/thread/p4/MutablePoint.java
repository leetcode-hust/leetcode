package thread.p4;

/**
 * Created by Administrator on 2016/8/31.
 */
public class MutablePoint {

    public int x,y;

    /** 构造器 */
    public MutablePoint() {
        this.x = 0;
        this.y = 0;
    }

    /** 构造器 */
    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}











